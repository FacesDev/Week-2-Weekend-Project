package com.company;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.xml.internal.ws.api.message.Packet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.Key;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static com.company.Status.ASSIGNED;
import static com.company.Status.INITIAL;
import static com.company.Status.IN_PROGRESS;
import static com.company.Status.DONE;


public class Processor {
    Map<Status, Set<WorkOrder>> workOrderMap = new HashMap<>();

    Set<WorkOrder> assignedSet = new HashSet<>();
    Set<WorkOrder> inProgressSet = new HashSet<>();
    Set<WorkOrder> doneSet = new HashSet<>();

    public void processWorkOrders() {
        readIt();
        moveIt();



    }
    private void readIt() {
        ObjectMapper mapper = new ObjectMapper();
        Set<WorkOrder> value = new HashSet();
        File folder = new File(".");
        for (File file : folder.listFiles()) {
            if (file.getName().endsWith(".json")) {
                try (FileReader jsonFiles = new FileReader(file)) {
                    WorkOrder workOrderProcessor = mapper.readValue(jsonFiles, WorkOrder.class);
                        value.add(workOrderProcessor);
                        file.delete();
                        workOrderMap.put(INITIAL, value);
                } catch (JsonMappingException e) {
                    e.printStackTrace();
                } catch (JsonParseException e) {
                    e.printStackTrace();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                }
            }
        }

    }
    private void moveIt() {
        System.out.println("WORK ORDER:" + workOrderMap);
        Set<WorkOrder> initialSet = workOrderMap.get(INITIAL);
        System.out.println("Initial: " + initialSet);
        System.out.println("Assigned: " + assignedSet);
        System.out.println("In Progress: " + inProgressSet);
        System.out.println("Done: " + doneSet);

        for(WorkOrder order : inProgressSet) {
            doneSet.add(order);
        }
        inProgressSet.clear();

        for(WorkOrder order : assignedSet){
            inProgressSet.add(order);
        }

        assignedSet.clear();

        for(WorkOrder order : initialSet){
            assignedSet.add(order);
        }
        initialSet.clear();

    }

    public static void main(String args[]) {
        Processor processor = new Processor();

        try {
            while(true) {
                processor.processWorkOrders();

                Thread.sleep(5000l);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}