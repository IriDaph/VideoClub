package com.assuretraining;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Rental {
    private String id;
    private Date dateOfRental;
    private Date dateOfReturning;
    private Media rentedMedia;
    private Customer customer;
    private Boolean isPaid;
    private double total;
    private Integer quantityOfDays;
    private double penaltyFee;

    public Rental(String id,
                  Media rentedMedia,
                  Customer customer,
                  Integer quantityOfDays,
                  Boolean isPaid) {
        this.id = id;
        this.rentedMedia = rentedMedia;
        this.customer = customer;
        this.isPaid = isPaid;
        this.quantityOfDays = quantityOfDays;
        this.penaltyFee = 0;
        this.total = quantityOfDays * rentedMedia.getCostPerDay();
        this.dateOfRental = new Date();
        calculateDayOfReturning();
    }
    public void calculateDayOfReturning() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(this.dateOfRental);
        cal.add(Calendar.DATE, this.quantityOfDays);
        this.dateOfReturning = cal.getTime();
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

    public void setDateOfRental(String dateOfRental) throws Exception {
        Date date=new SimpleDateFormat("dd/MM/yyyy").parse(dateOfRental);
        this.dateOfRental = date;
    }

    public Date getDateOfReturning() {
        return dateOfReturning;
    }

    public void setDateOfReturning(String dateOfReturning) throws Exception  {
        Date date=new SimpleDateFormat("dd/MM/yyyy").parse(dateOfReturning);
        this.dateOfReturning = date;
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

    public void calculatePenalty() {
        Date today = new Date();
        if(today.after(this.dateOfReturning)){
            long difference = getDifferenceOfDays(today);
            this.penaltyFee = (this.total*0.75)*difference;
        }
    }

    private long getDifferenceOfDays(Date today) {
        long diff = today.getTime() - this.dateOfReturning.getTime();
        TimeUnit time = TimeUnit.DAYS;
        long difference =  TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        return difference;
    }

    public void printRental() {
        System.out.println("Rental Id: "+id);
        System.out.println("Customer id: "+customer.getId());
        System.out.println("Customer name: "+customer.getName());
        System.out.println("Date of Rental: "+dateOfRental);
        System.out.println("Date of Returning: "+dateOfReturning);
        System.out.println("Paid?: "+isPaid);
        System.out.println("total: "+total);
        System.out.println("penaltyFee: "+penaltyFee);
    }
}
