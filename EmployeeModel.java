
public abstract class EmployeeModel {
  private String firstName;
  private String lastName;
  private int phoneNumber;

  // private _ scheduleRestrictions;
  // private _ mySchedule; // Schedule class not implemented yet
  private int startDate[3];
  
  public void setFirstName(String firstName){
    this.firstName = firstName; }
  
  public String getFirstName(){
    return firstName; }

  public void setLastName(String lastName) {
    this.lastName = lastName; }
  
  public String getLastName(){
    return lastName; }

  public void setPhoneNumber(int phoneNumber) {
    this.phoneNumber = phoneNumber; }
  
  public int getPhoneNumber(){
    return phoneNumber; }

  // void setScheduleRestrictions(){} //Waiting on Schedule model to be implemented
  // void getMySchedule(){}; //Waiting on Schedule model to be implemented

  public void setStartDate(int sDate[3]){
    this.startDate[0] = sDate[0];
    this.startDate[1] = sDate[1];
    this.startDate[2] = sDate[2]; }
  
  public int[3] setStartDate(){
    return startDate[3]; }

}
