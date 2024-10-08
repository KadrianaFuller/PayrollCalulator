package com.Pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {

            FileReader fileReader = new FileReader("src/main/resources/employees.csv");

            BufferedReader bufReader = new BufferedReader(fileReader);
            String input;

            while ((input = bufReader.readLine()) != null) {
              String[] tokens = input.split("\\|");
              int id = Integer.parseInt(tokens[0]);
              String name= tokens [1];
              double hours =Double.parseDouble(tokens[2]);
              double rate = Double.parseDouble(tokens[3]);

              Employee employee = new Employee();



            }

        } catch (IOException e) {
            // display stack trace if there was an error
            e.printStackTrace();
        }
    }
}
