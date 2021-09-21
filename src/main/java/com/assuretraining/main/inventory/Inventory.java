package com.assuretraining.main.inventory;
import com.assuretraining.main.ui.ScannerActions;

import java.util.ArrayList;
import java.util.List;

public interface Inventory<T> {
    public void add(T object);
    public void printInventory();
    public List<T> getInventory();
    public Object searchByIdentifier(String id);
    public boolean isInventoryEmpty();
    public void sortInventory();
}
