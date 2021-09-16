package com.assuretraining.main.ui.command;

import com.assuretraining.main.ui.Menu;

public class SeeRentalsCommand implements Command {
    public  void runCommand(Menu menu){
        if (menu.rentals.isInventoryEmpty()) {
            System.out.println("There aren't any rentals yet");
        }
        menu.rentals.printInventory();
    }
}
