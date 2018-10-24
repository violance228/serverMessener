package com.konex.messenger.service.API;

import com.konex.messenger.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;

/**
 * created by user violence
 * created on 19.10.2018
 * class created for project messenger
 */

@Service
public class SendApiReqestServiceImpl implements SendApiReqestService {

    @Autowired
    ApiRedirectService apiRedirectService;

    @Override
    public String sendJSONToOfficeServer(String json) {
        String url= Constants.REDIRECT_URL + "/redirection/api/document/konex/getFromPharmacy";
        return apiRedirectService.send_post_request(url, json);
    }

    @Override
    public String getFrom1s(String json) {
        String url= Constants.REDIRECT_URL + "/redirection/api/document/konex/getFrom1s";
        return apiRedirectService.send_post_request(url, json);
    }

//    @Override
//    public String getNewDocumentListId() {
//        String url= Constants.REDIRECT_URL + "/redirection/api/document/konex/getNewDocumentListId/"+Constants.THIS_TRADE_POINT_ID;
//        return apiRedirectService.send_get_request(url);
//    }

    @Override
    public String getJsonByUploadPlanId(Long id) {
        String url= Constants.REDIRECT_URL + "/redirection/api/document/konex/getJsonByUploadPlanId/"+id;
        return apiRedirectService.send_get_request(url);
    }

    @Override
    public String confirmReceived(Long id){
        String url= Constants.REDIRECT_URL + "/redirection/api/document/konex/confirmReceived/"+id;
        return apiRedirectService.send_get_request(url);
    }

    @Override
    public String sendNewDoc(Object o) {
        String url= Constants.REDIRECT_URL + "/redirection/api/document/konex/sendNewDoc/";
        return apiRedirectService.send_post_request(url, o);
    }

    @Override
    public String sendInternetOrderToKonex(String orderJson) {
        String url= Constants.REDIRECT_URL + "/redirection/api/order/konex24/changeOrder";
        return apiRedirectService.send_post_request(url, orderJson);
    }

    @Override
    public String internetOrderStatusUpdate(Long internetOrder,Long internetOrderStatus) {
        String url= Constants.REDIRECT_URL + "/redirection/api/order/konex24/changeOrderStatus/"+internetOrder+"/"+internetOrderStatus;
        return apiRedirectService.send_get_request(url);
    }

    @Override
    public String getCatalogByCatalogId(Integer catalogId) {
        String url= Constants.REDIRECT_URL + "/redirection/api/document/konex/getCatalogByEnum/"+catalogId;
        return apiRedirectService.send_get_request(url);
    }

    @Override
    public String getCatalogByCatalogId(Integer catalogId, int page, int size) {
        String url= Constants.REDIRECT_URL + "/redirection/api/document/konex/getPageCatalogByEnum/"+page+"/"+size+"/"+catalogId;
        return apiRedirectService.send_get_request(url);
    }

    @Override
    public InputStream getCatalogStreamByCatalogId(Integer catalogId, int page, int size) {
        String url= Constants.REDIRECT_URL + "/redirection/api/document/konex/getPageCatalogByEnum/"+page+"/"+size+"/"+catalogId;
        return apiRedirectService.send_get_request_stream(url);
    }
}
