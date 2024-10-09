package com.Pluralsight;


import com.Pluralsight.Employee;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Please enter the name of the employee file to process: ");
        String fileName = in.nextLine();

        System.out.print("Please enter the name of the payroll file to create: ");
        String payrollFile= in.nextLine();

        try {

            FileReader fileReader = new FileReader("src/main/resources/" + fileName);
            BufferedReader bufReader = new BufferedReader(fileReader);

            FileWriter fileWriter= new FileWriter("src/main/resources/" + payrollFile);
            BufferedWriter bufWrite = new BufferedWriter(fileWriter);

            String input;

            while ((input = bufReader.readLine()) != null) {
                String[] tokens = input.split("\\|");
                int id = Integer.parseInt(tokens[0]);
                String name= tokens [1];
                double hours =Double.parseDouble(tokens[2]);
                double rate = Double.parseDouble(tokens[3]);

                Employee employee = new Employee(id,name,hours,rate);


//                System.out.printf("""
//                Employee Info:
//                Id: %s
//                Name: %s
//                Gross Pay: %.2f
//             """,employee.getEmployeeID(),employee.getName(), employee.getGrossPay());
//
             bufWrite.write(String.format("%d |%s |%.2f \n", employee.getEmployeeID(), employee.getName(), employee.getGrossPay()));

            }
            bufWrite.close();

            bufReader.close();


        } catch (IOException e) {
            // display stack trace if there was an error
            e.printStackTrace();
        }
    }
}
