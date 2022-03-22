package com.SpringBootWS.workerFarmSB.controller.model;

public class WorkingHoursViewModel {

    private int weekNumber;
    private int hours;

    public WorkingHoursViewModel() {
    }

    public WorkingHoursViewModel(int weekNumber, int hours) {
        this.weekNumber = weekNumber;
        this.hours = hours;
    }

    public int getWeekNumber() {
        return weekNumber;
    }

    public int getHours() {
        return hours;
    }
}
