/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.lchacon.agility.ws.client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;

/**
 * Jersey REST client generated for REST resource:we [talentoHumano]<br>
 * USAGE:
 * <pre>
 *        ClienteTalentoHumano client = new ClienteTalentoHumano();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author fercris
 */
public class ClienteTalentoHumano {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:21674/ServiciosWeb/webresources/";

    public ClienteTalentoHumano() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("talentoHumano");
    }

    /**
     * @param <T>
     * @param responseType Class representing the response
     * @param usrId query parameter
     * @param usrClave query parameter
     * @return response object (instance of responseType class)
     */
    public <T> T validarUsuario(Class<T> responseType, String usrId, String usrClave) throws ClientErrorException {
        String[] queryParamNames = new String[]{"usrId", "usrClave"};
        String[] queryParamValues = new String[]{usrId, usrClave};
     
        javax.ws.rs.core.Form form = getQueryOrFormParams(queryParamNames, queryParamValues);
        javax.ws.rs.core.MultivaluedMap<String, String> map = form.asMap();
        for (java.util.Map.Entry<String, java.util.List<String>> entry : map.entrySet()) {
            java.util.List<String> list = entry.getValue();
            String[] values = list.toArray(new String[list.size()]);
            webTarget = webTarget.queryParam(entry.getKey(), (Object[]) values);
        }
        return webTarget.request().get(responseType);
    }

    private Form getQueryOrFormParams(String[] paramNames, String[] paramValues) {
        Form form = new javax.ws.rs.core.Form();
        for (int i = 0; i < paramNames.length; i++) {
            if (paramValues[i] != null) {
                form = form.param(paramNames[i], paramValues[i]);
            }
        }
        return form;
    }

    public void close() {
        client.close();
    }
    
}
