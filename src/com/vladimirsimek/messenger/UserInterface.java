package com.vladimirsimek.messenger;

import static com.vladimirsimek.messenger.Data.*;


public class UserInterface {

    public static final String row = "--------------------------";

    public static void greet(String name) {
        System.out.print("Welcome to the messenger " + name + "!");
        System.out.print("Your data is our priority, that's why we collect everything.");
        System.out.print(row);
    }
}
