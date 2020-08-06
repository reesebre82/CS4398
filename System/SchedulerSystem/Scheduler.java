package System.SchedulerSystem;

import System.API.*;

import java.util.ArrayList;

public class Scheduler {

    public Scheduler() {
    }

    /**
     * populateWeek will create a schedule and return a 2D array for the week and
     * employee per day.
     * 
     * @param employees ArrayList of employees that will be entered into the days.
     * @return ArrayList<ArrayList<Employee>>
     */
    public ArrayList<ArrayList<Employee>> populateWeek(ArrayList<Employee> employees) {
        ArrayList<Employee> deepCopyEmployees = new ArrayList<Employee>();
        for (Employee employee : employees) {
            deepCopyEmployees.add(new Employee(employee));
        }
        WorkWeek week = new WorkWeek();

        return week.fillWeek(deepCopyEmployees);
    }
}