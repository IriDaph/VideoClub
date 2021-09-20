package com.assuretraining.main.inventory;
import com.assuretraining.main.ui.ScannerActions;

public interface Inventory<T> {
    public void add(T object);
    public void printInventory();
    public Object searchByIdentifier(String id);
    public boolean isInventoryEmpty();
}
