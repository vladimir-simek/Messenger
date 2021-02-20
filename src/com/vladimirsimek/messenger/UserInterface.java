package com.vladimirsimek.messenger;


public class UserInterface {

    public static final String row = "--------------------------";

    public static void greet(String name) {
        System.out.println("Welcome to the messenger " + name + "!");
        System.out.println("Your data is our priority, that's why we collect everything.");
        System.out.println(row);
    }
}
