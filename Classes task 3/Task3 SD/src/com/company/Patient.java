package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Patient {
    static ArrayList<Booth> PatientList = new ArrayList<>();          //Creating arraylist
    static LinkedList<String> WaitingList=new LinkedList<>();         //Creating LinkedList

    public static void initialise(String[] hotelRef) {
        for (int x = 0; x < 6; x++) hotelRef[x] = "empty";
        System.out.println("initialise ");
    }

    public static void ViewVacinationBooths(String[] ServiceCenter) {
        for (int x = 0; x < 6; x++) {
            System.out.println("Booth  " + x + " : " + ServiceCenter[x]);
        }
    }

    public static void ViewEmptyBooths(String[] ServiceCenter) {
        for (int x = 0; x < 6; x++) {
            if (ServiceCenter[x].equals("empty")) System.out.println("Booth " + x + " is empty");
        }
    }

    public static void AddPatient(String[] ServiceCenter) {
        Scanner input = new Scanner(System.in);
        int boothNum = 0;



            Booth mybooth=new Booth();
            System.out.println("Enter the type of vacination you need(AstraZeneca,Sinopharm,Pfizer):");
            Scanner obj=new Scanner(System.in);
            String type=obj.nextLine();
            mybooth.setType(type);

            System.out.println("Enter Booth number (0-5):\nBooth 0 & 1-AstraZeneca\nBooth 2 & 3-Sinopharm\nBooth 4 & 5-Pfizer");
            boothNum = input.nextInt();
            mybooth.setBoothNum(boothNum);

            if (ServiceCenter[boothNum].equals("empty")) {
                Scanner myobj1 = new Scanner(System.in);
                System.out.println("Enter your first Name :");
                String customerName = myobj1.nextLine();
                mybooth.setCustomerName(customerName);
                Scanner myobj2 = new Scanner(System.in);
                System.out.println("Enter Surname");
                String Surname = myobj2.nextLine();
                mybooth.setSurname(Surname);
                Scanner myobj3 = new Scanner(System.in);
                System.out.println("Enter Age");
                int age = myobj3.nextInt();
                mybooth.setAge(age);
                Scanner myobj4 = new Scanner(System.in);
                System.out.println("Enter your city ");
                String city = myobj4.nextLine();
                mybooth.setCity(city);
                Scanner myobj5=new Scanner(System.in);
                System.out.println("Enter your NIC or passport number ");
                int No = myobj5.nextInt();
                mybooth.setNIC(No);
                System.out.println("Patient added to the booth");
                ServiceCenter[boothNum] = customerName;
                PatientList.add(mybooth);


            } else {
                System.out.println("Booth is not available");
                WaitingList.add(mybooth.getCustomerName());
                System.out.println("Patient is added to the waiting list");
            }
        }


    public static void RemovePatient(String[] ServiceCenter) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the booth number between 0-5 to remove patient");
        int Num = input.nextInt();
        if (!ServiceCenter[Num].equals("empty")) {
            ServiceCenter[Num] = "empty";
            System.out.println("Patient in the booth number" + Num + "is removed");

        } else {
            System.out.println(" Booth" + Num + "is already empty");
        }
    }


    public static void ViewinOrder(String[] ServiceCenter) {
        String[] Array = new String[6];
        boolean sort;
        System.arraycopy(ServiceCenter, 0, Array, 0, Array.length);
        do {
            sort = false;
            for (int i = 0; i < Array.length - 1; i++) {
                if (Array[i].compareTo(Array[i + 1]) > 0) {
                    String temp = Array[i + 1];
                    Array[i + 1] = Array[i];
                    Array[i] = temp;
                }
            }
        } while ((sort));
        System.out.println("Names are now in alphabetical order");
        for (int i = 0; i < Array.length; i++) {
            System.out.println(Array[i]);
        }
    }

    public static void StoretoFile() throws IOException {
        File file = new File("C:\\Users\\ruchi\\IdeaProjects\\SD CW w1830126\\Classes task 3\\Task3 Details.txt");
        FileWriter fw;
        PrintWriter pw;

        fw = new FileWriter(file);
        pw = new PrintWriter(fw,true);

        try {
            for (int j = 0; j < PatientList.size(); j++) {
                pw.println("First name:"+PatientList.get(j).getCustomerName()+" "+"Surname:"+PatientList.get(j).getSurname()+" "+"Age:"+PatientList.get(j).getAge()+" "+"City:"+PatientList.get(j).getCity()+" "+"NIC:"+PatientList.get(j).getNIC()+" "+"Type:"+PatientList.get(j).getType());

            }
            pw.close();
            fw.close();
            System.out.println("Stored data to the file");
        } catch (IOException e) {
            System.out.println("File is not created");
        }
    }
    public static void LoadfromFile(String[] ServiceCenter) {
        System.out.println("File Successfully loaded");
        try {
            File myObj = new File("C:\\Users\\ruchi\\IdeaProjects\\SD CW w1830126\\Classes task 3\\Task3 Details.txt");
            Scanner sc = new Scanner(myObj);
            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                System.out.println(data);
            }
            sc.close();
        } catch (FileNotFoundException e) {
        }

    }

}






