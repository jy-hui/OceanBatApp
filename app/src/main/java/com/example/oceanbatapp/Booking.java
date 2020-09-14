package com.example.oceanbatapp;


import android.widget.Spinner;

public class Booking {

    private String address;
    private String BookingDate;
    private String ServicesDate;
    private String ServicesTime;
    private String Other;
    private Spinner Spinner;

    public Booking(){

    }
    public Booking(String address, String BookingDate, String servicesDate, String servicesTime, String other, android.widget.Spinner spinner) {
        this.address = address;
        this.BookingDate = BookingDate;
        ServicesDate = servicesDate;
        ServicesTime = servicesTime;
        Other = other;
        Spinner = spinner;

    }


    public android.widget.Spinner getSpinner() {return Spinner;}

    public void setSpinner(android.widget.Spinner spinner) {Spinner = spinner;}

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
