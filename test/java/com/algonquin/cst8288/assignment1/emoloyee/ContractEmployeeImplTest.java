/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.algonquin.cst8288.assignment1.emoloyee;

import java.time.LocalDate;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sue Lius
 */
public class ContractEmployeeImplTest {
    
    public ContractEmployeeImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of renewalDate method, of class ContractEmployeeImpl.
     */

    @Test
   public void renewalDate() {
        ContractEmployeeService service=new ContractEmployeeImpl();
        LocalDate localDate=LocalDate.now().plusYears(1);
        assertEquals(localDate,service.renewalDate());
    }
}
