package Testing;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.*;

import System.API.*;

/**
 * CustomerTester
 */
public class CustomerTester {

    @Test
    public void testAddPet() {
        Customer customer = new Customer();
        customer.addPet(new Pet());

        assertEquals(1, customer.getPets().size());
    }

    @Test
    public void testRemovePet() {
        Customer customer = new Customer();
        Pet pet = new Pet();
        pet.setPetID(1);
        customer.addPet(pet);

        customer.removePet(1);
        customer.getPets();
        assertEquals(0, customer.getPets().size());
    }

    @Test
    public void testRemovePet2() {
        Customer customer = new Customer();
        Pet pet = new Pet();
        pet.setPetID(1);
        customer.addPet(pet);

        customer.removePet(2);
        assertEquals(1, customer.getPets().size());
    }

    @Test
    public void testGetPets() {
        Customer customer = new Customer();
        customer.addPet(new Pet());
        customer.addPet(new Pet());
        customer.addPet(new Pet());

        assertEquals(3, customer.getPets().size());
    }

    @Test
    public void testGetPets2() {
        Customer customer = new Customer();
        customer.addPet(new Pet());
        customer.addPet(new Pet());
        Pet pet = new Pet();
        pet.setPetID(1);
        customer.addPet(pet);
        customer.removePet(1);

        assertEquals(2, customer.getPets().size());
    }

    @Test
    public void testUpdatePet() {
        Customer customer = new Customer();
        customer.addPet(new Pet());
        customer.addPet(new Pet());
        Pet pet = new Pet();
        pet.setPetID(1);
        pet.setName("Joe");
        customer.addPet(pet);

        Pet newPet = new Pet();
        newPet.setName("Bobby");
        customer.updatePet(1, newPet);

        Pet finalPet = null;
        for (int i = 0; i < customer.getPets().size(); i++)
            if (customer.getPets().get(i).getName() == newPet.getName())
                finalPet = customer.getPets().get(i);

        assertNotEquals(null, finalPet);
    }
}