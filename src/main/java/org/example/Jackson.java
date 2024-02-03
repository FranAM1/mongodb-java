package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.mongodb.DBObject;

import org.bson.Document;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Jackson {
    private boolean checkIfFileExists(File file) {
        if (!file.exists()) {
            System.out.println("Fichero no encontrado");
            return false;
        }
        return true;
    }

    public List<Document> convertXML(File file) {
        if (!checkIfFileExists(file)) {
            return null;
        }
        List<Document> documentsBookings = new ArrayList<>();

        try {
            XmlMapper xmlMapper = new XmlMapper();
            List<Booking> bookings = xmlMapper.readValue(file, new TypeReference<List<Booking>>() {
            });

            for (Booking booking : bookings) {
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonNode = objectMapper.valueToTree(booking);
                Document document = Document.parse(jsonNode.toString());
                documentsBookings.add(document);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return documentsBookings;
    }
}
