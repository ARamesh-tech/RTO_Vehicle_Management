package com.rto.rtovehicleregistration;

import java.sql.SQLException;
import java.util.*;

public class RTOVehicleRegistration {

    public static void main(String[] args) throws SQLException {
        int choice;
        String name, address, signature;
        String vehicleRegno, vehicleDetails;
        String emailId, password;
        int vehiclePermit;
        float balance;
        int age;
        int examScore;
        int knowsDriving;
        String ans = "y";
        Scanner sc = new Scanner(System.in);
        int option;
        String[] loginResult;

        do {
            System.out.println("\t\t\t\t\t*********** Welcome to RTO Vehicle Registration Management System *********** ");
            System.out.print("1)Login/SignUp\n2)Vehicle Registration\n3)Vehicle Licensing(Examination included for issuing license)4)Check Vehicle Permit Status\n5)Finance\n6)Exit\nEnter your choice[1-6] : ");
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
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
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
