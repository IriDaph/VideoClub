package com.assuretraining.main.inventory;

import com.assuretraining.main.club.customer.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class CustomerInventoryTest {

    Inventory customerInventory;
    List<Customer> inventory;
    @BeforeEach
    void setup(){
        customerInventory = new CustomerInventory();
        inventory = customerInventory.getInventory();
    }
    @Test
    void customerList_ShouldStartEmpty() {
        Assertions.assertEquals(0, inventory.size());
    }
    @Test
    void add_ShouldAddCustomerToList(){
        Customer customer = mock(Customer.class);
        inventory.add(customer);
        Assertions.assertTrue(inventory.contains(customer));
    }

    @Test
    void printInventory_ShouldShowCustomers() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Customer customer1 = new Customer("1","Maria","Perez","Av Juan de la rosa","78823123");
        Customer customer2 = new Customer("2","Luis","Gonzales","Av Melchor Perez","78820914");
        customerInventory.add(customer1);
        customerInventory.add(customer2);
        customerInventory.printInventory();
        String expectedOutput  = "Id: 1\r\nName: Maria\r\nLastname: Perez\r\nCellphone: 78823123\r\nReward Points: 0\r\n"+
                                 "Id: 2\r\nName: Luis\r\nLastname: Gonzales\r\nCellphone: 78820914\r\nReward Points: 0\r\n";
        Assertions.assertEquals(expectedOutput,outContent.toString());
    }

    @Test
    void searchByIdentifier_ShouldReturnSearchedCustomer() {
        Customer customer1 = new Customer("1","Maria","Perez","Av Juan de la rosa","78823123");
        customerInventory.add(customer1);
        Assertions.assertEquals(customer1,(Customer) customerInventory.searchByIdentifier("1"));
    }

    @Test
    void searchByIdentifier_ShouldReturnNullIfSearchedCustomerDoesNotExist() {
        Assertions.assertEquals(null,(Customer) customerInventory.searchByIdentifier("5"));
    }
    @Test
    void isInventoryEmpty_ShouldReturnTrueIfEmpty() {
        Assertions.assertTrue(customerInventory.isInventoryEmpty());
    }

    @Test
    void isInventoryEmpty_ShouldReturnFalseIfNotEmpty() {
        Customer customer1 = new Customer("1","Maria","Perez","Av Juan de la rosa","78823123");
        customerInventory.add(customer1);
        Assertions.assertFalse(customerInventory.isInventoryEmpty());
    }

    @Test
    void sortInventoryById_ShouldSortList() {
        Customer customer1 = new Customer("10","Maria","Perez","Av Juan de la rosa","78823123");
        Customer customer2 = new Customer("2","Luis","Gonzales","Av Melchor Perez","78820914");
        customerInventory.add(customer1);
        customerInventory.add(customer2);
        List<Customer> orderedList = new ArrayList<>();
        orderedList.add(customer2);
        orderedList.add(customer1);
        customerInventory.sortInventory();
        Assertions.assertEquals(orderedList,customerInventory.getInventory());
    }

}