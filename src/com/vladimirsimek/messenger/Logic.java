package com.vladimirsimek.messenger;

import static com.vladimirsimek.messenger.Data.*;
import static com.vladimirsimek.messenger.StealUserData.stealPasswordData;
import static com.vladimirsimek.messenger.StealUserData.stealUserData;
import static com.vladimirsimek.messenger.UserInterface.dismissUser;
import static com.vladimirsimek.messenger.UserInterface.row;

import java.util.Scanner;

public class Logic {

    public static void getLogin() {
        System.out.println("Enter your username:");
        Scanner sc = new Scanner(System.in);
        name = sc.nextLine();
        System.out.println("Enter your password:");
        password = sc.nextLine();
    }

    public static void userinput() {
        Scanner sc = new Scanner(System.in);
        rawInput = sc.nextLine();
        while (!rawInput.equals(commandEND)){
            toInbox(rawInput);
            rawInput = sc.nextLine();
        }
        pushInbox();
        dismissUser();
        System.exit(0);
    }

    public static void resetPassword() {
        Scanner sc = new Scanner(System.in);
        System.out.println(row);
        System.out.println("Write down your new password:");
        password = sc.nextLine();
        stealUserData();
    }


}
