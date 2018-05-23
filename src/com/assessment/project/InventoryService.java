package com.assessment.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * This class provides implementation/business logic for all service methods and
 * serves as service class.
 * @author Ashish Kumar
 *
 */
public class InventoryService implements InventoryServiceInterface{
    
    List <String> items = new ArrayList<String>(); 
    Map <String, Integer>itemQuantityMap = new HashMap<String, Integer>();
    Map <String, Double>itemCost = new HashMap<String, Double>();
    Map <String, Double>itemSellingPrice = new HashMap<String, Double>();

 /**
  * This class is responsible for creating an inventory item.
  * Accepts item name , cost price and selling price.
  * in case of any error it returns the RC=1.
  */
    public int createItemName(String itemName, double costPrice,
                  double sellingPrice) {
           try {
                  items.add(itemName);
                  if(itemCost.containsKey(itemName) && itemSellingPrice.containsKey(itemName)){
                        double cost = itemCost.get(itemName).doubleValue();
                        double sellPrice = itemSellingPrice.get(itemName).doubleValue();
                        sellPrice = sellingPrice;
                        cost = costPrice;
                        itemCost.put(itemName, new Double(cost));
                        itemSellingPrice.put(itemName, new Double(sellPrice));
                        return 2;
                  }else{
                        itemCost.put(itemName, new Double(costPrice));
                        itemSellingPrice.put(itemName, new Double(sellingPrice));
                        return 0;
                  }
           } catch (Exception e){
                  return 1;
           }
    }

/**
 * This method is responsible for delete an item from inventory.
 * accepts the item name.
 */
    public int deleteItem(String itemName) {
           int returnCode =0;
           try {
                  
                  if(items.contains(itemName)){
                        items.remove(itemName);
                  }else{
                        returnCode = 1;
                  }
                  if(itemCost.containsKey(itemName) && itemSellingPrice.containsKey(itemName)){
                        itemCost.remove(itemName);
                        itemSellingPrice.remove(itemName);
                  }
                  return 2;
           } catch (Exception e){
                  return 3;
           }
    }

/**
 * This method is responsible for update for selling.
 * it accepts the item name and quantity to update the buy records.
 * in case of any error it returns the RC=1.
 */
    public int updateBuy(String itemName, int quantity) {
           
           try {
                  if(itemQuantityMap.containsKey(itemName)){
                        int quty = itemQuantityMap.get(itemName).intValue();
                        quty = quty+quantity;
                        itemQuantityMap.put(itemName, new Integer(quty));
                  }else{
                        itemQuantityMap.put(itemName, new Integer(quantity));
                  }
                  return 0;
           } catch (Exception e){
                  return 1;
           }
    }

 /**
  * This method is responsible for updating the sell item.
  * Accepts item name and selling quantity.
  * in case of any error it returns the RC=1.
  */
    public int updateSellItem(String itemName, int quantity) {
           try {
                  if(itemQuantityMap.containsKey(itemName)){
                        int quty = itemQuantityMap.get(itemName).intValue();
                        quty = quty-quantity;
                        itemQuantityMap.put(itemName, new Integer(quty));
                  }else{
                        itemQuantityMap.put(itemName, new Integer(quantity));
                  }
                  return 0;
           } catch (Exception e){
                  return 1;
           }
    }
/**
 * This method is responsible for creating the status report on inventory
 * Accepts - no parameter
 * returns - void
 */
    public void generateReport() {
        // TODO Auto-generated method stub
        System.out.println("*********************************************INVENTORY REPORT**********************************************************************");
        System.out.println("Item Name                                          Bought At                       Sold At                  Available Qty                   Value");
        System.out.println("---------                                          ---------                       -------                  -------------                   -----");
        double itemCst;
        double soldPrice;
        int avaQunty;
       
        for(int index=0; index<items.size(); index++){
        	String itemName = items.get(index);
        	if (itemCost.get(itemName)==null)
        	 itemCst =  0;
        	else
        	 itemCst =  itemCost.get(itemName);
        	
        	if (itemSellingPrice.get(itemName)==null)
        	 soldPrice =  0;
           	else
           	 soldPrice =  itemSellingPrice.get(itemName);
        	
        	if (itemQuantityMap.get(itemName)==null)
        		avaQunty =  0;
              	else
                avaQunty =  itemQuantityMap.get(itemName);
        	if(avaQunty==0)
        		soldPrice = 0;
        		
        System.out.println(items.get(index)+"                                                 "+itemCst+"                           "+soldPrice+"                          "+avaQunty+"                         "+itemCst*avaQunty);
        }
    }
 }
