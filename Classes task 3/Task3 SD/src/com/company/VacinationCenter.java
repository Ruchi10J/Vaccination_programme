package com.company;

import java.io.IOException;
import java.util.Scanner;
import static com.company.Patient.*;

public class VacinationCenter {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int vacines = 150;

        String[] ServiceCenter = new String[6];         //Creating array


        initialise(ServiceCenter);
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
                    vacines=vacines-1;
                    if (vacines<=20){
                        System.out.println("Vaccine stock has reached a value of 20");
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
                    StoretoFile();
                    break;
                case "106":
                case "LPD":
                    LoadfromFile(ServiceCenter);
                    break;
                case "107":
                case "VRV":
                    System.out.println("Remaining number of vacines are "+vacines);
                    break;
                case "108":
                case "AVS":
                    vacines=vacines+1;
                    System.out.println("Vaccination is added to stock");
                    break;
                case "999":
                case "EXT":
                    return;
                default:
                    System.out.println("Incorrect Input. Try Again");
                    break;
            }


            }
        }
    }






