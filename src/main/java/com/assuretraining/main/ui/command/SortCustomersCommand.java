package com.assuretraining.main.ui.command;

import com.assuretraining.main.ui.Menu;

public class SortCustomersCommand  implements  Command{
    @Override
    public void runCommand(Menu menu) throws Exception {
        menu.customers.sortInventoryById();
        menu.customers.printInventory();
    }
}
