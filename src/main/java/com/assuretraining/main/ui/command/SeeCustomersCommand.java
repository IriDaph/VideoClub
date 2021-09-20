package com.assuretraining.main.ui.command;

import com.assuretraining.main.ui.Menu;

public class SeeCustomersCommand implements Command {
    public void runCommand(Menu menu){
        if (menu.customers.isInventoryEmpty()) {
            System.out.println("There isn't any customers yet");
        }
        menu.customers.printInventory();
    }
}