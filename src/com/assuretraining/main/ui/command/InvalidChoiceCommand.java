package com.assuretraining.main.ui.command;

import com.assuretraining.main.ui.MenuStrings;
import com.assuretraining.main.ui.Menu;

public class InvalidChoiceCommand {
    public void invalidChoice(Menu menu) {
        System.out.println(MenuStrings.INVALID_OPTION);
    }
}
