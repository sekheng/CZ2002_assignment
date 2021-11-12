package CZ2002_assignment;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;

/**
 * Meant to test Menu manager and menu item functions solely!
 * @author  Lee Sek Heng
 * @version 1.0
 * @since     2021-11-11
 */
public class MenuItemTesting {
    /**
     * Testing the behaviour
     */
    @Test
    public void MenuMgrTesting()
    {
        MenuItemMgr myMenuMgr = new MenuItemMgr();
        ArrayList<MenuItem> expectedResult = new ArrayList<MenuItem>(Arrays.asList(
            new MenuItem(300,"served with chili sauce","french fries","appetizer")
            ,new MenuItem(250,"vegetarian","sandwich","appetizer")
            ,new MenuItem(600,"spicy","chicken rice","maincourse")
            ,new MenuItem(500,"many mushrooms","mushroom risoto","maincourse")
            ,new MenuItem(350,"cold","lemon tea","drinks")
            ,new MenuItem(400,"hot","special coffee","drinks")
        ));
        // ensuring that the my menu mgr creation is correct
        //assertArrayEquals(myMenuMgr.getArrayOfMenuItem().toArray(), myMenuMgr.getArrayOfMenuItem().toArray());
        assertTrue("Expected menu item array is different from actual menu item array", MenuItemTesting.TestingBothItemArrays(myMenuMgr.getArrayOfMenuItem(), expectedResult));
        // then test the creation of menu item
        MenuItem testItem = new MenuItem(100, "description", "name", "type");
        myMenuMgr.createMenuItem(100, "description", "name", "type");
        expectedResult.add(testItem);
        assertTrue("Expected menu item array is different from actual menu item array", MenuItemTesting.TestingBothItemArrays(myMenuMgr.getArrayOfMenuItem(), expectedResult));
        // then test the updating of menu item
        MenuItem currItem = myMenuMgr.getArrayOfMenuItem().get(myMenuMgr.getArrayOfMenuItem().size() - 1);
        // currItem should be the same as testItem
        myMenuMgr.updateMenuItem(currItem);
    }

    /**
     * ensure both array are identical
     * @param array1    first array to be passed in
     * @param array2    2nd array to be passed in
     * @return              true if it is completely identical. false if any one of them is false
     */
    private static boolean TestingBothItemArrays(ArrayList<MenuItem> array1, ArrayList<MenuItem> array2)
    {
        if (array1.size() != array2.size())
        {
            return false;
        }
        for (int num = 0; num < array1.size(); ++num)
        {
            MenuItem firstItem = array1.get(num);
            MenuItem secItem = array2.get(num);
            if (firstItem.getName().equals(secItem.name) == false
            || firstItem.getPriceInCents() != secItem.getPriceInCents()
            || firstItem.getDescription().equals(secItem.getDescription()) == false
            || firstItem.getType().equals(secItem.getType()) == false
            )
            {
                return false;
            }
        }
        return true;
    }
}
