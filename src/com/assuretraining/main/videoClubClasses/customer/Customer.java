package com.assuretraining.main.videoClubClasses.customer;

public class Customer {
    private String id;
    private String name;
    private String lastname;
    private String address;
    private String cellphone;
    private Integer rewardPoints;

    public Customer(String id, String name, String lastname,String address, String cellphone){
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.address = address;
        this.cellphone = cellphone;
        this.rewardPoints = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public Integer getRewardPoints() {
        return rewardPoints;
    }

    public void calculateRewardPoints(double amountSpent) {
        this.rewardPoints = this.rewardPoints + (int) amountSpent;
    }

    public  void printCustomer() {
        System.out.println(CustomerStrings.ID + id);
        System.out.println(CustomerStrings.NAME + name);
        System.out.println(CustomerStrings.LASTNAME + lastname);
        System.out.println(CustomerStrings.CELLPHONE + cellphone);
        System.out.println(CustomerStrings.REWARD_POINTS + rewardPoints);
    }

}
