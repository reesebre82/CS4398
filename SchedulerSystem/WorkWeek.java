package SchedulerSystem;

import API.*;
import java.util.ArrayList;

public class WorkWeek {
    private int weekNum;
    private boolean populated = false;
    private ArrayList<WorkDay> days;

    public WorkWeek(int w) {
        weekNum = w;
        for (int i = 0; i < 7; i++) {
            WorkDay d = new WorkDay(i);
            days.add(d);
        }
    }

    public WorkDay getWorkDay(int i) {
        return days.get(i);
    }

    public ArrayList<Integer> employeeSchedule(Employee emp) {
        ArrayList<Integer> eSched = new ArrayList(7);
        for (int i = 0; i < 7; i++) {
            if (this.days.get(i).isWorking(emp)) {
                eSched.add(i);
            }
        }
        return eSched;
    }
}