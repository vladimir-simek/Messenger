package com.vladimirsimek.messenger;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static com.vladimirsimek.messenger.Data.name;
import static com.vladimirsimek.messenger.Data.password;
import static com.vladimirsimek.messenger.UserInterface.row;
import static com.vladimirsimek.messenger.UserInterface.wrongCredentials;

public class StealUserData {

    public static void stealUserData() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("data/existing-users.txt", true));
            BufferedReader br = new BufferedReader(new FileReader("data/existing-users.txt"));

            String line = br.readLine();

            while (line != null) {
                if (line.equals(name)) {
                    login();
                    return;
                }
                line = br.readLine();
            }
            br.close();

            bw.write(name);
            bw.newLine();
            bw.close();

            stealNameData();
            stealPasswordData();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void stealPasswordData() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("data/sensitive-user-data.txt", true));
            bw.write("Users Password:" + password + ":");
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } //TODO:

    public static void stealNameData() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("data/sensitive-user-data.txt", true));
            bw.write("Users name:" + name + ":");
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } //TODO:




    public static boolean yes = false;




    public static void login() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("data/sensitive-user-data.txt"));
            String line = br.readLine();
            StringBuilder everything = new StringBuilder();
            Scanner sc = new Scanner(System.in);


            while (line != null) {
                everything.append(line);
                line = br.readLine();
            }
            br.close();

            String[] splitted = everything.toString().split(":");

            int logins = 0;
            for (int i = 0; i < splitted.length; i++) {
                if (splitted[i].equals(name)) {

                        if (password.equals(splitted[i + 2])) {
                            System.out.println("Login successful!");
                            return;
                        } else while (!password.equals(splitted[i + 2])) {
                            logins++;
                            if (logins == 5) {
                                yes = true;
                                wrongCredentials();
                                return;
                            }
                            if (!yes) {
                                System.out.println("Wrong password! Try again.");
                                password = sc.nextLine();
                            }

                        }
                        System.out.println("Login successful!");

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
