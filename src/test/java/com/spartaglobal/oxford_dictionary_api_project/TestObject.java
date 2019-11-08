package com.spartaglobal.oxford_dictionary_api_project;

import com.fasterxml.jackson.databind.JsonNode;
import com.spartaglobal.oxford_dictionary_api_project.deserialisers.DictionaryNodeMapper;
import com.spartaglobal.oxford_dictionary_api_project.deserialisers.TestWordDeserialiser;
import com.spartaglobal.oxford_dictionary_api_project.httpServices.HTTPClient;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestObject {
    private static HTTPClient httpClient=new HTTPClient("en-gb/","house");
    private static DictionaryNodeMapper dictionary;
    private JsonNode lexical;

//    private File testFile;

    @BeforeClass
    public static void setup(){
        httpClient.executeEntryGetRequest();
        dictionary=new DictionaryNodeMapper(httpClient.getFixerEntryJSONString());
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
        System.out.println(dictionary.rootNode.toString());
    }

    @Test
    public void testMetadata(){
        System.out.println(dictionary.getMetaDataNode().toString());
    }

    @Test
    public void testResult(){
        System.out.println(dictionary.getResultsNode().toString());
    }

    @Test
    public void testLexicalEntries(){
        String lexicalEntries= dictionary.getLexicalEntriesNode().toString();
        System.out.println(lexicalEntries);
    }


    @Test
    public void testDerivatives(){
//        System.out.println(lexical.toString());
        for (JsonNode node:dictionary.getLexicalEntriesNode()){
                JsonNode derivatives = node.path("derivatives");
                String derivativeString= derivatives.toString();
                System.out.println(derivativeString);
        }
    }

     @Test
     public void testEntries(){
         for (JsonNode node:dictionary.getLexicalEntriesNode()){
             JsonNode entries = node.path("entries");
             String entriesString= entries.toString();
             System.out.println(entriesString);
         }
     }

    @Test
    public void testWord(){
        JsonNode idNode= dictionary.rootNode.path("id");
        JsonNode wordNode = dictionary.rootNode.path("word");
        Assert.assertEquals(idNode,wordNode);
    }

}

