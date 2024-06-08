package com.algonquin.cst8288.assignment1.persistence;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.algonquin.cst8288.assignment1.emoloyee.Employee;

/**
 * 
 * Saves employee data.
 * @author Siqian Liu 041103621
 * date: May 31, 2024
 * 
 */
public class PersistenceImpl implements PersistenceService {

    @Override
    public void saveEmployee(Employee employee, String filename) throws IOException {
        Formatter formatter = new JSONFormatter();
        String jsonfilename = "json_" + filename;
        try (PrintWriter writer = new PrintWriter(new FileWriter(jsonfilename, true))) {
            writer.println(formatter.format(employee)); //print out to file
            writer.flush();
            System.out.println(formatter.format(employee)); //print out to console
        }
        
        Formatter textfile = new TextFormatter();
        String textfilename = "txt_" + filename;
        try (PrintWriter writer = new PrintWriter(new FileWriter(textfilename, true))) {
            writer.println(textfile.format(employee));  //print out to file
            writer.flush();
            System.out.println(textfile.format(employee)); //print out to console
        }
        
    }
}
