package com.assessment.project;
/**
 * This class is Main class for Inventory Management System.
 * this class is responsible for creating the UI and calling various
 * service methods of service class as per the user input.
 */
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserInterface {
	
	 public static void main(String[] args) {
         // Spring bean creation
         ApplicationContext context = new ClassPathXmlApplicationContext("springConfig.xml");
         InventoryServiceInterface serviceInterface = (InventoryServiceInterface)context.getBean("invinterface");
         int choice;
         Scanner reader = new Scanner(System.in);
         do {
           choice = screenLayout();
           switch (choice){
           // Create Item case
           case 1:
                  System.out.println("********Create New Item********************");
                  System.out.println("Enter New Item Name-->");
                  String itemName = reader.nextLine();
                  
                  System.out.println("Enter New Item Cost Price-->");
                  String costPrice = reader.nextLine();
                  System.out.println("Enter New Item Selleing Price -->");
                  String sellingPrice = reader.nextLine();
                  int retrunCode = serviceInterface.createItemName(itemName, Double.parseDouble(costPrice), Double.parseDouble(sellingPrice));
                  if(retrunCode==0){
                        System.out.println("New Item Created SuccessFully!!");
                  }else if (retrunCode==2){
                        System.out.println("An Item: "+itemName+ " Exist!! Updated the Cost/Selling price");
                  }else if (retrunCode==1){
                        System.out.println("Error occured while creating the item"); 
                  }
                  break;
                  
                // Delete Item case
           case 2:
                  System.out.println("********Delete an Item********************");
                  System.out.println("Enter New Item Name-->");
  
                  String itemName0 = reader.nextLine();
                  int retrunCode0 = serviceInterface.deleteItem(itemName0);
                  if(retrunCode0==2){
                        System.out.println("Item deleted successfully!!");
                  }
                  else if (retrunCode0==1){
                        System.out.println("Item does not exists !!"); 
                  }else{
                        System.out.println("Error occured while deleting the item"); 
                  }
                  break;
                  // Buy new Item case
           case 3:
                  System.out.println("********Buy New Items********************");
                  System.out.println("Enter an Item Name-->");
                  String itemName1 = reader.nextLine();
                  System.out.println("Enter an Item Quantity-->");
                  String quant = reader.nextLine();
                  //int quant = reader.nextInt();
                  int retrunCode1 = serviceInterface.updateBuy(itemName1, Integer.parseInt(quant));
                  if(retrunCode1==0){
                        System.out.println("Item purchased successfully!!");
                  }
                  else if (retrunCode1==1){
                        System.out.println("Error occured while buying the item"); 
                  }
                  break;
                  
                  // sell item case
           case 4:
                  System.out.println("********Sell the Items********************");
                  
                  System.out.println("Enter an Item Name-->");
                  
                  String itemName2 = reader.nextLine();
                  System.out.println("Enter an Item Quantity-->");
                  String quant2 = reader.nextLine();
                
                  int retrunCode2 = serviceInterface.updateSellItem(itemName2, Integer.parseInt(quant2));
                  if(retrunCode2==0){
                        System.out.println("Item Sold successfully!!");
                  }
                  else if (retrunCode2==1){
                        System.out.println("Error occured while selling the item"); 
                  }
                  break; 
           case 5:
                  try{
                  serviceInterface.generateReport();
                  } catch (Exception e){
                        System.out.println("Error occured while creating the report"); 
                  }
  
           case 6:
                  System.out.println("Good Bye!!"); 
           }
         } while (choice !=6);
  }
  // this method defines the layout on user console.
  public static int screenLayout(){
         int choiceEntered =0;
         try{
         Scanner reader = new Scanner(System.in);
         System.out.println("****************Inventory Management System*************************");
         System.out.println("--------------------------------------------------------------------");
         System.out.println("                   Enter your choice:                               ");
         System.out.println("                   ------------------                               ");
         System.out.println("1) To Create New Item entry press --> 1");
         System.out.println("2) To Delete an Item Name press --> 2 ");
         System.out.println("3) To Buy an Item press --> 3");
         System.out.println("4) To Sell an Item press --> 4");
         System.out.println("5) To Generate the Current status report press--> 5");
         System.out.println("6) To Exit press--> 6");
         System.out.println("--------------------------------------------------------------------");
         
         // collect the user input
         choiceEntered  = reader.nextInt();
         }catch (Exception e) {
                System.out.println("Please enter valid option");
         }
         return choiceEntered;
  }


}
