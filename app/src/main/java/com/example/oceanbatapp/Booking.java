package com.example.oceanbatapp;


public class Booking {

    private String address;
    private String BookingDate;
    private String ServicesDate;
    private String ServicesTime;
    private String Other;
    private String spinner;
    private String receiver;
   // private String Services;

    public Booking() {
    }

    public String getSpinner() {return receiver; }

    public void setSpinner(String receiver) {this.receiver = receiver;}

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBookingDate() {
        return BookingDate;
    }

    public void setBookingDate(String bookingDate) {
        BookingDate = bookingDate;
    }

    public String getServicesDate() {
        return ServicesDate;
    }

    public void setServicesDate(String servicesDate) {
        ServicesDate = servicesDate;
    }

    public String getServicesTime() {
        return ServicesTime;
    }

    public void setServicesTime(String servicesTime) {
        ServicesTime = servicesTime;
    }

    public String getOther() {
        return Other;
    }

    public void setOther(String other) {
        Other = other;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    // public String getServices() {
    //    return Services;
    //}

   // public void setServices(String services) {
       // Services = services;
  //  }
}