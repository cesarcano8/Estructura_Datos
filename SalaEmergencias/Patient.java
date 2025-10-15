package SalaEmergencias;

import java.util.Date;

public class Patient {
    String name;
    Date arrivalTime;
    int priority;
    String symptoms;

    public Patient(String name, Date arrivalTime ,int priority, String symptoms) {
        this.name = name;
        this.arrivalTime = new Date();
        this.priority = priority;
        this.symptoms = symptoms;
    }





    public String toString(){
        return this.name + " - " + this.priority + " - " + this.symptoms + " - " + this.arrivalTime;
    }
    
}
