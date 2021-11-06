package CZ2002_assignment;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

/**
    To manage a list of menuItems
    allows addition, updates, and deletion of menuItems
    @author    Kevin Patrick Santoso
    @version   1.0
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
     */
    public void createMenuItem(int priceInCents, String description, String name, String type) throws InputMismatchException  {
        if (priceInCents<0){
            throw new ArithmeticException("priceInCents cannot be negative");
        }

        MenuItem temp = new MenuItem(priceInCents, description, name, type);
        menuItemList.add(temp);
    }


    /**
     * method to change the name, description, priceInCents, and type of a menuItem object
     * @param item is the menu item to be updated
     * we ask the users whcih attribute they want to change
     * we print the old attribute and ask for a replacement
     * @throws InputMismatchException
     */
    public void updateMenuItem(MenuItem item) throws InputMismatchException
    {
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
    }//end of update


    /**
     * method to remove a menuItem object from the menuItemList
     * @param i is the index for the menuItem object to be deleted
     * deletes selected menuItem
     * @throws ArrayIndexOutOfBoundsException
     */
    public void removeObjectName(int i) throws ArrayIndexOutOfBoundsException
    {
        menuItemList.remove(i);
    }

    /**
     * gets the list of menu items
     * @return menuItemList
     */
    public ArrayList<MenuItem> getArrayOfObjectName(){
        return menuItemList;
    };
}
