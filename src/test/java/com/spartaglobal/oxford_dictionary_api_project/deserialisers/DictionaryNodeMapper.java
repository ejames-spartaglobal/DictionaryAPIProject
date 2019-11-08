package com.spartaglobal.oxford_dictionary_api_project.deserialisers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.fasterxml.jackson.databind.JsonNode;


import java.io.IOException;

public class DictionaryNodeMapper {
    //    public DictionaryDTO dictionaryMapped;
//    public ResultsDTO resultsMapped;
    public JsonNode rootNode;
    public JsonNode idNode;
    public JsonNode metaDataNode;
    public JsonNode resultsNode;
    public JsonNode lexicalNode;

    public DictionaryNodeMapper(String jsonString) {

        ObjectMapper objectMapper = new ObjectMapper();


        try {
            rootNode = objectMapper.readTree(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void NodeMapper() {


    }

    public JsonNode getIdNode() {
        idNode = rootNode.path("id");
        return idNode;
    }

    public JsonNode getResultsNode() {
        resultsNode = rootNode.path("results");
        return resultsNode;
    }

    public JsonNode getMetaDataNode() {
        metaDataNode = rootNode.path("metadata");
        return metaDataNode;
    }

    public JsonNode getLexicalEntriesNode() {
        for (JsonNode node : getResultsNode()) {
            lexicalNode = node.path("lexicalEntries");


        }
        return lexicalNode;
    }
}

