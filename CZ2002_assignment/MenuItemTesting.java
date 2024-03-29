package CZ2002_assignment;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
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
     * Testing the behaviours and functions of MenuItemMgr
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
        //myMenuMgr.updateMenuItem(currItem);
        currItem.setName("newName");
        testItem.setName("newName");
        assertTrue("Expected menu item array is different from actual menu item array", MenuItemTesting.TestingBothItemArrays(myMenuMgr.getArrayOfMenuItem(), expectedResult));
        // then test removing the item from it
        myMenuMgr.removeMenuItem(testItem.name);
        expectedResult.remove(testItem);
        assertTrue("Expected menu item array is different from actual menu item array", MenuItemTesting.TestingBothItemArrays(myMenuMgr.getArrayOfMenuItem(), expectedResult));
    }

    /**
     * Meant to test updating menu item through MenuItemMgr
     */
    @Test
    public void TestUpdateMenuItem()
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
        myMenuMgr.updateMenuItemPrice("sandwich", 100);
        MenuItem sandwichItem = expectedResult.get(1);
        sandwichItem.setPriceInCents(100);
        assertTrue("Expected menu item array is different from actual menu item array", MenuItemTesting.TestingBothItemArrays(myMenuMgr.getArrayOfMenuItem(), expectedResult));
        myMenuMgr.updateMenuItemName("sandwich", "newName");
        sandwichItem.setName("newName");
        assertTrue("Expected menu item array is different from actual menu item array", MenuItemTesting.TestingBothItemArrays(myMenuMgr.getArrayOfMenuItem(), expectedResult));
        myMenuMgr.updateMenuItemDescription("newName", "description");
        sandwichItem.setDescription("description");
        assertTrue("Expected menu item array is different from actual menu item array", MenuItemTesting.TestingBothItemArrays(myMenuMgr.getArrayOfMenuItem(), expectedResult));
        myMenuMgr.updateMenuItemType("newName", "type");
        sandwichItem.setType("type");
        assertTrue("Expected menu item array is different from actual menu item array", MenuItemTesting.TestingBothItemArrays(myMenuMgr.getArrayOfMenuItem(), expectedResult));
    }

    /**
     * Testing the behavior of menu item
     */
    @Test
    public void TestMenuItem()
    {
        MenuItem testItem = new MenuItem(100, "description", "name", "type");
        testItem.setName("newName");
        assertEquals(testItem.getName(), "newName");
        testItem.setPriceInCents(169);
        assertEquals(testItem.priceInCents, 169);
        testItem.setDescription("newDescription");
        assertEquals(testItem.getDescription(), "newDescription");
        testItem.setType("newType");
        assertEquals(testItem.getType(), "newType");
    }

    /**
     * Meant to test invalid inputs at menu items to see if those values pass through
     */
    @Test
    public void TestInvalidMenuItem()
    {
        MenuItem testItem = new MenuItem(10, "description", "name", "type");
        int negativePrice = -100;
        testItem.setPriceInCents(negativePrice);
        assertNotEquals(testItem.getPriceInCents(), negativePrice);
    }

    /**
     * ensure both array are identical
     * @param array1    first array to be passed in
     * @param array2    2nd array to be passed in
     * @return              true if it is completely identical. false if any one of them is false
     */
    public static boolean TestingBothItemArrays(ArrayList<MenuItem> array1, ArrayList<MenuItem> array2)
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
