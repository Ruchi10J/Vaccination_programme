import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;

import java.util.Scanner;


public class ServiceCenterExample {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String customerName = null;
        String customerSurname=null;
        int boothNum = 0;
        int vaccines = 150;


        String[] ServiceCenter = new String[6];

        initialise(ServiceCenter); //better to initialise in a procedure
        while (true) {

            System.out.println("****************************************");
            System.out.println("100 or VVB: View all Vaccination Booths");
            System.out.println("101 or VEB: View all Empty Booths");
            System.out.println("102 or APB: Add Patient to a Booth");
            System.out.println("103 or RPB: Remove Patient from a Booth");
            System.out.println("104 or VPS: View Patients Sorted in alphabetical order");
            System.out.println("105 or SPD: Store Program Data into file");
            System.out.println("106 or LPD: Load Program Data from file:");
            System.out.println("107 or VRV: View Remaining Vaccinations");
            System.out.println("108 or AVS: Add Vaccinations to the Stock");
            System.out.println("999 or EXT: Exit the Program");
            System.out.println("******************************************");
            System.out.println("Enter your option:");

            String option = input.next();
            if(option.equals("100")||option.equals("VVB")){

                for (int x = 0; x < 6; x++) {
                    System.out.println("Booth  " + x + " : " + ServiceCenter[x]);
                }
            }else if(option.equals("101")||option.equals("VEB")){                  //To show empty booths
                while (boothNum < 6) {
                    for (int x = 0; x < 6; x++) {
                        if (ServiceCenter[x].equals("empty")) System.out.println("Booth " + x + " is empty");
                    }
                    break;
                }

            } else if (option.equals("102")||option.equals("APB")) {                        //To add patients
                System.out.println("Enter the type of vaccine you need(AstraZeneca,Sinopharm,Pfizer):");
                String type=input.next();

                System.out.println("Enter Booth number (0-5) or 6 to stop:\nBooth 0 & 1-AstraZeneca\nBooth 2 & 3-Sinopharm\nBooth 4 & 5-Pfizer:");
                boothNum = input.nextInt();
                if (boothNum == 6) {
                    continue;
                } else if (ServiceCenter[boothNum].equals("empty")) {
                    System.out.println("Enter customer name :");
                    customerName = input.next();
                    ServiceCenter[boothNum] = customerName;

                    System.out.println("Enter customer surname :");
                    customerSurname = input.next();
                    System.out.println("Patient is added to booth");

                    vaccines = vaccines - 1;
                    if (vaccines == 20) {
                        System.out.println("Vaccine stock has reached a value of 20");
                    }
                } else {
                    System.out.println("Booth is not available");
                }
            } else if (option.equals("103")||option.equals("RPB")) {
                System.out.println("Enter the booth number you want to remove");
                int remove = input.nextInt();
                ServiceCenter[remove] = "empty";
                System.out.println("Patient is removed");
            } else if (option.equals("104")||option.equals("VPS")) {                 //Sorting in alphabetical order
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
            } else if (option.equals("105")||option.equals("SPD")) {                 //saving to file
                try {
                    FileWriter fw = new FileWriter("C:\\Users\\ruchi\\IdeaProjects\\SD CW w1830126\\Arrays task1\\Details.txt");
                    PrintWriter pw;
                    pw = new PrintWriter(fw, true);
                    for (int i=0;i<ServiceCenter.length;i++) {
                        pw.println(ServiceCenter[i]);
                    }

                    fw.close();
                    System.out.println("data updated to file successfully");
                } catch (Exception e) {
                }
            }else if(option.equals("106")||option.equals("106")){                    //Loading from file

                    System.out.println("File Successfully loaded");
                    try {
                        File myObj = new File("C:\\Users\\ruchi\\IdeaProjects\\SD CW w1830126\\Arrays task1\\Details.txt");
                        Scanner sc = new Scanner(myObj);
                        while (sc.hasNextLine()) {
                            String data = sc.nextLine();
                            System.out.println(data);
                        }
                        sc.close();
                    } catch (FileNotFoundException e) {
                    }

            } else if (option.equals("107")||option.equals("VRV")) {

                System.out.println("Remaining number of vaccines are " + vaccines);
            } else if (option.equals("108")||option.equals("AVS")) {
                vaccines = vaccines + 1;
                System.out.println("Vaccine is added to stock");

            }else if(option.equals("109")||option.equals("EXT")){
                break;
            }

            }


    }

        private static void initialise (String hotelRef[] ){
            for (int x = 0; x < 6; x++) hotelRef[x] = "empty";
            System.out.println("initialise ");
        }

       

    }


