package com.assuretraining.main.club.rental;

import com.assuretraining.main.club.customer.Customer;
import com.assuretraining.main.club.media.Media;

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
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateOfRental);
        this.dateOfRental = date;
    }

    public Date getDateOfReturning() {
        return dateOfReturning;
    }

    public void setDateOfReturning(String dateOfReturning) throws Exception  {
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateOfReturning);
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
        if (today.after(this.dateOfReturning)) {
            long difference = getDifferenceOfDays(today);
            this.penaltyFee = (this.total*0.75)*difference;
        }
    }

    private long getDifferenceOfDays(Date today) {
        long diff = today.getTime() - this.dateOfReturning.getTime();
        TimeUnit time = TimeUnit.DAYS;
        long difference =  time.convert(diff, TimeUnit.MILLISECONDS);
        return difference;
    }

    public void printRental() {
        System.out.println(RentalStrings.RENTAL_ID + id);
        System.out.println(RentalStrings.CUSTOMERS_ID + customer.getId());
        System.out.println(RentalStrings.CUSTOMERS_NAME + customer.getName());
        System.out.println(RentalStrings.DATE_OF_RENTAL + dateOfRental);
        System.out.println(RentalStrings.DATE_OF_RETURNING + dateOfReturning);
        System.out.println(RentalStrings.CUSTOMER_PAID+ isPaid);
        System.out.println(RentalStrings.TOTAL + total);
        System.out.println(RentalStrings.PENALTY_FEE + penaltyFee);
    }
    public  void printRentingCustomer(){
        System.out.println(RentalStrings.CUSTOMERS_ID + customer.getId());
        System.out.println(RentalStrings.CUSTOMERS_NAME + customer.getName());
    }


}
