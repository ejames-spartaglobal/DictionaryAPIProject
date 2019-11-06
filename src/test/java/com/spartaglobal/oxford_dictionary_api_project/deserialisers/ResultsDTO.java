package com.spartaglobal.oxford_dictionary_api_project.deserialisers;

import org.json.simple.JSONArray;

public class ResultsDTO {
    public class Results
    {
        private JSONArray lexicalEntries;

        private String language;

        private String id;

        private String type;

        private String word;

        public JSONArray getLexicalEntries ()
        {
            return lexicalEntries;
        }

        public void setLexicalEntries (JSONArray lexicalEntries)
        {
            this.lexicalEntries = lexicalEntries;
        }

        public String getLanguage ()
        {
            return language;
        }

        public void setLanguage (String language)
        {
            this.language = language;
        }

        public String getId ()
        {
            return id;
        }

        public void setId (String id)
        {
            this.id = id;
        }

        public String getType ()
        {
            return type;
        }

        public void setType (String type)
        {
            this.type = type;
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
}
