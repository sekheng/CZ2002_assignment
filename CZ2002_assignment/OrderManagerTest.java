package CZ2002_assignment;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class OrderManagerTest {

	@Test
	public void Ordertest() {
		
		Staff stafftest = new Staff("Katy", 20, "5U34582", "Manager");
		Order testOrder1 = new Order(stafftest, 8);
        assertEquals(testOrder1.getStaff(), stafftest);
        Staff stafftest2 = new Staff("Mary", 14, "5U34567", "Waitress");
        testOrder1.setStaff(stafftest2);
        assertEquals(testOrder1.getStaff(), stafftest2);
        
        ArrayList<FoodItem> expectedResult = new ArrayList<FoodItem>(Arrays.asList(new FoodItem(150,"Rice"),			
				new FoodItem(450,"Chicken Rice"),
				new FoodItem(780,"Chicken Burger"),
				new FoodItem(500,"Fish Sticks"),
				new FoodItem(600,"Fish 'n' Chips")));
        
        testOrder1.setArrayOfFoodItem(expectedResult);
        assertTrue("Expected Food Item array is different from actual Food Item array", OrderManagerTest.TestingFoodItemArrays(testOrder1.getArrayOfFoodItem(), expectedResult));

        
        FoodItem testFoodItem = new FoodItem(550,"Chicken Chop");
        testOrder1.addItem(testFoodItem);
        expectedResult.add(testFoodItem);
        
        assertTrue("Expected Food Item array is different from actual Food Item array", OrderManagerTest.TestingFoodItemArrays(testOrder1.getArrayOfFoodItem(), expectedResult));

        testOrder1.removeItem("Chicken Chop");
        expectedResult.remove(testFoodItem);
        
        assertTrue("Expected Food Item array is different from actual Food Item array", OrderManagerTest.TestingFoodItemArrays(testOrder1.getArrayOfFoodItem(), expectedResult));
        
	
	}
	
	
	@Test
	public void OrderMgrtest() {
		
		OrderManager myOrderMgr = new OrderManager();
		
		
        
        
	
	}
	
	
	
	 private static boolean TestingFoodItemArrays(ArrayList<FoodItem> array1, ArrayList<FoodItem> array2)
	    {
		 
		 boolean flag = false;
		 
	        if (array1.size() != array2.size())
	        {
	            flag = false;
	        }
	        if (array1 == array2) {
	        	flag = true;
	        }
	        
	        return flag;
	    }

}
