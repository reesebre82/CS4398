package System.SchedulerSystem;

import System.API.*;
import java.util.ArrayList;

public class WorkWeek {

    private ArrayList<WorkDay> days;
    private String weekDayStrings[] = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };

    WorkWeek() {
        days = new ArrayList<WorkDay>();

        for (int i = 0; i < 7; i++) {
            WorkDay workDay = new WorkDay();
            workDay.dayOfWeek = weekDayStrings[i];

            if (i < 5) {
                workDay.shiftHours = 4 * 8;
            } else if (i == 5) {
                workDay.shiftHours = 3 * 8;
            } else {
                workDay.shiftHours = 2 * 8;
            }
            days.add(workDay);
        }
    }

    /**
     * fillDay will is the algorithm that will fill the day with employees.
     * 
     * @param employees ArrayList<Employee> ArrayList of employees that may be added
     *                  to the day.
     * @param day       Integer day for the employees to be added to.
     * @return ArrayList<Employee>
     */
    private ArrayList<Employee> fillDay(ArrayList<Employee> employees, int day) {
        ArrayList<Integer> ignoreID = new ArrayList<Integer>();
        while (!days.get(day).isFull()) {
            int lowestEmployeeIndex = -1;
            int lowestEmployeeScheduled = 100000;
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).getScheduledHours() < lowestEmployeeScheduled) {
                    boolean found = false;
                    for (Integer EID : ignoreID) {
                        if (employees.get(i).getEmployeeID() == EID)
                            found = true;
                    }

                    if (!found) {
                        lowestEmployeeIndex = i;
                        lowestEmployeeScheduled = employees.get(i).getScheduledHours();
                    }
                } else if (employees.get(i).getScheduledHours() == lowestEmployeeScheduled) {
                    boolean found = false;
                    for (Integer EID : ignoreID) {
                        if (employees.get(i).getEmployeeID() == EID)
                            found = true;
                    }

                    if (!found) {
                        long check = Math.round(Math.random());
                        if (check == 0) {
                            lowestEmployeeIndex = i;
                            lowestEmployeeScheduled = employees.get(i).getScheduledHours();
                        }
                    }
                }
            }

            if (employees.size() == ignoreID.size()) {
                System.out.println("Not Enough Employees");
                return new ArrayList<Employee>();
            }

            ignoreID.add(employees.get(lowestEmployeeIndex).getEmployeeID());

            if (employees.get(lowestEmployeeIndex).getScheduledHours() < employees.get(lowestEmployeeIndex)
                    .getWeeklyHours()) {

                days.get(day).addEmployee(employees.get(lowestEmployeeIndex),
                        -employees.get(lowestEmployeeIndex).getWeeklyHours() / 5);
                employees.get(lowestEmployeeIndex)
                        .setScheduledHours(employees.get(lowestEmployeeIndex).getScheduledHours()
                                + employees.get(lowestEmployeeIndex).getWeeklyHours() / 5);
            }
        }
        return days.get(day).employees;
    }

    /**
     * fillWeek will fill the entire week with employees.
     * 
     * @param employees ArrayList<Employee> ArrayList of employees to fill week.
     * @return ArrayList<ArrayList<Employee>>
     */
    public ArrayList<ArrayList<Employee>> fillWeek(ArrayList<Employee> employees) {
        ArrayList<ArrayList<Employee>> employeesWorking = new ArrayList<ArrayList<Employee>>();
        for (int i = 0; i < 7; i++) {
            ArrayList<Employee> dayEmployees = fillDay(employees, i);
            employeesWorking.add(dayEmployees);
        }

        return employeesWorking;
    }

    /**
     * @return String
     */
    public String toString() {
        String str = "";
        for (int i = 1; i <= 7; i++) {
            System.out.println("Day " + i + ":");
            System.out.println(days.get(i - 1));
        }
        return str;
    }
}