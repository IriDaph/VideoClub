package com.assuretraining.main.ui.command;

import com.assuretraining.main.ui.Menu;

public class SeeRentalsCommand {
    public  void seeAllRentals(Menu menu){
        if (menu.rentals.isInventoryEmpty()) {
            System.out.println("There aren't any rentals yet");
        }
        menu.rentals.printInventory();
    }
}
