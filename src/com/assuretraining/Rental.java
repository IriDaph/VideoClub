package com.assuretraining;

import java.util.Date;

public class Rental {
    private String id;
    private Date dateOfRental;
    private Date dateOfReturning;
    private Media rentedMedia;
    private Customer customer;
    private Boolean isPaid;
    private double penaltyFee;

    public Rental(String id,
                  Date dateOfRental,
                  Date dateOfReturning,
                  Media rentedMedia,
                  Customer customer,
                  Boolean isPaid,
                  double penaltyFee) {
        this.id = id;
        this.dateOfRental = dateOfRental;
        this.dateOfReturning = dateOfReturning;
        this.rentedMedia = rentedMedia;
        this.customer = customer;
        this.isPaid = isPaid;
        this.penaltyFee = penaltyFee;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDateOfRental() {
        return dateOfRental;
    }

    public void setDateOfRental(Date dateOfRental) {
        this.dateOfRental = dateOfRental;
    }

    public Date getDateOfReturning() {
        return dateOfReturning;
    }

    public void setDateOfReturning(Date dateOfReturning) {
        this.dateOfReturning = dateOfReturning;
    }

    public Media getRentedMedia() {
        return rentedMedia;
    }

    public void setRentedMedia(Media rentedMedia) {
        this.rentedMedia = rentedMedia;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Boolean getPaid() {
        return isPaid;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }

    public double getPenaltyFee() {
        return penaltyFee;
    }

    public void setPenaltyFee(double penaltyFee) {
        this.penaltyFee = penaltyFee;
    }
}
