package SalaEmergencias;


import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class TriageSystem {

private Queue<Patient> priority1 = new LinkedList<>();
private Queue<Patient> priority2 = new LinkedList<>();
private Queue<Patient> priority3 = new LinkedList<>();

    

    // Registrar un nuevo paciente
    public String registerPatient(String name, int priority, String symptoms) {
        Patient patient = new Patient(name, new Date() , priority, symptoms);
        int currentPosition = 0;
        switch (priority) {
            case 1:
                priority1.offer(patient);
                currentPosition = priority1.size();
                break;
            case 2:
                priority2.offer(patient);
                currentPosition = priority2.size();
                break;
            case 3:
                priority3.offer(patient);
                currentPosition = priority3.size();
                break;
            default:
                break;
        }
        String returnString = "The queue position is " + currentPosition
                + " on the priority queue  " + priority;
        return returnString;
    }


    // Llamar al siguiente paciente (por prioridad)
    public Patient callNexPatient(){
        if(priority1.peek() != null){
            return priority1.poll();
        } 
        if (priority2.peek() != null){
            return priority2.poll();
        }
        if (priority3.peek() != null){
            return priority3.poll();
        } else {
            return null;
        }
    }

    // Consultar tiempo de espera estimado
    public String getWaitingTime(Patient patient){
        int waitingTime = 0;
        switch (patient.priority) {
            case 1:
                waitingTime = priority1.size() * 10; // Example: 10 minutes per patient
                break;
            case 2:
                waitingTime = (priority1.size() + priority2.size()) * 10;
                break;
            case 3:
                waitingTime = (priority1.size() + priority2.size() + priority3.size()) * 10;
                break;
            default:
                waitingTime = -1;
                break;
        }
        return "The estimated waiting time is " + waitingTime + " minutes.";
    }

    public int locatePatientOnQueue(Patient patient, Queue<Patient> queue){
        if (queue == null || queue.isEmpty()) {
            return -1; // Queue is empty or null
        }
        int position = 1; // Start position counting from 1
        for (Patient p : queue) {
            if (p.equals(patient)) {
                return position; // Patient found, return position
            }
            position++;
        }
        return -1; // Patient not found in the queue
    }
}
