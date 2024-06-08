/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquin.cst8288.assignment1.emoloyee;

import com.algonquin.cst8288.assignment1.controller.Rate;

/**
 *
 * @author Siqian Liu 041103621
 * date: May 31, 2024
 */
public class PermanentEmployeeImpl implements PermanentEmployeeService{
    

       @Override
        public double pensionContribution(Employee emoloyee) {
            double pension = emoloyee.getSalary()*Rate.PENSION_PERCENTAGE;
            return pension;
            
  }
       @Override
        public double calculateBonus(Employee emoloyee) {
           double bonus = (emoloyee.getSalary()* Rate.BONUS_PERCENTAGE)*emoloyee.getNumberOfServiceYear();
            return bonus;
            
  }
        @Override
        public double calculateTotalCompensation(Employee emoloyee) {
           double totalCompensation = emoloyee.getSalary() + emoloyee.getBonus();
            return totalCompensation;
        }

        




    
}
