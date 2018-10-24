package com.konex.messenger.service.API;

import com.google.gson.Gson;
import com.konex.messenger.utils.Constants;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * created by user violence
 * created on 19.10.2018
 * class created for project messenger
 */

@Service
public class ApiRedirectServiceImpl implements ApiRedirectService {

    public RestTemplate template = new RestTemplate();
    public Map<String, String> jsession=null;

    @Override
    @PostConstruct
    public void redirectApiAuth(){
        String url= Constants.REDIRECT_URL + "/login";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("mobile", "vetal");
        map.add("password", "1234");
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        try {
            ResponseEntity<String> entity = template.postForEntity(url, request, String.class);
            Gson gson = new Gson();
            jsession = gson.fromJson(entity.getBody().toString(), Map.class);
            //System.out.println(jsession.get("JSESSIONID") + " - " + entity.getStatusCode());
        }catch (HttpClientErrorException e) {
            //System.err.println("status code "+e.getStatusCode());
        }
        catch(Exception e){
            jsession=null;
            //e.printStackTrace();
        }
    }

    @Override
    public String send_get_request(String url){
        String result=null;
        ResponseEntity<String> entity =null;
        try {
            entity = template.exchange(url, HttpMethod.GET, setCookie(), String.class);
            System.out.println(entity.getStatusCode());
            result = entity.getBody().toString();
        }catch(HttpClientErrorException e){
//            System.err.println("status code "+e.getStatusCode());
            if(e.getStatusCode().equals(HttpStatus.UNAUTHORIZED) || e.getStatusCode().equals(HttpStatus.FORBIDDEN)) {
                reloginToRedirectServer();
                entity = template.exchange(url, HttpMethod.GET, setCookie(), String.class);
                System.out.println(entity.getStatusCode());
                result = entity.getBody().toString();
            }
        }catch (NullPointerException e){
            result=null;
        }
        return result;
    }

    @Override
    public HttpEntity setCookie(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        if(jsession!=null) {
            headers.set("Cookie", "JSESSIONID=" + jsession.get("JSESSIONID"));
        }
        return new HttpEntity(null, headers);
    }

    private HttpEntity setBody(HttpEntity httpEntity, Object content){
//        MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
//        ObjectMapper mapper = new ObjectMapper();
////        try {
//            body.add("object", content.getClass().getName());
//            body.add("content", content.toString());
////        } catch (JsonProcessingException e) {
////            e.printStackTrace();
////        }
        return new HttpEntity(content.toString(), httpEntity.getHeaders());
    }

    @Override
    public String send_post_request(String url, Object body) {
        System.out.println("URL====="+url);
        System.out.println("body====="+body);
        String result=null;
        ResponseEntity<String> entity =null;
        try {
            entity = template.exchange(url, HttpMethod.POST, setBody(setCookie(),body), String.class);
//            System.out.println(entity.getStatusCode());
            //System.out.println(entity.getBody().toString());
            result = entity.getBody().toString();
        }catch(Exception e){
//            System.err.println("status code "+e.getMessage());
//            if(e.getStatusCode().equals(HttpStatus.UNAUTHORIZED) || e.getStatusCode().equals(HttpStatus.FORBIDDEN)) {
            reloginToRedirectServer();
            entity = template.exchange(url, HttpMethod.POST, setBody(setCookie(),body), String.class);
            System.out.println(entity.getStatusCode());
            result = entity.getBody().toString();
//            }
        }
        return result;
    }


    @Override
    public InputStream send_get_request_stream(String url){
        InputStream result=null;
        ResponseEntity<Resource> entity =null;
        try {
            entity = template.exchange(url, HttpMethod.GET, setCookie(), Resource.class);
            System.out.println(entity.getStatusCode());
            result = entity.getBody().getInputStream();
        }catch(HttpClientErrorException e){
//            System.err.println("status code "+e.getStatusCode());
            if(e.getStatusCode().equals(HttpStatus.UNAUTHORIZED) || e.getStatusCode().equals(HttpStatus.FORBIDDEN)) {
                reloginToRedirectServer();
                entity = template.exchange(url, HttpMethod.GET, setCookie(), Resource.class);
                System.out.println(entity.getStatusCode());
                try {
                    result = entity.getBody().getInputStream();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e){
            System.err.println("its all");
        }
        return result;
    }


    private boolean reloginToRedirectServer(){
        boolean result=false;
        redirectApiAuth();
        if(jsession!=null){
            result=true;
        }
        return result;
    }
}
