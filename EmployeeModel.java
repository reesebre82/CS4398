package scheduler.model;

public abstract class EmployeeModel implements Model {
  private String firstName;
  private String lastName;
  private int phoneNumber;
  private double salary;
  // private _ scheduleRestrictions;
  // private _ mySchedule; // Schedule class not implemented yet
  private int startDate[3];
  
  public void setFirstName(String fName){
    firstName = fName; }
  
  public void setLastName(String lName){
    lastName = lName; }
    
  public void setPhoneNumber(int pNum){
    phoneNumber = pNum; }
  
  public void setSalary(int sal){
    salary = sal; }
    
  // void setScheduleRestrictions(){}
  // void getMySchedule(){};
    
  public void setStartDate(int sDate[3]){
  startDate[0] = sDate[0];
  startDate[1] = sDate[1];
  startDate[2] = sDate[2]; }
  
}
