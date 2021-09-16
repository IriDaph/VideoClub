# SOLID Refactor
This document contains all changes made to the VideoClub project during the refactoring process. Those changes include major changes, like creation of interfaces and classes, as well as minor changes like style guide changes. 
## Customer class refactor
**printCustomer() method**
Previously this method had Strings on it. These Strings were extracted and put on a public class as constants.

Before:
```
public  void printCustomer(){  
  System.out.println("Id: " + id);  
  System.out.println("Name: " + name);  
  System.out.println("Lastname: " + lastname);  
  System.out.println("Cellphone" + cellphone);  
  System.out.println("Rewards points: " + rewardPoints);  
}
```
After:
```
public class customerStrings {  
 public static final String  ID= "Id: ";  
 public static final String  NAME= "Name: ";  
 public static final String LASTNAME = "Lastname: ";  
 public static final String CELLPHONE = "Cellphone";  
 public static final String REWARD_POINTS = "Reward Points: ";  
}
```
```
public  void printCustomer() {  
  System.out.println(customerStrings.ID + id);  
  System.out.println(customerStrings.NAME + name);  
  System.out.println(customerStrings.LASTNAME + lastname);  
  System.out.println(customerStrings.CELLPHONE + cellphone);
  System.out.println(customerStrings.REWARD_POINTS + rewardPoint
);  
}
```
Minor style changes where applied, including spaces in logic block an assignations.

## Media Class
Strings were extracted to their own class. Also minor style changes were applied.

## Rental Class
Strings were extracted to their own class. Also minor style changes were applied.
## Menu Class
Strings on menu options were extacred to their own class, plus new constants for each option were created in said class.
```
public static final String EXIT_MENU = "0";  
public static final String ADD_CUSTOMER = "1";  
public static final String ADD_MOVIE = "2";  
public static final String ADD_MUSIC = "3";  
public static final String ADD_VIDEO_GAME = "4";  
public static final String ADD_RENTAL = "5";  
public static final String SEE_CUSTOMERS = "6";  
public static final String SEE_MEDIA = "7";  
public static final String SEE_RENTALS = "8";  
public static final String CALCULATE_PENALTY_FEE = "9";  
public static final String MODIFY_RETURN_DATE = "10";
```

Lists of media, customers and rentals were implemented in their own classes to respect Single Resposabilitie.

An Inventory Interface was created, this one is implemented by classes customerInventory, rentalInventory and mediaInventory.

The star menu was refactored, it no longer uses a switch case. Instead each methos on the class was extracted to their own class, all these classes now implement an Interface in common. This allows the creation of more menu options, and this is aligned with the Open Closed principle.

Given this advantage now a Hash map an polymorphism is used to execute each method through its class. 

All the actions tat could be made with a Scanner are now in a separate class called Scanner actions. 

