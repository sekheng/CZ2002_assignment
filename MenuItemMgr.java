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
     * then switch will check for type and add to chosen list
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

    }
}
