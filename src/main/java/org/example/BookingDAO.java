package org.example;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

import java.io.File;
import java.util.List;

public class BookingDAO {
    MongoDBConnector mongoDBConnector;
    MongoCollection<Document> collection;

    public BookingDAO() {
        this.mongoDBConnector = new MongoDBConnector();
        this.collection = mongoDBConnector.getDatabase().getCollection("reserves");
        if (collection.countDocuments() == 0){
            loadXML();
        }
    }

    private void loadXML(){
        Jackson jackson = new Jackson();
        File file = new File("bookings.xml");
        List<Document> json = jackson.convertXML(file);

        if (json != null){
            collection.insertMany(json);
            System.out.println("Datos insertados correctamente");
        }
    }

    public void insertReservas(Booking booking) {
        if (!checkPrice(booking.getPrice())){
            System.out.println("El precio no es válido");
            return;
        }
        else if (!checkDate(booking.getCheckIn())){
            System.out.println("La fecha no es válida");
            return;
        }
        Document bookingDocument = new Document();
        bookingDocument.append("location_number", booking.getLocationNumber());
        bookingDocument.append("client", booking.getClient());
        bookingDocument.append("agency", booking.getAgency());
        bookingDocument.append("room", booking.getRoom());
        bookingDocument.append("price", booking.getPrice());
        bookingDocument.append("hotel", booking.getHotel());
        bookingDocument.append("check_in", booking.getCheckIn());
        bookingDocument.append("room_nights", booking.getRoomNights());
        mongoDBConnector.getDatabase().getCollection("reserves").insertOne(bookingDocument);
        System.out.println("Reserva añadida correctamente");
    }

    public void mostrarReservas(){
        MongoCursor<Document> cursor = collection.find().iterator();
        try {
            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }
    }

    public void actualizarPrecioReserva(int locationNumber, String price){
        if (!checkPrice(price)){
            System.out.println("El precio no es válido");
            return;
        }
        if (checkIfBookingExists(locationNumber)){
            collection.updateOne(Filters.eq("location_number", locationNumber), Updates.set("price", price));
            System.out.println("Reserva actualizada correctamente");
        }else{
            System.out.println("No se puede actualizar porque no existe la reserva");
        }
    }

    public void borrarReserva(int locationNumber){
        if (checkIfBookingExists(locationNumber)){
            collection.deleteOne(Filters.eq("location_number", locationNumber));
            System.out.println("Reserva borrada correctamente");
        }else{
            System.out.println("No se puede borrar porque no existe la reserva");
        }
    }

    private boolean checkIfBookingExists(int locationNumber){
        FindIterable<Document> booking = collection.find(new Document("location_number", locationNumber));

        if (booking.first() != null){
            return true;
        }
        return false;
    }

    private boolean checkPrice(String price){
        return price.matches("([0-9]+,[0-9]+)");
    }

    private boolean checkDate(String date){
        return date.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})");
    }
}
