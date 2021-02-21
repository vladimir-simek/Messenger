package com.vladimirsimek.messenger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Data {
    public static String name = "null";
    public static String password = "null";
    public static String rawInput = "null";
    public static String commandEND = "!konec";
    public static ArrayList inbox = new ArrayList<String>();

    public static void toInbox(String rawInput) {
        String parsedInput = name + ": " + rawInput;
        inbox.add(parsedInput);
    }

    public static void pushInbox() {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("data/inbox/inbox.txt", true));
                for (int i = 0; i < inbox.size(); i++) {
                    bufferedWriter.write(String.valueOf(inbox.get(i)));
                    bufferedWriter.newLine();
                }
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

    }

    public static void prepareFiles() {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("data/existing-users.txt", true));
            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter("data/sensitive-user-data.txt", true));
            BufferedWriter bufferedWriter3 = new BufferedWriter(new FileWriter("data/inbox/inbox.txt", true));
            bufferedWriter.close();
            bufferedWriter2.close();
            bufferedWriter3.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
