package com.example.cruise_shiptask2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CruiseShipExample {
    public static Cabin [] cabin = new Cabin[12];
    //this array will create an object of array for those passenger details.
    public static Passenger [] guestNo = new Passenger[12];
    //this array will store the number of guests in a cabin.
    public static Passenger [][] firstname = new Passenger[12][3];
    //this array will store the passenger firstname in a cabin (maximum 3)
    public static Passenger [][] surname = new Passenger[12][3];
    //this array will store the passenger surname in a cabin (maximum 3)
    public static Passenger [] expenses = new Passenger[12];
    //this array will store the expenses in that particular cabin
    public static Scanner input = new Scanner(System.in);
    //this scanner class is used over here so that any method can use this.
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
        System.out.println("Enter 'T' View the Expenses");
    }

    public static void initialise() {
        //the method will initialise the arrays.
        //2D array will also become initialised
        for (int x = 0; x < 12; x++) {
            cabin[x] = new Cabin("e", new Passenger[][]{new Passenger[]{new Passenger(0, "empty", "empty", 0)}});
        }
        for (int i = 0; i < 12; i++) {
            guestNo[i] = new Passenger(0, "empty", "empty", 0);
            expenses[i] = new Passenger(0, "empty", "empty", 0);
            for (int o = 0; o < 3; o++) {
                firstname[i][o] = new Passenger(0, "empty", "empty", 0);
                surname[i][o] = new Passenger(0, "empty", "empty", 0);
            }
        }
    }

    public static void AddPassenger(){
        //the method will add the passengers to each cabin.
        String s;
        System.out.println("Enter Cabin number (0-11) or 12 to stop:");
        int CabinNo = input.nextInt();
        if ((CabinNo == 12) || (CabinNo > 12)) {
            System.out.println("Thank You. You are going back to menu");
            System.out.println("**************************************************************************************");
            System.out.println("**************************************************************************************");
            return;
        } else if (cabin[CabinNo].CruiseCabin.equals("e")) {
            System.out.println("Enter no of Passengers in the room "+ CabinNo + " 'up to 3 passengers only' :");
            try {
               int no = Integer.parseInt(input.next());
               if (no > 0 && no <= 3) {
                   System.out.println("Enter the Name for the Cabin " + CabinNo + " :");
                   String CabinName = input.next().toUpperCase();
                   guestNo[CabinNo].P_GuestCount = no;
                   String fName = null;
                   String sName = null;
                   for (int i = 0; i < no; i++) {
                       System.out.println("Enter firstname of the Passenger " + (i + 1) + " :");
                       fName = input.next().toUpperCase();
                       firstname[CabinNo][i].FirstNameCabin = fName;
                       System.out.println("Enter surname of the Passenger " + (i + 1) + " :");
                       sName = input.next().toUpperCase();
                       surname[CabinNo][i].SurNameCabin = sName;
                   }
                   double amount = 250 * no;
                   expenses[CabinNo].TotalExpenses = (int) amount;
                   System.out.println("Thank You. Cabin " + CabinNo + " is occupied by " + CabinName);
                   cabin[CabinNo] = new Cabin(CabinName, new Passenger[][]{new Passenger[]{new Passenger(no, fName, sName, amount)}});
               } else {
                   System.out.println("out of range");
                   return;
               }
            } catch (Exception e) {
                System.out.println("Something went wrong.");
            }
        } else {
            s = cabin[CabinNo].CruiseCabin;
            System.out.println("This Cabin is already occupied by " + s + ". PLEASE CHOOSE ANOTHER CABIN.");
        }
    }

    public static void ViewCabin() {
        //the method will view the details in each cabin whether its occupied or empty.
        for (int x = 0; x < 12; x++) {
            if (cabin[x].CruiseCabin.equals("e")) {
                System.out.println("---------------------------------------------");
                System.out.println("Cabin " + x + " is empty");
                System.out.println("---------------------------------------------");
            } else {
                System.out.println("---------------------------------------------");
                System.out.println("Cabin " + x + " is occupied by : " + cabin[x].CruiseCabin);
                System.out.println("No of Passengers in Cabin " + x + " : " + guestNo[x].P_GuestCount);
                for (int i = 0; i < guestNo[x].P_GuestCount; i++) {
                    System.out.println("Full name of the Passenger " + (i + 1) + " : " + firstname[x][i].FirstNameCabin + " " + surname[x][i].SurNameCabin);
                }
                System.out.println("---------------------------------------------");
            }
        }
    }

    public static void EmptyDisplay(){
        //the method will display the cabins that are empty.
        for (int x = 0; x < 12; x++) {
            if (cabin[x].CruiseCabin.equals("e")){
                System.out.println("Cabin " + x + " is empty");
                System.out.println("--------------------------------------------------------------------------");
            }
        }
    }

    public static void DeletePassenger(){
        //the method will delete the entire cabin and its details and returns "empty" and "e" values for those arrays.
        System.out.println("Enter the Cabin Number that you want to delete a Passenger : ");
        int CabinNo = input.nextInt();
        if (cabin[CabinNo].CruiseCabin.equals("e")) {
            System.out.println("The Cabin Number is already empty");
        } else {
            cabin[CabinNo] = new Cabin("e", new Passenger[][]{new Passenger[]{new Passenger(0, "empty", "empty", 0)}});
            guestNo[CabinNo] = new Passenger(0, "empty", "empty", 0);
            expenses[CabinNo] = new Passenger(0, "empty", "empty", 0);
            for (int o = 0; o < 3; o++) {
                firstname[CabinNo][o] = new Passenger(0, "empty", "empty", 0);
                surname[CabinNo][o] = new Passenger(0, "empty", "empty", 0);
            }
            System.out.println("Deleted Passenger from Cabin " + CabinNo + " successfully");
        }
    }

    public static void FindCabin(){
        //the method will find the cabin number by asking the user to enter the name of the passenger.
        //the method will find the cabin number by entering surname or firstname or the cabin name of the passengers/passenger
        System.out.println("Enter the Passenger name to find Cabin: ");
        String Name = input.next().toUpperCase();
        boolean isFound = false;
        for (int x = 0; x < 12; x++) {
            if (cabin[x].CruiseCabin.equals(Name)) {
                System.out.println("Cabin Found. This particular Passenger is in Cabin " + x);
                isFound = true;
            }else if (firstname[x][0].FirstNameCabin.equals(Name)) {
                System.out.println("Cabin Found. This particular Passenger is in Cabin " + x);
                isFound = true;
            }else if (firstname[x][1].FirstNameCabin.equals(Name)) {
                System.out.println("Cabin Found. This particular Passenger is in Cabin " + x);
                isFound = true;
            }else if (firstname[x][2].FirstNameCabin.equals(Name)) {
                System.out.println("Cabin Found. This particular Passenger is in Cabin " + x);
                isFound = true;
            }else if (surname[x][0].SurNameCabin.equals(Name)) {
                System.out.println("Cabin Found. This particular Passenger is in Cabin " + x);
                isFound = true;
            }else if (surname[x][1].SurNameCabin.equals(Name)) {
                System.out.println("Cabin Found. This particular Passenger is in Cabin " + x);
                isFound = true;
            }else if (surname[x][2].SurNameCabin.equals(Name)) {
                System.out.println("Cabin Found. This particular Passenger is in Cabin " + x);
                isFound = true;
            }
        }
        if (!isFound) {
            System.out.println("Passenger not found.");
        }
    }

    public static void StoreFile(){
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
                myWriter.write("Cabin " + x + " is occupied by : " + cabin[x].CruiseCabin + newLine);
                myWriter.write("No of Passengers in Cabin " + x + " : " + guestNo[x].P_GuestCount + newLine);
                for (int i = 0; i < guestNo[x].P_GuestCount; i++) {
                    String s = firstname[x][i].FirstNameCabin + " " + surname[x][i].SurNameCabin + newLine;
                    myWriter.write("Full name of the passenger "+ (i+1) + " : " + s);
                }
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
        //the method will read the cabin details from the text file and view it.
        try {
            int count=0;
            File myObj = new File("CruiseShipCabinDetails.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            System.out.println("Loaded successfully");
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void ViewOrderedPassenger(){
        //the method will view the passenger's firstnames in alphabetical order.
        int count = 0;
        for (int x = 0; x < 12; x++) {
            for (int i = 0; i < 3; i++) {
                if (!(firstname[x][i].FirstNameCabin.equals("empty"))) {
                    count += 1;
                }
            }
        }
        int c = 0;
        String[] alphabet = new String[count];
        for (int x = 0; x < 12; x++) {
            for (int i = 0; i < 3; i++) {
                if (!(firstname[x][i].FirstNameCabin.equals("empty"))) {
                    alphabet[c] = firstname[x][i].FirstNameCabin;
                    c += 1;
                }
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

    public static void TotalExpensesPassengers() {
        //the method will display the cost per passenger.
        //the method will display the total cost per each cabin.
        //the method will display the total cost for entire cabins.
        double tot = 0;
        System.out.println("The cost per Passenger is $250");
        for (int x = 0; x < 12; x++) {
            System.out.println("The Total Expenses for Cabin " + x + " : " +  "$" + " " + expenses[x].TotalExpenses);
        }
        for (int i = 0; i < 12; i++) {
            tot = tot + expenses[i].TotalExpenses;
        }
        System.out.println("The Total Expanses of all the Passengers in Ship is : " + "$" + " " + tot);
    }

    public static void main(String[] args) {
        //this main class runs inorder to get the option that was chosen by the user.
        Scanner input = new Scanner(System.in);
        String choice;
        String choice2 = "Y";
        initialise(); //better to initialise in a procedure
        while (choice2.equals("Y")) {
            Menu();//menu method is called over here
            System.out.println("Enter your choice: ");
            choice = input.next().toUpperCase();
            switch (choice) {
                case "V":
                    ViewCabin();
                    break;
                case "A":
                    AddPassenger();
                    break;
                case "E":
                    EmptyDisplay();
                    break;
                case "D":
                    DeletePassenger();
                    break;
                case "F":
                    FindCabin();
                    break;
                case "S":
                    StoreFile();
                    break;
                case "L":
                    LoadFile();
                    break;
                case "O":
                    ViewOrderedPassenger();
                    break;
                case "T":
                    TotalExpensesPassengers();
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
}