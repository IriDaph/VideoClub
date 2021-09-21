package com.assuretraining.main.ui.command;

import com.assuretraining.main.ui.Menu;
import com.assuretraining.main.ui.MenuStrings;

public class ExitCommand  implements Command{
    public void runCommand(Menu menu) {
        System.out.println(MenuStrings.FAREWELL);
        menu.isMenuOn = false;
    }
}
