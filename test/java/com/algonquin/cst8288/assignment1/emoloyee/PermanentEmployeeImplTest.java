/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.algonquin.cst8288.assignment1.emoloyee;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

/**
 *
 * @author Sue Lius
 */
public class PermanentEmployeeImplTest {
    
    private static final double EPSILON = 1E-12;
    private PermanentEmployeeImpl employeeService;
    private Employee employee;
    @Before
    public void setUp() {
        employeeService = new PermanentEmployeeImpl();
        employee = new Employee("John Doe", "john@example.com", "1234 Street", 50000);
        employee.setNumberOfServiceYear(5);
    }
    @Test
    public void pensionContribution() {
        double expectedPension = employee.getSalary() * 0.01;
        Assert.assertEquals(expectedPension, employeeService.pensionContribution(employee), EPSILON);
    }

    @Test
    public void calculateBonus() {
        double expectedBonus= employee.getSalary() * 0.025*employee.getNumberOfServiceYear();
        Assert.assertEquals(expectedBonus, employeeService.calculateBonus(employee), EPSILON);
    }

    @Test
    public void calculateTotalCompensation() {
        double expectedCompensation= employee.getSalary() +employee.getBonus();
        Assert.assertEquals(expectedCompensation, employeeService.calculateTotalCompensation(employee), EPSILON);
    }
    
}
