package org.example;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        Jackson jackson = new Jackson();
        File file = new File("bookings.xml");

        String json = jackson.convertXMLtoJSON(file);


        //Add the json to de mongodb database
        MongoDBConnector mongoDBConnector = new MongoDBConnector();
        mongoDBConnector.getDatabase().getCollection("bookings").insertMany(json);
    }
}