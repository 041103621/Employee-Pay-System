/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.algonquin.cst8288.assignment1.emoloyee;

import com.algonquin.cst8288.assignment1.persistence.PersistenceImpl;
import com.algonquin.cst8288.assignment1.persistence.PersistenceService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;

/**
 *
 * @author Sue Lius
 */
public class PersistenceImplTest {

    private Employee employee;
    @Before
    public void setUp(){
        employee = new Employee("John Doe", "john@example.com", "1234 Street", 50000);
        employee.setRenewalDate(LocalDate.now().plusYears(1));
    }
    @Test
  public  void saveEmployee() throws IOException {
        PersistenceService service= new PersistenceImpl();
        service.saveEmployee(employee,"test.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader("json_test.txt"))) {
            String line = reader.readLine();
            String expectedLine="{\"name\":\"John Doe\",\"email\":\"john@example.com\",\"address\":\"1234 Street\",\"salary\":50000.0,\"numberOfServiceYear\":0,\"bonus\":0.0,\"totalCompensation\":0.0,\"pension\":0.0,\"renewalDate\":\"2025-05-29\"}";
            assertEquals(expectedLine, line);
        }
    }
}
