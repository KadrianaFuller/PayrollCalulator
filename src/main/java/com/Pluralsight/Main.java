package com.Pluralsight;


import com.Pluralsight.Employee;

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

                Employee employee = new Employee(id,name,hours,rate);


                System.out.printf("""
                Employee Info:
                Id: %s
                Name: %s
                Gross Pay: %.2f
             """,employee.getEmployeeID(),employee.getName(), employee.getGrossPay());
            }
            bufReader.close();
            fileReader.close();

        } catch (IOException e) {
            // display stack trace if there was an error
            e.printStackTrace();
        }
    }
}
