package com.vladimirsimek.messenger;


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
}
