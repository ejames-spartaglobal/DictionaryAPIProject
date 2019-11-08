package com.spartaglobal.oxford_dictionary_api_project.httpServices;

import com.spartaglobal.oxford_dictionary_api_project.config.APIKeyAndID;
import com.spartaglobal.oxford_dictionary_api_project.config.OxfordDictionaryURLConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.concurrent.Callable;

public class HTTPClient {
    private CloseableHttpResponse fixerResponse;
    private String fixerEntryJSONString;
    public String word;
    private String language;

    public HTTPClient(String language,String word) {
        this.word = word;
        this.language=language;
    }

    public void executeEntryGetRequest(){
        CloseableHttpClient closeableHttpClient= HttpClients.createDefault();
        String entriesURL = OxfordDictionaryURLConfig.BASEURL + OxfordDictionaryURLConfig.ENTRIESURL + language + word;
        HttpGet httpGet = new HttpGet(entriesURL);
        httpGet.addHeader( "app_ID",APIKeyAndID.appID);
        httpGet.addHeader("app_key",APIKeyAndID.appKey);

        try {
            fixerResponse = closeableHttpClient.execute(httpGet);
            fixerEntryJSONString= EntityUtils.toString(fixerResponse.getEntity());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public CloseableHttpResponse getFixerResponse() {
        return fixerResponse;
    }

    public String getFixerEntryJSONString() {
        return fixerEntryJSONString;
    }
}