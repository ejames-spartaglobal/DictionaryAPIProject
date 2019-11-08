package com.spartaglobal.oxford_dictionary_api_project;

import com.fasterxml.jackson.databind.JsonNode;
import com.spartaglobal.oxford_dictionary_api_project.deserialisers.DictionaryDTO;
import com.spartaglobal.oxford_dictionary_api_project.deserialisers.DictionaryDeserialiser;
import com.spartaglobal.oxford_dictionary_api_project.deserialisers.TestWordDeserialiser;
import com.spartaglobal.oxford_dictionary_api_project.httpServices.HTTPClient;
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
        System.out.println(idNode.toString());
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
        JsonNode lexical = dictionary.rootNode.path("results").path("lexicalEntries");
        String lex = lexical.toString();
        System.out.println(lex);
    }
}
