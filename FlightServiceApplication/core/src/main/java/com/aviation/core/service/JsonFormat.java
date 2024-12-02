package com.aviation.core.service;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonFormat {
    private ObjectMapper objectMapper;
    public JsonFormat(){
        this.objectMapper=new ObjectMapper();
    }
    public  String convertToJson(Object object)throws Exception {
        return objectMapper.writeValueAsString(object);
    }
}
