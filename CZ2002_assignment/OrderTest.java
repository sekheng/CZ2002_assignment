package CZ2002_assignment;

import static org.junit.Assert.*;

import org.junit.Test;

public class OrderTest {

	@Test
	public void test() {
		
		Staff stafftest;
		stafftest = new Staff("Katy", 20, "5U34582", "Manager");
		Order testOrder;
		testOrder =new Order(stafftest, 7);
		OrderManager test = new OrderManager();
		test.addOrder(testOrder);
		System.out.println(test.getArrayofOrder().get(0).getTableID());
		test.removeOrder(7);
		System.out.println(test.getArrayofOrder());
	}

}
