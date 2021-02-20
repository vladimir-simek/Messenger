package com.vladimirsimek.messenger;

import static com.vladimirsimek.messenger.Data.*;

import java.util.Scanner;

public class Logic {

    public static void getLogin() {
        System.out.println("Enter your username:");
        Scanner sc = new Scanner(System.in);
        name = sc.nextLine();
        System.out.println("Enter your password:");
        password = sc.nextLine();
    }
}
