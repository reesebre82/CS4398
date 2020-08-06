package Testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.*;

import System.API.*;

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

    @Test
    public void testGetCustomer3() {
        CustomerManager cm = new CustomerManager();
        Customer c = new Customer();
        c.setFirstName("George");
        c.setLastName("smith");
        cm.addCustomer(c);
        Customer customer = cm.getCustomer("George", "smith");

        assertEquals("George", customer.getFirstName());
    }

    @Test
    public void testGetCustomer4() {
        CustomerManager cm = new CustomerManager();
        Customer customer = cm.getCustomer("Reese", "Brendan");

        assertEquals("ERROR", customer.getFirstName());
    }

    @Test
    public void testUpdateCustomer() {
        CustomerManager cm = new CustomerManager();
        Customer customer = cm.getCustomer(1);
        customer.setFirstName("Brendan");
        customer.setLastName("Reese");
        cm.updateCustomer(customer.getCustomerID(), customer);

        Customer newCustomer = cm.getCustomer(1);

        assertEquals("Brendan", newCustomer.getFirstName());
    }

    @Test
    public void testAddPetWithCustomerID() {
        Pet pet = new Pet();
        pet.setPetID(1);
        pet.setName("Jackson");

        Customer customer = new Customer();

        CustomerManager cm = new CustomerManager();
        cm.addCustomer(customer);
        cm.addPetWithCustomerID(pet, customer.getCustomerID());

        assertEquals(1, customer.getPets().size());
    }

    @Test
    public void testRemovePet() {
        Pet pet = new Pet();
        pet.setPetID(1);
        pet.setName("Jackson");

        Customer customer = new Customer();

        CustomerManager cm = new CustomerManager();
        cm.addCustomer(customer);
        cm.addPetWithCustomerID(pet, customer.getCustomerID());

        cm.removePet(pet.getPetID(), customer.getCustomerID());

        assertEquals(0, customer.getPets().size());
    }

    @Test
    public void testRemoveCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("Jan");
        customer.setLastName("Mela");

        CustomerManager cm = new CustomerManager();
        cm.addCustomer(customer);
        cm.removeCustomer(customer.getCustomerID());

        assertEquals("ERROR", cm.getCustomer(customer.getCustomerID()).getFirstName());
    }
}