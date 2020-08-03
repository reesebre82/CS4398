package SchedulerSystem;

import API.*;

import java.util.ArrayList;

public class Scheduler {
    private ArrayList<WorkWeek> weeks;

    public Scheduler() {
        weeks = new ArrayList<WorkWeek>();
        weeks.add(new WorkWeek());
    }

    public void PopulateWeek(ArrayList<Employee> employees) {
        for (WorkWeek week : weeks) {
            // Copy employees and post to week
            // that way each week employees get their hours
            ArrayList<Employee> deepCopyEmployees = new ArrayList<Employee>();
            for (Employee employee : employees) {
                deepCopyEmployees.add(new Employee(employee));
            }
            week.fillWeek(deepCopyEmployees);
            System.out.println(week);
        }
    }
}