package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.Document;

public class Booking {
    @JsonProperty("location_number")
    private int locationNumber;
    private String client;
    private String agency;
    private String room;
    private String price;
    private String hotel;

    @JsonProperty("check_in")
    private String checkIn;

    @JsonProperty("room_nights")
    private int roomNights;

    public Booking() {
    }

    public Booking(String client, String agency, String room, String price, String hotel, String checkIn, int roomNights) {
        this.setClient(client);
        this.setAgency(agency);
        this.setRoom(room);
        this.setPrice(price);
        this.setHotel(hotel);
        this.setCheckIn(checkIn);
        this.setRoomNights(roomNights);
    }

    @Override
    public String toString() {
        return "Booking{" + '\n' +
                "locationNumber=" + locationNumber + '\n' +
                ", client='" + client + '\n' +
                ", agency='" + agency + '\n' +
                ", room='" + room + '\n' +
                ", price='" + price + '\n' +
                ", hotel='" + hotel + '\n' +
                ", checkIn='" + checkIn + '\n' +
                ", roomNights=" + roomNights + '\n' +
                '}';
    }

    public int getLocationNumber() {
        return locationNumber;
    }

    public void setLocationNumber(int locationNumber) {
        this.locationNumber = locationNumber;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public int getRoomNights() {
        return roomNights;
    }

    public void setRoomNights(int roomNights) {
        this.roomNights = roomNights;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
