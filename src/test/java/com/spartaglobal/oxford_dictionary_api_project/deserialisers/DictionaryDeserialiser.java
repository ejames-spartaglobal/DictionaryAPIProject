package com.spartaglobal.oxford_dictionary_api_project.deserialisers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.fasterxml.jackson.databind.JsonNode;


import java.io.IOException;

public class DictionaryDeserialiser {
//    public DictionaryDTO dictionaryMapped;
//    public ResultsDTO resultsMapped;
    public static JsonNode rootNode;

    public DictionaryDeserialiser(String jsonString) {

        ObjectMapper objectMapper = new ObjectMapper();


        try {
            rootNode = objectMapper.readTree(jsonString);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
