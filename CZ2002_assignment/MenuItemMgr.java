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
     * method to change the name, description, priceInCents, and type of a menuItem object
     * @param item is the menu item to be updated
     * we ask the users whcih attribute they want to change
     * we print the old attribute and ask for a replacement
     * @throws InputMismatchException when new price is not int
     */
    public void updateMenuItem(MenuItem item) throws InputMismatchException
    {
        /*
        Scanner sc = new Scanner(System.in);
        System.out.println("(1) change name, (2) change priceInCents, (3) change description, (4) change type");
        switch(sc.nextInt())
        {
            case 1:
            System.out.println("old name is " + item.getName());
            item.setName(sc.nextLine());
            break;

            case 2:
            System.out.println("old priceInCents is " + item.getPriceInCents());
            item.setPriceInCents(sc.nextInt());
            break;

            case 3:
            System.out.println("old description is " + item.getDescription());
            item.setDescription(sc.nextLine());
            break;

            case 4:
            System.out.println("old type is " + item.getType());
            item.setType(sc.nextLine());
            break;

            default:
            System.out.println("that choice is not available");
            break;
        }// end of switch
        sc.close();
        */
        // clearly SC has to be outside of MenuItemMgr
        // thus this will fixed it by assuming that scanner will be enter from outside
        // now i think about it, maybe the update is done from the array of menuitem manager
    }//end of update

    
    //Update menu item name
    public void updateMenuItemName(String originalName,String newName) {
    	for(int i=0; i<this.menuItemList.size();i++)
    		if(this.menuItemList.get(i).getName().compareTo(originalName)==0) {
    			this.menuItemList.get(i).setName(newName);
    			System.out.println("New name for item " + originalName + " is " + newName);
    			return;
    		}
    	System.out.println("No item found with such a name");
    	return;
    }
    
    //Update menu item price
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
    
    //Update menu item description
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
    
    
    //Update menu item type
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
}
