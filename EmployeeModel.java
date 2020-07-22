
public abstract class EmployeeModel implements Model {
  private String firstName;
  private String lastName;
  private int phoneNumber;
  private double salary;

  // private _ scheduleRestrictions;
  // private _ mySchedule; // Schedule class not implemented yet
  private int startDate[3];
  
  public void setFirstName(String firstName){
    this.firstName = firstName; }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setPhoneNumber(int phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public void setSalary(int salary){
    this.salary = salary; }

  // void setScheduleRestrictions(){}
  // void getMySchedule(){};

  public void setStartDate(int startDate[3]){
    this.startDate[0] = startDate[0];
    this.startDate[1] = startDate[1];
    this.startDate[2] = startDate[2]; 
    }
  
}
