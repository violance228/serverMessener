package com.konex.messenger.service.API;

import org.springframework.http.HttpEntity;

import java.io.InputStream;
import java.util.Map;

/**
 * created by user violence
 * created on 19.10.2018
 * class created for project messenger
 */


public interface ApiRedirectService {

    Map<String, String> jsession=null;
    void redirectApiAuth();

    String send_get_request(String url);

    HttpEntity setCookie();

    String send_post_request(String url, Object body);

    InputStream send_get_request_stream(String url);
}
