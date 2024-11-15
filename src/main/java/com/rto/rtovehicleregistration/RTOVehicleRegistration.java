package com.rto.rtovehicleregistration;

import java.sql.SQLException;
import java.util.*;

public class RTOVehicleRegistration {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        int choice;
        String name, address, signature;
        String vehicleRegno, vehicleDetails;
        String emailId, password;
        int age;
        int knowsDriving;
        String ans = "y";
        Scanner sc = new Scanner(System.in);
        int option;
        String[] loginResult;
        String[] VehicleRegDetails;
        int result;
        double fundamnt,amount;
        boolean result1;
        do {
            System.out.println("\t\t\t\t\t*********** Welcome to RTO Vehicle Registration Management System *********** ");
            System.out.print("1)Login/SignUp\n2)Vehicle Registration\n3)Vehicle Licensing(Examination included for issuing license)\n4)Check Vehicle Permit\n5)Finance\n6)Exit\nEnter your choice[1-6] : ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Do you want to 1)login or 2)SignUp : ");
                    option = sc.nextInt();
                    sc.nextLine();
                    if (option == 1) {
                        System.out.print("Enter your name : ");
                        name = sc.nextLine();
                        System.out.print("Enter your emailid : ");
                        emailId = sc.next();
                        System.out.print("Enter your password : ");
                        password = sc.next();
                        LoginSignUp l1 = new LoginSignUp(name, emailId, password);
                        loginResult = l1.login();
                        if (loginResult[0].equals("1")) {
                            System.out.println("Login Success!, Welcome " + loginResult[1]);
                        }
                    } else if (option == 2) {
                        System.out.print("Enter your name : ");
                        name = sc.nextLine();
                        System.out.print("Enter your emailid : ");
                        emailId = sc.next();
                        System.out.print("Enter your password : ");
                        password = sc.next();
                        LoginSignUp l1 = new LoginSignUp(name, emailId, password);
                        loginResult = l1.signUp();
                        if (loginResult[0].equals("1")) {
                            System.out.println("User " + loginResult[1] + " Registered Successfully!");
                        }
                    } else {
                        System.out.println("Invalid option!");
                    }

                    break;
                case 2:
                    System.out.print("Do you want to 1)Register Vehicle or 2)GetDetails and Verify : ");
                    option = sc.nextInt();
                    sc.nextLine();
                    if (option == 1) {
                        System.out.print("Enter owner name : ");
                        name = sc.nextLine();
                        System.out.print("Enter vehicle registration number : ");
                        vehicleRegno = sc.nextLine();
                        System.out.print("Enter Vehicle Details(Brand, Year, Model, Price) : ");
                        vehicleDetails = sc.nextLine();
                        VehicleRegistration vr1 = new VehicleRegistration(name, vehicleRegno, vehicleDetails);
                        result = vr1.registerVehicle();
                        if (result == 1) {
                            System.out.println(vehicleRegno + " Registered successfully!");
                        }
                    } else if (option == 2) {
                        System.out.print("Enter vehicle registration number : ");
                        vehicleRegno = sc.nextLine();
                        VehicleRegistration vr2 = new VehicleRegistration("", "", "");
                        VehicleRegDetails = vr2.getDetailsNVerify(vehicleRegno);
                        if (VehicleRegDetails[0].equals("1")) {
                            System.out.println("Owner : " + VehicleRegDetails[1]);
                            System.out.println("Vehicle Registration number : " + VehicleRegDetails[2]);
                            System.out.println("Vehicle Details(Brand, Year, Model, Price) : " + VehicleRegDetails[3]);
                        } else {
                            System.out.println("No Vehicle details was found for " + vehicleRegno);
                        }
                    } else {
                        System.out.println("Invalid option!");
                    }
                    break;
                case 3:
                    sc.nextLine();
                    System.out.print("Enter your name : ");
                    name = sc.nextLine();
                    System.out.print("Enter your age : ");
                    age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter vehicle registration number : ");
                    vehicleRegno = sc.nextLine();
                    System.out.print("Enter your address : ");
                    address = sc.nextLine();
                    System.out.print("Enter your signature : ");
                    signature = sc.nextLine();
                    System.out.print("Enter CBT Score : ");
                    int cbtscore = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Do you know driving (1/0) : ");
                    knowsDriving = sc.nextInt();
                    VehicleLicensing vls1 = new VehicleLicensing(age, name, address, vehicleRegno);
                    vls1.provideLicense(signature, cbtscore, knowsDriving);
                    break;

                case 4:
                    System.out.print("Enter your option 1)check vehicle permit status or 2)Permit Vehicle : ");
                    option = sc.nextInt();
                    sc.nextLine();
                    if (option == 1) {
                        System.out.print("Enter vehicle registration number : ");
                        vehicleRegno = sc.nextLine();
                        VehiclePermit vp1 = new VehiclePermit();
                        result1 = vp1.isPermitted(vehicleRegno);
                        if (result1) {
                            System.out.println(vehicleRegno + " is Permitted");
                        } else {
                            System.out.println(vehicleRegno + " is not Permitted");
                        }
                    } else if (option == 2) {
                        System.out.print("Enter vehicle registration number : ");
                        vehicleRegno = sc.nextLine();
                        VehiclePermit vp2 = new VehiclePermit();
                        System.out.println("Enter '1' to permit or '0' to not permit " + vehicleRegno);
                        option = sc.nextInt();
                        vp2.permitVehicle(vehicleRegno, option);
                    } else {
                        System.out.println("Invalid option!");
                    }
                    break;
                case 5:
                    Finance f1 = new Finance();
                    System.out.print("Enter '1' to pool funds, '2' for Economic Development, '3' for Decision Making : ");
                    option = sc.nextInt();
                    sc.nextLine();
                    if (option == 1) {
                        System.out.print("Enter fund amount : ");
                        fundamnt = sc.nextDouble();
                        f1.poolFunds(fundamnt);
                    }
                    else if(option ==2){
                        System.out.print("Enter amount to be used for Economic Development : ");
                        amount=sc.nextDouble();
                        f1.economicDevelopment(amount);
                    }
                    else if(option==3){
                        f1.decisionMaking();
                    }
                    else{
                        System.out.println("Invalid option!");
                    }
                    break;
                case 6:
                    break;
                default:
                    break;
            }
            System.out.print("Do you want to continue (y/n) :");
            ans = sc.next();
        } while (ans.equalsIgnoreCase("y"));
        System.out.println("Thank you for using our software!");
    }
}
