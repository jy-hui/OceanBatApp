package com.example.oceanbatapp;

public class Booking {

    private String address;
    private String BookingDate;
    private String ServicesDate;
    private String ServicesTime;
    private String Other;

    public Booking() {
    }

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
