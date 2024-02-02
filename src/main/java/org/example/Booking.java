package org.example;

public class Booking {
    private int location_number;
    private String client;
    private String agency;
    private String room;
    private String hotel;
    private String check_in;
    private int room_nights;

    public Booking(String client, String agency, String room, String hotel, String check_in, int room_nights) {
        this.client = client;
        this.agency = agency;
        this.room = room;
        this.hotel = hotel;
        this.check_in = check_in;
        this.room_nights = room_nights;
    }

    public int getLocation_number() {
        return location_number;
    }

    public void setLocation_number(int location_number) {
        this.location_number = location_number;
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

    public String getCheck_in() {
        return check_in;
    }

    public void setCheck_in(String check_in) {
        this.check_in = check_in;
    }

    public int getRoom_nights() {
        return room_nights;
    }

    public void setRoom_nights(int room_nights) {
        this.room_nights = room_nights;
    }
}
