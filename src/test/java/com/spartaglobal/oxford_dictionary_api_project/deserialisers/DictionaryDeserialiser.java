package com.spartaglobal.oxford_dictionary_api_project.deserialisers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;

import java.io.IOException;

public class DictionaryDeserialiser {
    public DictionaryDTO dictionaryMapped;
    public ResultsDTO resultsMapped;

    public DictionaryDeserialiser(String jsonString) {

        ObjectMapper objectMapper = new ObjectMapper();

        try {
                dictionaryMapped = objectMapper.readValue(jsonString, DictionaryDTO.class);
                resultsMapped = objectMapper.readValue(jsonString,ResultsDTO.class);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
