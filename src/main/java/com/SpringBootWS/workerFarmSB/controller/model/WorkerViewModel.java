package com.SpringBootWS.workerFarmSB.controller.model;

public class WorkerViewModel {

    private String type="";
    private String firstName="";
    private String lastName="";

    public WorkerViewModel() {
    }

    public WorkerViewModel(String firstName, String lastName,String type) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getType() {
        return type;
    }
}
