package CZ2002_assignment;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

/**
    To manage a list of menuItems
    allows addition, updates, and deletion of menuItems
    @author    Kevin Patrick Santoso and Lee Sek heng
    @version   1.1
    @since     2021-06-11
 */
public class MenuItemMgr {

    /**
     * creates an ArrayList called menuItemList to store all menu items
     */
    private ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();

    /**
     * Constructor for a MenuItemMgr object
     * when constructor is called, menuItemList will copy the ArrayList returned from MenuItemFactory
     */
    public MenuItemMgr()
    {
        try
        {
            menuItemList = MenuItemFactory.createMenuItem("MenuItemData.txt");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    /**
     * adds a menu item to the menu item list
     * @param priceInCents This menuItem's priceInCents
     * @param description This menuItem's description
     * @param name This menuItem's name
     * @param type This menuItem's type
     * @throws NumberFormatException when @param priceInCents is not in
     * @throws AritmeticException when @param PriceInCents is negative
     */
    public void createMenuItem(int priceInCents, String description, String name, String type) throws NumberFormatException  {
        if (priceInCents<0){
            throw new ArithmeticException("priceInCents cannot be negative");
        }

        else{
        MenuItem temp = new MenuItem(priceInCents, description, name, type);
        menuItemList.add(temp);
        }
    }



    /**
     * method to change the name of the menu item
     * @param originalName is the old name of the menu item
     * @param newName is the new name of the menu item
     */
    public void updateMenuItemName(String originalName,String newName) {
    	System.out.println("Original name entered is " + originalName);
    	for(int i=0; i<this.menuItemList.size();i++)
    		if(this.menuItemList.get(i).getName().compareTo(originalName)==0) {
    			this.menuItemList.get(i).setName(newName);
    			System.out.println("New name for item " + originalName + " is " + newName);
    			return;
    		}
    	System.out.println("No item found with such a name");
    	return;
    }
    
    /**
     * method to change the price of the menu item
     * @param originalName is the name of the menu item
     * @param price is the new price of the menu item
     */
    public void UpdateMenuItemPrice(String originalName,int price) {
    	for(int i =0; i<this.menuItemList.size();i++) {
    		if(this.menuItemList.get(i).getName().compareTo(originalName)==0) {
    			this.menuItemList.get(i).setPriceInCents(price);
    			System.out.println("The new price for item " + originalName + " is " + price);
    			return;
    		}
    	}
    	System.out.println("No item found with such a name ");
    	return;
    }
    
    /**
     * method to change the description of the menu item
     * @param originalName is the name of the menu item
     * @param description is the new description of the menu item
     */
        public void UpdateMenuItemDescription(String originalName, String description) {
    	for(int i = 0; i<this.menuItemList.size();i++) {
    		if(this.menuItemList.get(i).getName().compareTo(originalName)==0) {
    			this.menuItemList.get(i).setDescription(description);
    			System.out.println("The new description for item " + originalName + " is : " + description);
    			return;
    		}
    	}
    	System.out.println("No item found with such a name");
    	return;
    }
    
    
    /**
     * method to change the type of the menu item
     * @param originalName is the name of the menu item
     * @param type is the new type of the menu item
     */
        public void UpdateMenuItemType(String originalName, String type) {
    	for(int i = 0; i<this.menuItemList.size(); i++) {
    		if(this.menuItemList.get(i).getName().compareTo(originalName)==0) {
    			this.menuItemList.get(i).setType(type);
    			System.out.println("The new type for item " + originalName + " is " + type);
    			return;
    		}
    	}
    	System.out.println("No item found with such a name");
    	return;
    }
    
    
    /**
     * method to remove a menuItem object from the menuItemList
     * @param name is the name for the menuItem object to be deleted
     * deletes selected menuItem
     */
    public void removeMenuItem(String name)
    {
    	for(int i = 0; i<this.menuItemList.size(); i++) {
    		if(this.menuItemList.get(i).getName().compareTo(name)==0) {
    			this.menuItemList.remove(i);
    			System.out.println("Removed " + name);
    			return;
    		}
    	}
    	System.out.println("No item found with such a name");
    	return;
    }

    /**
     * gets the list of menu items
     * @return menuItemList
     */
    public ArrayList<MenuItem> getArrayOfMenuItem(){
        return menuItemList;
    };
    
     /**
     * method to get a menu item from its name
     * @param Name is name of the menu item object
     * @return menuItem
     */
    public MenuItem getMenuItem(String Name) {
    	MenuItem menuItem = null;
    	for(int i=0; i<this.getArrayOfMenuItem().size(); i++) {
    		if(this.getArrayOfMenuItem().get(i).getName().compareTo(Name) == 0) {
    			menuItem = this.getArrayOfMenuItem().get(i);
    			System.out.println("Menu item successfully identified.....");
    		}

    	};
    	return menuItem;
    }
}
