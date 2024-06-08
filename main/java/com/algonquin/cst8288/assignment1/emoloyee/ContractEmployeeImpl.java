/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquin.cst8288.assignment1.emoloyee;

import java.time.LocalDate;



/**
 *
 * @author Siqian Liu 041103621
 * date: May 31, 2024
 */
public class ContractEmployeeImpl implements ContractEmployeeService{
    
    
    @Override
    public LocalDate renewalDate() {
        return LocalDate.now().plusYears(1);
    }


}
