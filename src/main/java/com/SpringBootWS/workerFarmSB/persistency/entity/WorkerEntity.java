package com.SpringBootWS.workerFarmSB.persistency.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WorkerEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private int workHour=0;
    private double hourlyCost=0;
    private String firstName;
    private String lastName;
    private int weekNumber=1;

    public void setWorkHour(int workHour) {
        this.workHour = workHour;
    }

    private String type;

    public WorkerEntity(){}

    public WorkerEntity(String firstName, String lastName, String type, int workHour, double hourlyCost) {
        this.workHour = workHour;
        this.hourlyCost = hourlyCost;
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
    }

    public WorkerEntity(String firstName, String lastName,String type) throws Exception {
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;

        if(type.equals("Child")){
            this.hourlyCost = 10;
            this.workHour = 30;
        }
        else if(type.equals("Disabled")){
            this.hourlyCost = 10;
            this.workHour = 10;
        }
        else if(type.equals("Lazy")){
            this.hourlyCost = 23;
            this.workHour = 20;
        }
        else if(type.equals("Good")){
            this.hourlyCost = 40;
            this.workHour = 40;
        }
        else
            throw new Exception(" invalid type of worker!");

    }

    public double getSalary() {
        return workHour * hourlyCost *weekNumber;
    }
    public int getWorkHour() {
        return workHour;
    }
    public double getHourlyCost() {
        return hourlyCost;
    }
    public String getType() {
        return type;
    }
    public String getFirstName() {
        return firstName;
    }
    public int getWeekNumber() {return weekNumber;}
    public String getLastName() {
        return lastName;
    }
    public Long getId() {
        return id;
    }

    public void setWeekNumber(int weekNumber) {
        this.weekNumber = weekNumber;
    }

}
