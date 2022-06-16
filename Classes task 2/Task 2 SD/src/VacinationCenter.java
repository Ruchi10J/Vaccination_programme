import java.io.*;
import java.io.FileWriter;
import java.util.Scanner;

public class VacinationCenter {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int vacine = 150;

        String[] ServiceCenter = new String[6];


        initialise(ServiceCenter);
        while (true) {
            System.out.println("****************************************");
            System.out.println("100 or VVB: View all Vaccination Booths");
            System.out.println("101 or VEB: View all Empty Booths");
            System.out.println("102 or APB: Add Patient to a Booth");
            System.out.println("103 or RPB: Remove Patient from a Booth");
            System.out.println("104 or VPS: View Patients Sorted in alphabetical order ");
            System.out.println("105 or SPD: Store Program Data into file");
            System.out.println("106 or LPD: Load Program Data from file:");
            System.out.println("107 or VRV: View Remaining Vaccinations");
            System.out.println("108 or AVS: Add Vaccinations to the Stock");
            System.out.println("999 or EXT: Exit the Program");
            System.out.println("******************************************");
            System.out.println("Enter your option:");
            String option = input.nextLine().toUpperCase();
            switch (option) {
                case "100":
                case "VVB":
                    ViewVacinationBooths(ServiceCenter);

                    break;
                case "101":
                case "VEB":
                    ViewEmptyBooths(ServiceCenter);
                    break;
                case "102":
                case "APB":
                    AddPatient(ServiceCenter);
                    vacine = vacine - 1;
                    if (vacine <= 20) {
                        System.out.println("Stock has reached value of 20");
                    }

                    break;
                case "103":
                case "RPB":
                    RemovePatient(ServiceCenter);
                    break;

                case "104":
                case "VPS":
                    ViewinOrder(ServiceCenter);
                    break;
                case "105":
                case "SPD":
                    StoretoFile(ServiceCenter);
                    break;
                case "106":
                case "LPD":
                    LoadfromFile(ServiceCenter);
                    break;
                case "107":
                case "VRV":
                    System.out.println("Remaining number of vaccines are "+ vacine);
                    break;
                case "108":
                case "AVS":
                    vacine = vacine + 1;
                    System.out.println("Vaccination is added to stock");
                    break;
                case "999":
                case "EXT":
                    return;
                default:
                    System.out.println("Incorrect Input. Try again");
                    break;
            }


        }
    }


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


        System.out.println("Enter Booth number (0-5) :");
        boothNum = input.nextInt();
        Booth mybooth=new Booth();
        mybooth.setBoothNum(boothNum);

        if (ServiceCenter[boothNum].equals("empty")) {
            Scanner myobj1 = new Scanner(System.in);
            System.out.println("Enter your Name :");
            String customerName = myobj1.nextLine();
            mybooth.setCustomerName(customerName);

            System.out.println(customerName + " is added to the booth");
            ServiceCenter[boothNum] = customerName;


        } else {
            System.out.println("Booth is not available");
        }
    }


    public static void RemovePatient(String[] ServiceCenter) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the booth number between 0-5 to remove patient");
        int Num = input.nextInt();
        if (!ServiceCenter[Num].equals("empty")) {
            ServiceCenter[Num] = "empty";
            System.out.println("Patient in the booth number " + Num + "is removed");
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

    public static void StoretoFile(String[] ServiceCenter)  {
        try {
            FileWriter fw = new FileWriter("C:\\Users\\ruchi\\IdeaProjects\\SD CW w1830126\\Classes task 2\\Task2 Details.txt");
            PrintWriter pw;
            pw = new PrintWriter(fw, true);
            for (int i=0;i<ServiceCenter.length;i++) {
                pw.println(ServiceCenter[i]);
            }

            fw.close();
            System.out.println("data updated to file successfully");
        } catch (Exception e) {
        }
    }

    public static void LoadfromFile(String[] ServiceCenter) {
        System.out.println("File Successfully loaded");
        try {
            File myObj = new File("C:\\Users\\ruchi\\IdeaProjects\\SD CW w1830126\\Classes task 2\\Task2 Details.txt");
            Scanner sc = new Scanner(myObj);
            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                System.out.println(data);
            }
            sc.close();
        } catch (
                FileNotFoundException e) {
        }


    }
}










