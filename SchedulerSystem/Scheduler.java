package SchedulerSystem;

import API.*;

import java.util.ArrayList;

public class Scheduler {

    public Scheduler() {

    }

    /**
     * @param employees ArrayList<Employee> ArrayList of employees to populate the
     *                  schedule.
     */
    public ArrayList<ArrayList<Employee>> PopulateWeek(ArrayList<Employee> employees) {
        ArrayList<Employee> deepCopyEmployees = new ArrayList<Employee>();
        for (Employee employee : employees) {
            deepCopyEmployees.add(new Employee(employee));
        }
        WorkWeek week = new WorkWeek();

        return week.fillWeek(deepCopyEmployees);
    }
}