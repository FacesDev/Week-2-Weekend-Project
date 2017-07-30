package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by solderedmachd on 7/27/17.
 */
public class Creator {

   private static double idCounter = 100;

    public void createWorkOrders() {
        Scanner scannerInput = new Scanner(System.in);

        System.out.println( "TELL ME WHO YOU ARE: <Your name>");
        String  senderNameCreator = scannerInput.nextLine();

        System.out.println("SHOW ME WHAT YOU GOT: <Work Order Description>");
        String  descriptionCreator = scannerInput.nextLine();
        System.out.println("Thank Youuuuuuuuuuuuuu " + senderNameCreator);

        idCounter = Math.floor((Math.random() * 9000) + 1000);
        WorkOrder workOrder = new WorkOrder(idCounter,descriptionCreator, senderNameCreator, Status.INITIAL);

        ObjectMapper mapper = new ObjectMapper();
        String json;
        try {
            File newJson = new File(workOrder.getId() + ".json");
            json = mapper.writeValueAsString(workOrder);
            FileWriter createFile = new FileWriter(newJson);
            createFile.write(json);
            createFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Creator creator = new Creator();
        creator.createWorkOrders();


    }

}
