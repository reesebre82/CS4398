package SchedulerSystem;

import API.*;

import java.util.ArrayList;

public class Scheduler {
    private ArrayList<WorkWeek> weeks;

    public Scheduler() {
        weeks = new ArrayList<WorkWeek>();
        weeks.add(new WorkWeek());
    }

    /**
     * @param employees ArrayList<Employee> ArrayList of employees to populate the
     *                  schedule.
     */
    public void PopulateWeek(ArrayList<Employee> employees) {
        for (WorkWeek week : weeks) {
            ArrayList<Employee> deepCopyEmployees = new ArrayList<Employee>();
            for (Employee employee : employees) {
                deepCopyEmployees.add(new Employee(employee));
            }
            week.fillWeek(deepCopyEmployees);
            System.out.println(week);
        }
    }
}