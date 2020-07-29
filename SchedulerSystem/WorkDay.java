package SchedulerSystem;

import API.*;
import java.util.ArrayList;

public class WorkDay {
    private int dayOfWeek;
    private int openShifts;
    private double openTime;
    private double closeTime;
    private ArrayList<Employee> empSched;

    public WorkDay(int day) {
        dayOfWeek = day;
        if (day <= 4) {
            openShifts = 4;
            openTime = 9;
            closeTime = 5;
        } else if (day == 5) {
            openShifts = 8;
            openTime = 10;
            closeTime = 6;
        } else {
            openShifts = 0;
            openTime = 0;
            closeTime = 0;
        }
        empSched = new ArrayList<Employee>(openShifts);
    }

    public void setDayOfWeek(int day) {
        this.dayOfWeek = day;
    }

    public int getDayOfWeek() {
        return this.dayOfWeek;
    }

    public void addShifts(int shifts) {
        this.openShifts += shifts;
    }

    public void removeShifts(int shifts) {
        this.openShifts -= shifts;
    }

    public int numOpenShifts() {
        return this.openShifts;
    }

    public boolean shiftsAvailable() {
        if (numOpenShifts() > 0)
            return true;
        else
            return false;
    }

    public void setOpenTime(double open) {
        this.openTime = open;
    }

    public double getOpenTime() {
        return this.openTime;
    }

    public void setCloseTime(double close) {
        this.closeTime = close;
    }

    public double getCloseTime() {
        return this.closeTime;
    }

    public void closeShop() {
        this.openShifts = 0;
        this.openTime = 0;
        this.closeTime = 0;
    }

    public void addEmployee(Employee e) {
        if (this.openShifts > 0) {
            this.empSched.add(e);
            this.openShifts--;
        }
    }

    public void removeEmployee(Employee e) {
        if (empSched.contains(e)) {
            this.empSched.remove(e);
            this.openShifts++;
        }
    }

    public boolean isWorking(Employee emp) {
        if (empSched.contains(emp))
            return true;
        else
            return false;
    }

    public ArrayList<Employee> getEmployees() {
        return empSched;
    }
}
