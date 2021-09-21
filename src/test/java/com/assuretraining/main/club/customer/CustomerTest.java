package com.assuretraining.main.club.customer;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class CustomerTest {
    Customer customer = null;
    @BeforeEach
    public void setup() {
        customer = new Customer("1","Juan","Perez","Av. America #1414","778918391");
    }

    @Test
    void calculateRewardPoints_StartsEmpty_ReturnsTrue() {
        Assertions.assertEquals(0,customer.getRewardPoints());
    }
    @Test
    void calculateRewardPoints_IncreasesPointsInteger_ReturnsTrue(){
        Integer points = customer.calculateRewardPoints(100);
        Assertions.assertEquals(100,points);
    }
    @Test
    void calculateRewardPoints_IncreasesPointsDouble_ReturnsTrue(){
        Integer points = customer.calculateRewardPoints(99.99);
        Assertions.assertEquals(99,points);
    }

    @Test
    void printCustomer_PrintsCustomerInfo_ReturnsTrue() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        customer.printCustomer();
        String expectedOutput  = "Id: 1\r\nName: Juan\r\nLastname: Perez\r\nCellphone: 778918391\r\nReward Points: 0\r\n";
        Assertions.assertEquals(expectedOutput,outContent.toString());
    }
}