
public class DatabaseTester {

    static void testUserAdditionWithEmployee() {
        Employee eModel = new Employee();
        eModel.setFirstName("Melanie");
        eModel.setEmployeeID(16);
        eModel.setLastName("Reese");
        eModel.setPhoneNumber("(512)618-8667");

        DatabaseManager.AddEmployee(eModel);
    }

    static void getEID() {
        System.out.println(DatabaseManager.getIncrementalEID());
    }
}