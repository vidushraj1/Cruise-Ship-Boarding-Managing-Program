package com.example.cruise_shiptask1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CruiseShipExample {
    //this main class runs inorder to get the option that was chosen by the user.
    public static void main(String[] args) {
        //this scanner class is called over here so that this class can be used in any methods.
        Scanner input = new Scanner(System.in);
        String choice;
        String choice2 = "Y";
        //this array is used to store the values of the cabin name.
        String[] CruiseCabin = new String[12];
        //this array is used to store the values of the firstname of the passenger.
        String[] FirstNameCabin = new String[12];
        //this array is used to store the values of the surname of the passenger.
        String[] SurNameCabin = new String[12];
        initialise(CruiseCabin,FirstNameCabin,SurNameCabin); //better to initialise in a procedure.
        while (choice2.equals("Y")) {
            //menu method is called over here
            Menu();
            System.out.println("Enter your choice: ");
            choice = input.next().toUpperCase();
            switch (choice) {
                //conditional statement is used here to call each particular method whenever an option is selected.
                case "V":
                    ViewCabin(CruiseCabin, FirstNameCabin, SurNameCabin);
                    break;
                case "A":
                    AddPassenger(CruiseCabin, FirstNameCabin, SurNameCabin);
                    break;
                case "E":
                    EmptyDisplay(CruiseCabin);
                    break;
                case "D":
                    DeletePassenger(CruiseCabin, FirstNameCabin, SurNameCabin);
                    break;
                case "F":
                    FindCabin(CruiseCabin);
                    break;
                case "S":
                    StoreFile(CruiseCabin, FirstNameCabin, SurNameCabin);
                    break;
                case "L":
                    LoadFile();
                    break;
                case "O":
                    ViewOrderedPassenger(CruiseCabin);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
            do {
                System.out.println("Do you want to choose another option from the menu?");
                System.out.println("'Y' for Yes or 'N' for No");
                choice2 = input.next().toUpperCase();
                if (choice2.equals("N")) {
                    System.out.println("Thank You. You are about to exit the program");
                    break;
                }
            }while (!(choice2.equals("Y")));

        }
    }
    private static void initialise(String[] CruiseCabin, String[] FirstNameCabin, String[] SurNameCabin){
        //the necessary parameters are passed to this method.
        //the method will initialise the arrays.
        for (int x = 0; x < 12; x++) {
            CruiseCabin[x] = "e";
            FirstNameCabin[x] = "empty";
            SurNameCabin[x] = "empty";
        }
    }

    private static void Menu() {
        //this method will basically print how the menu should be displayed to the user.
        System.out.println("Enter 'A' to add a passenger to a Cabin");
        System.out.println("Enter 'V' to view all Cabin");
        System.out.println("Enter 'E' to display empty Cabin ");
        System.out.println("Enter 'D' to delete passenger from Cabin ");
        System.out.println("Enter 'F' Find Cabin from passenger name");
        System.out.println("Enter 'S' Store program data into file");
        System.out.println("Enter 'L' Load program data from file");
        System.out.println("Enter 'O' View passengers Ordered alphabetically by name");
    }

    public static void AddPassenger(String[] CruiseCabin, String[] FirstNameCabin, String[] SurNameCabin){
        //the necessary parameters are passed to this method.
        //the method will add the passengers to each cabin.
        Scanner input = new Scanner(System.in);
        String s;
        System.out.println("Enter Cabin number (0-11) or 12 to stop:");
        int CabinNo = input.nextInt();
        if ((CabinNo == 12) || (CabinNo > 12)) {
            System.out.println("Thank You. You are going back to menu");
            System.out.println("**************************************************************************************");
            System.out.println("**************************************************************************************");
            return;
        } else if (CruiseCabin[CabinNo].equals("e")) {
            System.out.println("Enter first name of the passenger for Cabin " + CabinNo + ":");
            String fName = input.next().toUpperCase();
            CruiseCabin[CabinNo] = fName;
            FirstNameCabin[CabinNo] = fName;
            System.out.println("Enter surname of the passenger for Cabin " + CabinNo + ":");
            String sName = input.next().toUpperCase();
            SurNameCabin[CabinNo] = sName;
            System.out.println("Thank You. Cabin " + CabinNo + " is occupied by " + fName);
        } else {
            s = CruiseCabin[CabinNo];
            System.out.println("This Cabin is already occupied by " + s + ". PLEASE CHOOSE ANOTHER CABIN.");
        }
    }

    public static void ViewCabin(String[] CruiseCabin, String[] FirstNameCabin, String[] SurNameCabin){
        //the necessary parameters are passed to this method.
        //the method will view the details in each cabin whether its occupied or empty.
        for (int x = 0; x < 12; x++) {
            if (CruiseCabin[x].equals("e")) {
                System.out.println("---------------------------------------------");
                System.out.println("Cabin " + x + " is empty");
                System.out.println("---------------------------------------------");
            } else {
                System.out.println("---------------------------------------------");
                System.out.println("Cabin " + x + " is occupied by : " + CruiseCabin[x]);
                System.out.println("First name of the passenger : " + FirstNameCabin[x]);
                System.out.println("Surname of the passenger : " + SurNameCabin[x]);
                System.out.println("---------------------------------------------");
            }
        }
    }

    public static void EmptyDisplay(String[] CruiseCabin){
        //the necessary parameters are passed to this method.
        //the method will display the cabins that are empty.
        for (int x = 0; x < 12; x++) {
            if (CruiseCabin[x].equals("e")) {
                System.out.println("Cabin " + x + " is empty");
                System.out.println("--------------------------------------------------------------------------");
            }
        }
    }

    public static void DeletePassenger(String[] CruiseCabin, String[] FirstNameCabin, String[] SurNameCabin){
        //the necessary parameters are passed to this method.
        //the method will delete the entire cabin and its details and returns "empty" and "e" values for those arrays.
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Cabin Number that you want to delete a Passenger : ");
        int CabinNo = input.nextInt();
        if (CruiseCabin[CabinNo].equals("e")) {
            System.out.println("The Cabin Number is already empty");
        } else {
            CruiseCabin[CabinNo] = "e";
            FirstNameCabin[CabinNo] = "empty";
            SurNameCabin[CabinNo] = "empty";
            System.out.println("Deleted Passenger from Cabin " + CabinNo + " successfully");
        }
    }

    public static void FindCabin(String[] CruiseCabin){
        //the necessary parameters are passed to this method.
        //the method will find the cabin number by asking the user to enter the name of the passenger.
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Passenger name to find Cabin: ");
        String Name = input.next().toUpperCase();
        boolean isFound = false;
        for (int x = 0; x < 12; x++) {
            if (CruiseCabin[x].equals(Name)) {
                System.out.println("Cabin Found. This particular Passenger is in Cabin " + x);
                isFound = true;
            }
        }
        if (!isFound) {
            System.out.println("Passenger not found.");
        }
    }

    public static void StoreFile(String[] CruiseCabin, String[] FirstNameCabin, String[] SurNameCabin){
        //the necessary parameters are passed to this method.
        //the method will store the cabin details in the text file.
        try {
            File myObj = new File("CruiseShipCabinDetails.txt");
            String newLine = System.getProperty("line.separator");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
            FileWriter myWriter = new FileWriter("CruiseShipCabinDetails.txt");
            for (int x = 0; x < 12; x++) {
                myWriter.write("Cabin " + x + " is occupied by : " + CruiseCabin[x] + newLine);
                myWriter.write("First name of the passenger : " + FirstNameCabin[x]+ newLine);
                myWriter.write("Surname of the passenger : " + SurNameCabin[x]+ newLine);
                myWriter.write("******************************************************************************"+ newLine);
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void LoadFile(){
        //no parameters are passed to this method because this method basically view the contents in the text file.
        //the method will read the cabin details from the text file and view it.
        try {
            File myObj = new File("CruiseShipCabinDetails.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void ViewOrderedPassenger(String[] CruiseCabin){
        //the necessary parameters are passed to this method.
        //the method will view the passenger names in alphabetical order.
        int count = 0;
        for (int x = 0; x < 12; x++) {
            if (!(CruiseCabin[x].equals("e"))) {
                count += 1;
            }
        }
        int c = 0;
        String[] alphabet = new String[count];
        for (int x = 0; x < 12; x++) {
            if (!(CruiseCabin[x].equals("e"))) {
                alphabet[c] = CruiseCabin[x];
                c += 1;
            }
        }
        boolean isSwapped = true;
        while (isSwapped) {
            isSwapped = false;
            for (int i = 0; i < alphabet.length - 1; i++) {
                if (alphabet[i].compareToIgnoreCase(alphabet[i + 1]) > 0) {
                    String temp = alphabet[i + 1];
                    alphabet[i + 1] = alphabet[i];
                    alphabet[i] = temp;
                    isSwapped = true;
                }
            }

        }
        for (String value : alphabet) {
            System.out.println(value);
        }
    }
}
