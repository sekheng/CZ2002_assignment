package CZ2002_assignment;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Meant to test Staff manager and Staff item functions solely!
 * @author  Lee Sek Heng
 * @version 1.0
 * @since   2021-11-13
 */

public class StaffTesting {
    /**
     * Testing the behaviours and functions of MenuItemMgr
     */
	@Test
	public void StaffMgrTesting() {
		StaffMgr mystaffmgr = new StaffMgr();
		ArrayList<Staff> expectedResult = new ArrayList<Staff>(Arrays.asList(new Staff("Heng",1,"1","Waiter"),
																			new Staff("Jack",1,"2","Waiter"),
																			new Staff("Mary",0,"3","Waiter"),
																			new Staff("Ken",1,"4","Waiter"),
																			new Staff("Bean",1,"5","Manager"),
																			new Staff("Louis",1,"6","Chef")));
		
		// ensuring that the mystaffmgr creation is correct
		
		assertTrue("Expected Staff array is different from actual Staff array", StaffTesting.TestingBothItemArrays(mystaffmgr.getArrayOfStaff(), expectedResult));
		
		// then test the creation of menu item
		
		Staff Tstaff = new Staff("Test",1,"10","Tester");
		mystaffmgr.createStaff("Test",1,"10","Tester");
		expectedResult.add(Tstaff);
		assertTrue("Expected Staff array is different from actual Staff array", StaffTesting.TestingBothItemArrays(mystaffmgr.getArrayOfStaff(), expectedResult));
		
		// then test the updating of menu item
		
		Staff curStaff = mystaffmgr.getArrayOfStaff().get(mystaffmgr.getArrayOfStaff().size()-1);
		
		// currItem should be the same as testItem
        //myMenuMgr.updateMenuItem(currItem);
		
		curStaff.setName("newName");
		Tstaff.setName("newName");
		assertTrue("Expected Staff array is different from actual Staff array", StaffTesting.TestingBothItemArrays(mystaffmgr.getArrayOfStaff(), expectedResult));
		// then test removing the item from it
		mystaffmgr.removeStaff(mystaffmgr.getArrayOfStaff().size()-1);
		expectedResult.remove(Tstaff);
		assertTrue("Expected Staff array is different from actual Staff array", StaffTesting.TestingBothItemArrays(mystaffmgr.getArrayOfStaff(), expectedResult));
	}
	
    /**
     * Testing the behavior of menu item
     */
    @Test
    public void TestStaff()
    {
        Staff testStaff = new Staff("Test",1,"10","Tester");
        testStaff.setName("newName");
        assertEquals(testStaff.getName(), "newName");
    }
  
    /**
     * ensure both array are identical
     * @param array1    first array to be passed in
     * @param array2    2nd array to be passed in
     * @return              true if it is completely identical. false if any one of them is false
     */
	
    private static boolean TestingBothItemArrays(ArrayList<Staff> array1, ArrayList<Staff> array2)
    {
        if (array1.size() != array2.size())
        {
            return false;
        }
        for (int num = 0; num < array1.size(); ++num)
        {
            Staff first = array1.get(num);
            Staff sec = array2.get(num);
            if (first.getName().equals(sec.name) == false
            || first.getGender() != sec.getGender()
            || first.getEmployeeID().equals(sec.getEmployeeID()) == false
            || first.getJobTitle().equals(sec.getJobTitle()) == false
            )
            {
                return false;
            }
        }
        return true;
    }

}
