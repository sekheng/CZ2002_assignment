package CZ2002_assignment;

import java.util.Scanner;
import java.util.ArrayList;
public class MenuItemMgr {
    Scanner sc = new Scanner(System.in); //constructs a scanner for user input
    private ArrayList<MenuItem> appetizerList = new ArrayList<MenuItem>();  //appetizerList is an arrayList for menuItem type appetizer
    private ArrayList<MenuItem> mainCourseList = new ArrayList<MenuItem>(); //mainCourseList is an arrayList for menuItem type maincourse
    private ArrayList<MenuItem> drinkList = new ArrayList<MenuItem>();      //appetizerList is an arrayList for menuItem type appetizer


    /**
     * createMenuItem method takes in price, description, name, and type
     * Puts them all in menuItem constructor
     * then switch will check for type and add to chosen list, and writes a message
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

    public void updateMenuItem(ArrayList<MenuItem> a){              //we assume that the menuItem object that we want to update is already in the right type
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


    public void removeMenuItem(ArrayList<MenuItem> a){
        a.forEach(MenuItem -> {
            System.out.println(MenuItem);
        });

        System.out.println("which item would you like to delete");
        int i = sc.nextInt();
        a.remove(i+1);
    }
}
