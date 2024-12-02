package com.aviation.core.service;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TxtFormat {
    private ObjectMapper objectMapper;
    public TxtFormat()throws Exception{
        this.objectMapper=new ObjectMapper();
    }
    public String convertToTxt(Object object){
        return objectMapper.writeValueAsString(object);
    }

}
