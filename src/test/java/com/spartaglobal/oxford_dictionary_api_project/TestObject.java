package com.spartaglobal.oxford_dictionary_api_project;

import com.fasterxml.jackson.databind.JsonNode;
import com.spartaglobal.oxford_dictionary_api_project.deserialisers.DictionaryDTO;
import com.spartaglobal.oxford_dictionary_api_project.deserialisers.DictionaryDeserialiser;
import com.spartaglobal.oxford_dictionary_api_project.deserialisers.TestWordDeserialiser;
import com.spartaglobal.oxford_dictionary_api_project.httpServices.HTTPClient;
import org.json.simple.JSONArray;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class TestObject {
    private static HTTPClient httpClient=new HTTPClient("en-gb/","house");
    private static DictionaryDeserialiser dictionary;
    private static TestWordDeserialiser file;
    private static JsonNode resultsNode;
    private JsonNode lexical;

//    private File testFile;

    @BeforeClass
    public static void setup(){
        httpClient.executeEntryGetRequest();
        dictionary=new DictionaryDeserialiser(httpClient.getFixerEntryJSONString());
        resultsNode=dictionary.rootNode.path("results");

//        file=new TestWordDeserialiser("resources/word.json");
//        File testFile=new File("resources/word.json");


    }

//    @Test
//    public void test(){
//        System.out.println(httpClient.getFixerEntryJSONString());
//        Assert.assertEquals(testFile.toString(),httpClient.getFixerEntryJSONString());
//    }


    @Test
    public void testID() {
        JsonNode idNode= dictionary.rootNode.path("id");
        String ans = idNode.toString();
        Assert.assertEquals("\"" + httpClient.word + "\"",ans);
        System.out.println(ans);
    }

    @Test
    public void testMetadata(){
        JsonNode metadataNode=dictionary.rootNode.path("metadata");
        System.out.println(metadataNode.toString());
    }

    @Test
    public void testResult(){
        System.out.println(resultsNode.toString());
    }

    @Test
    public void testLexicalEntries(){
            for (JsonNode node: resultsNode) {
                lexical =node.path("lexicalEntries");
                String lexicalEntries= lexical.toString();
                System.out.println(lexicalEntries);
            }
    }

    @Test
    public void testDerivatives(){
        for (JsonNode node: lexical)
        {
            JsonNode derivatives = node.path("derivatives");
            String derivString= derivatives.toString();
            System.out.println(derivString);
        }
    }
}
