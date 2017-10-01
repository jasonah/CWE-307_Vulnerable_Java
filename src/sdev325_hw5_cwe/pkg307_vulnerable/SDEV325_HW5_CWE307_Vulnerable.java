/*
 * JASON HOWARTH
 * SDEV325 6380
 * 16 JULY 2017
 * HOMEWORK 5: Vulnerable to CWE-307 (Improper Restriction of Excessive Authentication Attempts)
 * File: SDEV325_HW5_CWE307_Vulnerable.java
 */
package sdev325_hw5_cwe.pkg307_vulnerable;

import java.util.Scanner;

public class SDEV325_HW5_CWE307_Vulnerable {

    public static void main(String[] args) {

        //VARIABLES
        String accountUserName = "MyUsername";
        String accountPassword = "MyPassword";
        String inputUserName = "";
        String inputPassword = "";
        boolean endProgram = false;
        int attemptCount = 1;

        // USE SCANNER CLASS TO INPUT USERNAME AND PASSWORD
        Scanner input = new Scanner(System.in);

        // DO WHILE LOOP TO REQUEST USERNAME AND PASSWORD
        do {
            // REQUEST USERNAME
            System.out.print("Enter username: ");
            // SCAN USER INPUT
            inputUserName = input.next();
            // REMOVE WHITESPACE FROM INPUT
            inputUserName = inputUserName.trim();

            // REQUEST PASSWORD
            System.out.print("Enter password: ");
            // SCAN USER INPUT
            inputPassword = input.next();
            // REMOVE WHITESPACE FROM INPUT
            inputPassword = inputPassword.trim();
            
            // CWE-307 Vulnerability: does not limit authentication attempts
            // COMPARES INPUT USER NAME/PASSWORD AGAINST ACCOUNT USERNAME/PASSWORD
            if (inputUserName.equals(accountUserName)) {
                if (inputPassword.equals(accountPassword)) {
                    System.out.println("Access Granted in " + attemptCount + " attempts!");
                    endProgram = true;
                } else {
                    System.out.println("Access Denied!");//BAD PASSWORD
                    attemptCount++;
                }
            } else {
                System.out.println("Access Denied!");//BAD USERNAME
                attemptCount++;
            }
        } while (endProgram != true);
        
    }// END MAIN
}