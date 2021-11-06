package CZ2002_assignment;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/**
    To create a a list of menu items from a file
    @author    Lee Sek Heng
    @version   1.0
    @since     2021-06-11
 */
public class MenuItemFactory {

    /**
     * Create an array list of menu items from a text file
     * every new line is a new staff and ',' is the delimiter
     * @param filePath  relative filepath to the text file
     * @return              array of staff created from it
     * @throws Exception
     */
    public static ArrayList<MenuItem> createMenuItem(String filePath) throws Exception
    {
        ArrayList<MenuItem> menuItemList = new ArrayList<>();
        URL url = MenuItemFactory.class.getResource(filePath);
        File file = new File(url.getPath());

        Scanner sc = new Scanner(file);
        while (sc.hasNextLine())
        {
            String menuItemLine = sc.nextLine();
            String[] subStrings = menuItemLine.split(",");
            int price = Integer.parseInt(subStrings[0]);
            menuItemList.add(new MenuItem(price, subStrings[1], subStrings[2], subStrings[3]));
        }
        sc.close();
        return menuItemList;
    }
}
