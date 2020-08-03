package SchedulerSystem;

import API.*;
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

    private void fillDay(ArrayList<Employee> employees, int day) {
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
                return;
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
    }

    public void fillWeek(ArrayList<Employee> employees) {
        for (int i = 0; i < 7; i++) {
            fillDay(employees, i);
        }
    }

    public String toString() {
        String str = "";
        for (int i = 1; i <= 7; i++) {
            System.out.println("Day " + i + ":");
            System.out.println(days.get(i - 1));
        }
        return str;
    }
}