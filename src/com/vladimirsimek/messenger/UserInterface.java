package com.vladimirsimek.messenger;


import java.util.Scanner;

import static com.vladimirsimek.messenger.Data.commandNO;
import static com.vladimirsimek.messenger.Data.commandYES;
import static com.vladimirsimek.messenger.Logic.resetPassword;

public class UserInterface {

    public static final String row = "--------------------------";

    public static void greet(String name) {
        System.out.println(row);
        System.out.println("Welcome to the messenger " + name + "!");
        System.out.println("Your data is our priority, that's why we collect everything.");
        System.out.println(row);
    }

    public static void dismissUser() {
        System.out.println(row);
        System.out.println("Thank you for using our messenger!");
        System.out.println("We are glad that we could steal your data!");
        System.out.println("Goodbye.");
        System.out.println(row);
    }

    public static void wrongCredentials() {
        Scanner sc = new Scanner(System.in);
        System.out.println(row);
        System.out.println("You tried so many times!");
        System.out.println("Do you wish to reset your password?");
        String rawInput = sc.nextLine();
        while (!rawInput.equals(commandYES) || !rawInput.equals(commandNO)) {
            rawInput = sc.nextLine();
        }
        if (rawInput.equals(commandNO)){
            dismissUser();
        }else {
            resetPassword();
        }
    }
}
