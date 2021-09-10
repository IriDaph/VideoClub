package com.assuretraining;

public class Media {
    protected String description;
    protected double costPerDay;
    protected String name;
    protected String uid;
    protected String dateOfRelease;

    public Media(String description, double costPerDay, String name, String uid, String dateOfRelease) {
        this.description = description;
        this.costPerDay = costPerDay;
        this.name = name;
        this.uid = uid;
        this.dateOfRelease = dateOfRelease;
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

    public String getDateOfRelease() {
        return dateOfRelease;
    }

    public void setDateOfRelease(String dateOfRelease) {
        this.dateOfRelease = dateOfRelease;
    }
}
