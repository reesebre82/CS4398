
public abstract class EmployeeModel {
  private String firstName;
  private String lastName;
  private int phoneNumber;

  // private _ scheduleRestrictions;
  // private _ mySchedule; // Schedule class not implemented yet
  private int startDate[];

  EmployeeModel() {
    startDate = new int[3];
    firstName = "";
    lastName = "";
    phoneNumber = 0;
  }

  EmployeeModel(String firstName, String lastName, int phoneNumber) {
    startDate = new int[3];
    this.firstName = firstName;
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setPhoneNumber(int phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public int getPhoneNumber() {
    return phoneNumber;
  }

  // void setScheduleRestrictions(){} //Waiting on Schedule model to be
  // implemented
  // void getMySchedule(){}; //Waiting on Schedule model to be implemented

  public void setStartDate(int sDate[]) {
    this.startDate[0] = sDate[0];
    this.startDate[1] = sDate[1];
    this.startDate[2] = sDate[2];
  }

  // public int[] getStartDate(){
  // return startDate;
  // }

}
