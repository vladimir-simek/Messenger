package com.vladimirsimek.messenger;

import static com.vladimirsimek.messenger.Data.*;
import static com.vladimirsimek.messenger.StealUserData.stealPasswordData;
import static com.vladimirsimek.messenger.StealUserData.stealUserData;
import static com.vladimirsimek.messenger.UserInterface.dismissUser;
import static com.vladimirsimek.messenger.UserInterface.row;

import java.io.*;
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
        dismissUser();
        System.out.println("Restart app to complete password reset!");
        resetPasswordFinal();
        System.exit(0);

    }

    public static void resetPasswordFinal() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("data/sensitive-user-data.txt"));
            String line = br.readLine();
            StringBuilder everything = new StringBuilder();

            while (line != null) {
                everything.append(line);
                line = br.readLine();
            }

            br.close();
            String[] splitted = everything.toString().split(":");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("data/sensitive-user-data.txt"));


            for (int i = 0; i < splitted.length; i++) {
                if (splitted[i].equals(name)){
                    splitted[i+2] = password;
                }
            }

            for (int i = 0; i < splitted.length; i++) {
                if (i % 2 == 0){
                    bufferedWriter.newLine();
                }
                bufferedWriter.write(splitted[i]+":");
            }
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
