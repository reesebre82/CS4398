package Testing;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.*;

import API.*;

public class CustomerManagerTester {

    @Test
    public void testGetCustomer() {
        CustomerManager cm = new CustomerManager();
        Customer customer = cm.getCustomer(1);

        assertNotEquals("ERROR", customer.getFirstName());
    }

    @Test
    public void testGetCustomer2() {
        CustomerManager cm = new CustomerManager();
        Customer customer = cm.getCustomer(-1);

        assertEquals("ERROR", customer.getFirstName());
    }
}