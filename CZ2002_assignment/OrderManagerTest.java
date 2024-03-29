package CZ2002_assignment;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
/**
 * Test cases for order manager
 * @author	Kanupriya Malhotra
 * @version	1.0
 * @since	2021-11-12
 */
public class OrderManagerTest {
	/**
	 * default staff test
	 */
	Staff stafftest = new Staff("Katy", 20, "5U34582", "Manager");
	/**
	 * order test 
	 */
	Order testOrder1 = new Order(stafftest, 8);
   /**
	* 2nd staff test
    */
    Staff stafftest2 = new Staff("Mary", 14, "5U34567", "Waitress");
	/**
	 * To test order and see if it can add and remove food item correctly
	 */
	@Test
	public void Ordertest() {
		
		assertEquals(testOrder1.getStaff(), stafftest);
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
	
	/**
	 * Testing order manager
	 */
	@Test
	public void OrderMgrtest() {
		
		OrderManager myOrderMgr = new OrderManager();
		
        ArrayList<Order> expectedOrderResult = new ArrayList<Order>();
        expectedOrderResult.add(testOrder1);
        myOrderMgr.addOrder(testOrder1);
        System.out.print(myOrderMgr.getArrayofOrder());
        System.out.print(expectedOrderResult);
     
        assertTrue("Expected Order Item array is different from actual Order Item array", OrderManagerTest.TestingOrderItemArrays(myOrderMgr.getArrayofOrder(),expectedOrderResult));


	
	}
	
	
	/**
	 * checking whether both arrays of food item is exactly the same
	 * @param array1	first array
	 * @param array2	2nd array
	 * @return	true if they are exactly the same
	 */
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
	/**
	 * Test whether both arrays of orders are exactly the same
	 * @param array	first array
	 * @param arrayy	second array
	 * @return	true if they are exactly the same
	 */
	 private static boolean TestingOrderItemArrays(ArrayList<Order> array, ArrayList<Order> arrayy)
	    {
		 
		 boolean flag = false;
		 
	        if (array.size() == arrayy.size())
	        {
	        	
	        	flag = true;
		        for(int i=1;i<array.size();i++) {
		        	if (array.get(i) == arrayy.get(i)) {
		        		flag =true;
		        	}
		        }
	        }
	        
	        
	        return flag;
	    }


}
