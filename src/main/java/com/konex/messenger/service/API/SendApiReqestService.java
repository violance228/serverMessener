package com.konex.messenger.service.API;

import java.io.InputStream;

/**
 * created by user violence
 * created on 19.10.2018
 * class created for project messenger
 */


public interface SendApiReqestService {

    String sendJSONToOfficeServer(String json);

    String getFrom1s(String json);

//    String getNewDocumentListId();

    String getJsonByUploadPlanId(Long id);

    String confirmReceived(Long id);

    String sendNewDoc(Object o);

    String sendInternetOrderToKonex(String orderJson);

    String internetOrderStatusUpdate(Long internetOrder,Long internetOrderStatus);

    String getCatalogByCatalogId(Integer catalogId);

    String getCatalogByCatalogId(Integer catalogId, int page, int size);

    InputStream getCatalogStreamByCatalogId(Integer catalogId, int page, int size);

}
