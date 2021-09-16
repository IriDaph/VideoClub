package com.assuretraining.main.club.media;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Media {
    protected String description;
    protected double costPerDay;
    protected String name;
    protected String uid;
    protected Date dateOfRelease;

    public Media(String description,
                 double costPerDay,
                 String name,
                 String uid,
                 String dateOfRelease) throws Exception {
        this.description = description;
        this.costPerDay = costPerDay;
        this.name = name;
        this.uid = uid;
        setDateOfRelease(dateOfRelease);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCostPerDay() {
        return costPerDay;
    }

    public void setCostPerDay(double costPerDay) {
        this.costPerDay = costPerDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Date getDateOfRelease() {
        return dateOfRelease;
    }

    public void setDateOfRelease(String dateOfRelease) throws  Exception{
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateOfRelease);
        this.dateOfRelease = date;
    }

    public  void printMedia(){
        System.out.println(MediaStrings.UID + uid);
        System.out.println(MediaStrings.MEDIA_NAME + name);
        System.out.println(MediaStrings.DESCRIPTION + description);
        System.out.println(MediaStrings.COST_PER_DAY + costPerDay);

    }
}
