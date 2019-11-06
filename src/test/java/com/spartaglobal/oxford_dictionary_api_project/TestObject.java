package com.spartaglobal.oxford_dictionary_api_project;

import com.spartaglobal.oxford_dictionary_api_project.deserialisers.DictionaryDTO;
import com.spartaglobal.oxford_dictionary_api_project.deserialisers.DictionaryDeserialiser;
import com.spartaglobal.oxford_dictionary_api_project.httpServices.HTTPClient;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class TestObject {
    private static HTTPClient httpClient=new HTTPClient("en-gb/","house");
    //private static DictionaryDeserialiser dictionary;

    @BeforeClass
    public static void setup(){
        httpClient.executeEntryGetRequest();
       // dictionary=new DictionaryDeserialiser(httpClient.getFixerEntryJSONString());
    }

    @Test
    public void test(){
        System.out.println(httpClient.getFixerEntryJSONString());

    }

//
//    @Test
//    public void testID() {
//        for (Map.Entry<String, LinkedHashMap> entry:dictionary.dictionaryMapped.id.entrySet()){
//            System.out.println(entry+"\t"+ entry.getValue());
//        }
//    }
}
