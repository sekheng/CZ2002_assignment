package CZ2002_assignment;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/**
    To create a a list of staff from a file
    @author    Lee Sek Heng
    @version   1.0
    @since      2021-06-11
 */
public class StaffFactory {
    /**
     * Create an array list of staff from a text file
     * every new line is a new staff and ',' is the delimiter
     * @param filePath  relative filepath to the text file
     * @return              array of staff created from it
     * @throws Exception
     */
    public static ArrayList<Staff> createStaff(String filePath) throws Exception
    {
        ArrayList<Staff> staffList = new ArrayList<>();
        URL url = StaffFactory.class.getResource(filePath);
        File file = new File(url.getPath());

        Scanner sc = new Scanner(file);
        while (sc.hasNextLine())
        {
            String staffLine = sc.nextLine();
            String[] subStrings = staffLine.split(",");
            int gender = Integer.parseInt(subStrings[1]);
            staffList.add(new Staff(subStrings[0], gender, subStrings[2], subStrings[3]));
        }
        sc.close();
        return staffList;
    }
}
