package com.aviation.core.service;

import com.aviation.core.entity.FlightEntity;
import com.aviation.core.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FlightService {
    private JsonFormat jsonFormat;
    private XmlFormat xmlFormat;
    private YamlFormat yamlFormat;
    private TxtFormat txtFormat;
    @Autowired
    public FlightService(JsonFormat jsonFormat,XmlFormat xmlFormat, YamlFormat yamlFormat,TxtFormat txtFormat){
        this.jsonFormat=jsonFormat;
        this.xmlFormat=xmlFormat;
        this.yamlFormat=yamlFormat;
        this.txtFormat=txtFormat;
    }
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private FlightEntity flight;
    public  String getFlightInfo(Long id,String format)throws Exception {
        flight=flightRepository.findById(id).orElseThrow(()->new RuntimeException("Flight not found"));
        switch(format.toLowerCase()){
            case "json":
                return jsonFormat.convertToJson(flight);
            case "xml":
                return xmlFormat.convertToXml(flight);
            case "yaml":
                return yamlFormat.convertToYaml(flight);
            case "txt":
                return txtFormat.convertToTxt(flight);
            default:
                throw new RuntimeException("Unknown type:"+format);
        }
    }
    public List<FlightEntity>getAllFlights(){
        return flightRepository.findAll();
    }
    public FlightEntity saveFlight(FlightEntity flight){
        return flightRepository.save(flight);
    }
    public void deleteFlight(Long id){
        flightRepository.deleteById(id);
    }
}
