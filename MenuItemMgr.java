package CZ2002_assignment;

import java.util.Scanner;
import java.util.ArrayList;
public class MenuItemMgr {
    /**
     * Constructs a new Scanner object
     * sc contains the reference to the Scanner object
     */
    Scanner sc = new Scanner(System.in); //constructs a scanner for user input

    /**
     * creates different ArrayList to contain menuItems and separate them according to their types
     * appetizerList contains the reference to an ArrayList for menuItem type appetizer
     * mainCourseList contains the reference to an ArrayList for menuItem type mainCourse
     * drinkList contains the reference to an ArrayList for menuItem type drink
     */
    private ArrayList<MenuItem> appetizerList = new ArrayList<MenuItem>();
    private ArrayList<MenuItem> mainCourseList = new ArrayList<MenuItem>();
    private ArrayList<MenuItem> drinkList = new ArrayList<MenuItem>();


    /**
     * this is a method to call the menuItem constructor
     * with user input for menuItem values of the price, description, name, and type
     * @param price will be input into the menuItem constructor price parameter
     * @param description will be input into the menuItem constructor description parameter
     * @param name will be input into the menuItem constructor name parameter
     * @param type will be input into the menuItem constructor type parameter
     * when all inputs are valid the switch will check for type and add it to correct menuItem ArrayList, and writes a message
     */
    public void createMenuItem(int price, String description, String name, String type){
        MenuItem a = new MenuItem(price, description, name, type);

        switch(type){
            case "appetizer":
            appetizerList.add(a);
            System.out.println(a.getName() + " added to appetizerList");
            break;

            case "mainCourse":
            case "maincourse":
            mainCourseList.add(a);
            System.out.println(a.getName() + " added to mainCourseList");
            break;

            case "drink":
            drinkList.add(a);
            System.out.println(a.getName() + " added to drinkList");
            break;

            default:
            System.out.println("wrong menuItem type");
            System.out.println("no item added");
            break;
        }
    }//end of createMenuItem


    /**
     * method to change the name, description, and price of a menuItem object
     * we assume that the type will not change as menuItem type attribute will be used to select the correct ArrayList
     * once the menuItem type is selected, we print the entire Arraylist for that menuItem type
     * we then print a message to ask for user input for the ArrayList index to select the menuItem they want to update
     * we then print out the old attributes of the menuItem object and ask for user input for new attribute values
     */
    public void updateMenuItem(ArrayList<MenuItem> a){             //note in visual paradigm cant put ArrayList<MenuItem> into parameter
        a.forEach(MenuItem -> {
            System.out.println(MenuItem);
        });

        System.out.println("which item would you like to update");
        int i = sc.nextInt();

        System.out.println("old name is " + a.get(i+1).getName());
        System.out.println("enter new name");
        a.get(i+1).setName(sc.next());

        System.out.println("old description is " + a.get(i+1).getDescription());
        System.out.println("enter new description");
        a.get(i+1).setDescription(sc.next());

        System.out.println("old price is " + a.get(i+1).getPrice());
        System.out.println("enter new price");
        a.get(i+1).setPrice(sc.nextInt());
    }//end of update


    /**
     * method to remove a menuItem object from its type ArrayList
     * we will use the menuItem type attribute to select the correct ArrayList
     * we will print out the selected ArrayList
     * we will then ask for user input for the index for the menuItem object they want to delete
     */
    public void removeMenuItem(ArrayList<MenuItem> a){
        a.forEach(MenuItem -> {
            System.out.println(MenuItem);
        });

        System.out.println("which item would you like to delete");
        int i = sc.nextInt();
        a.remove(i+1);
    }
}
