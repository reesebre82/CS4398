package Testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.*;

import API.*;

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
}