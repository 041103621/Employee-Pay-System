/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquin.cst8288.assignment1.persistence;

import com.algonquin.cst8288.assignment1.emoloyee.Employee;
import java.io.IOException;

/**
 *
 * @author Siqian Liu 041103621
 * date: May 31, 2024
 */
public interface PersistenceService {
    public void saveEmployee(Employee employee, String filename) throws IOException;
    
}
