package com.aviation.core.format;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileFormat {
    private static final ObjectMapper objectMapper=new ObjectMapper();
    private static final XmlMapper xmlMapper=new XmlMapper();
    private static final YAMLMapper yamlMapper=new YAMLMapper();
    // Запись в JSON(Jackson)
    public static void writeToJson(List<?> data, String fileName) throws IOException {
        objectMapper.writeValue(new File(fileName), data);
    }
    // Запись в XML(Надо с помощью JAXB)
    public static void writeToXml(List<?> data, String fileName) throws IOException {
        xmlMapper.writeValue(new File(fileName), data);
    }
    // Запись в YAML
    public static void writeToYaml(List<?> data, String fileName) throws IOException {
        yamlMapper.writeValue(new File(fileName), data);
    }
    // Запись в TXT
    public static void writeToTxt(List<?> data, String fileName) throws IOException {
        try (FileWriter writer = new FileWriter(new File(fileName))) {
            for (Object item : data) {
                writer.write(item.toString() + "\n");
            }
        }
    }
}
