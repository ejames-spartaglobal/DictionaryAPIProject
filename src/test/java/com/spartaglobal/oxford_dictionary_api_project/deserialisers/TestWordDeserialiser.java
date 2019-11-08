package com.spartaglobal.oxford_dictionary_api_project.deserialisers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class TestWordDeserialiser {

    public JsonNode testRoot;

    public TestWordDeserialiser(String jsonString) {

        ObjectMapper objectMapper = new ObjectMapper();


        try {
            testRoot = objectMapper.readTree(jsonString);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
