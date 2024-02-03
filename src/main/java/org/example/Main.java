package org.example;

public class Main {
    public static void main(String[] args) {
        BookingDAO bookingDAO = new BookingDAO();

        bookingDAO.mostrarReservas();

        Booking booking = new Booking("pruebaCliente", "agency", "room", "10,23", "hotel", "10/10/2000", 1);
        bookingDAO.insertReservas(booking);

        bookingDAO.borrarReserva(1);
        bookingDAO.borrarReserva(1);

        bookingDAO.actualizarPrecioReserva(1, "0,0");
        bookingDAO.actualizarPrecioReserva(2, "10,10");

    }
}