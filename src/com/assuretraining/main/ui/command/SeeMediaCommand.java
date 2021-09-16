package com.assuretraining.main.ui.command;

import com.assuretraining.main.ui.Menu;

public class SeeMediaCommand {
    public void runCommand(Menu menu){
        if (menu.ownedMedia.isInventoryEmpty()) {
            System.out.println("There isn't any media yet");
        }
        menu.ownedMedia.printInventory();
    }
}
