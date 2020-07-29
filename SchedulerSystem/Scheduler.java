package SchedulerSystem;

import API.*;
import DatabaseSystems.*;

import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Scheduler {
    private ArrayList<WorkWeek> weeks;

    /*
     * public void populateSchedule(){ weeks =
     * DatabaseManager.getScheduleFromDatabase(); }
     */

    public void generateSchedule(int w) {
        try {
            weeks.add(new WorkWeek(w));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void populateWeek(int w) {
        try {
            WorkWeek thisWeek = weeks.get((w - 1));
            ArrayList<Employee> employeeList = DatabaseManager.getEmployeesFromDatabase();
            int shiftsGiven = 0;

            // for (int i = 0; i < employeeList.size(); i++) {
            // Employee thisEmployee = employeeList.get(i);
            // for (int j = 0; j < 7; j++) {
            // WorkDay thisDay = thisWeek.getWorkDay(j);
            // if (thisDay.shiftsAvailable() && !thisDay.isWorking(thisEmployee)) {
            // if (shiftsGiven < 5 && isAvailable(thisEmployee, w, i)) {
            // thisDay.addEmployee(thisEmployee);
            // }
            // }
            // }
            // }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // public boolean isAvailable(Employee emp, int week, int day){
    // if (emp.getPermSchedRestriction().contains(day)) return false;
    // else return true;
    // }
}