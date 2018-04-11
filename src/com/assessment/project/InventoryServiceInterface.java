package com.assessment.project;
/**
 * This is an interface to our Inventory services.
 * @author Ashish Kumar
 *
 */
public interface InventoryServiceInterface {
	
    public int createItemName(String itemName, double costPrice, double sellingPrice);
    public int deleteItem(String itemName);
    public int updateBuy(String itemName, int quantity);
    public int updateSellItem(String itemName, int quantity);
    public void generateReport();

}
