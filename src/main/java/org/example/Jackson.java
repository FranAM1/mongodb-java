package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;

public class Jackson {
    private boolean checkIfFileExists(File file) {
        if (!file.exists()) {
            System.out.println("Fichero no encontrado");
            return false;
        }
        return true;
    }

    public String convertXMLtoJSON(File file) {
        if (!checkIfFileExists(file)) {
            return null;
        }

        try{
            ObjectMapper objectMapper = new ObjectMapper();
            XmlMapper xmlMapper = new XmlMapper();

            JsonNode node = xmlMapper.readTree(file);
            String json = objectMapper.writeValueAsString(node);

            return json;
        }catch (Exception e){
            System.out.println("Error al convertir el fichero a json");
            return null;
        }
    }
}
