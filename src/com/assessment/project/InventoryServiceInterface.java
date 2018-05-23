package com.assessment.project;
/**
 * This is an interface to our Inventory services.
 * @author Ashish Kumar
 *
 */
public interface InventoryServiceInterface {
	// interface method to create an Item.
    public int createItemName(String itemName, double costPrice, double sellingPrice);
    // interface method to delete an Item.
    public int deleteItem(String itemName);
    // interface method to update the Buy quantity.
    public int updateBuy(String itemName, int quantity);
    // interface method to update the sell quantity.
    public int updateSellItem(String itemName, int quantity);
    // interface method to Generate the report.
    public void generateReport();
    
}
