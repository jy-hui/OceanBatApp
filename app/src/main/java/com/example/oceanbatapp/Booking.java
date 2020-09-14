package com.example.oceanbatapp;


public class Booking {

    private String address;
    private String BookingDate;
    private String ServicesDate;
    private String ServicesTime;
    private String Other;
    private String Services;

    public Booking(){

    }
    public Booking(String address, String BookingDate, String servicesDate, String servicesTime, String other, String services) {
        this.address = address;
        this.BookingDate = BookingDate;
        ServicesDate = servicesDate;
        ServicesTime = servicesTime;
        Other = other;
        Services = services;


    }

    public String getServices() {return Services;}

    public void setServices(String services) {Services = services;}

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBookingDate(String trim) {
        return BookingDate;
    }

    public void setBookingDate(String bookingDate) {
        BookingDate = bookingDate;
    }

    public String getServicesDate(String trim) {
        return ServicesDate;
    }

    public void setServicesDate(String servicesDate) {
        ServicesDate = servicesDate;
    }

    public String getServicesTime(String trim) {
        return ServicesTime;
    }

    public void setServicesTime(String servicesTime) {
        ServicesTime = servicesTime;
    }

    public String getOther(String trim) {
        return Other;
    }

    public void setOther(String other) {
        Other = other;
    }
}
