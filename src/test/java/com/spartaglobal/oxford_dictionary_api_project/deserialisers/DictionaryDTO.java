package com.spartaglobal.oxford_dictionary_api_project.deserialisers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.spartaglobal.oxford_dictionary_api_project.httpServices.HTTPClient;
import netscape.javascript.JSObject;
import org.apache.http.client.methods.HttpGet;
import org.json.simple.JSONArray;

import java.util.LinkedHashMap;
import java.util.Map;

public class DictionaryDTO {

        private String metadata;

        public JSONArray id;

        private JSONArray results;

        private String word;

//        JsonNode id = ;



    public String getMetadata ()
        {
            return metadata;
        }

        public void setMetadata ()
        {
            this.metadata = metadata;
        }

        public JSONArray getId ()
        {
            return id;
        }

        public void setId (JSONArray id)
        {
            this.id = id;
        }

        public JSONArray getResults ()
        {
            return results;
        }

        public void setResults ()
        {
            this.results = results;
        }

        public String getWord ()
        {
            return word;
        }

        public void setWord (String word)
        {
            this.word = word;
        }

    }

