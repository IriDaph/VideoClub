package com.assuretraining.main.ui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    Menu menu = new Menu(System.in);
    @Test
    void startMenu_ShowsOptions() {
        Assertions.assertTrue(menu.isMenuOn);

    }

    @Test
    void searchCustomerInventory() {
    }

    @Test
    void searchMediaInventory() {
    }

    @Test
    void searchRentalInventory() {
    }
}