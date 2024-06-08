package com.algonquin.cst8288.assignment1.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.algonquin.cst8288.assignment1.emoloyee.Employee;

/**
 * 
 * Validates the Employee object.
 * @author Siqian Liu 041103621
 * date: May 31, 2024
 * 
 */
public class PermanentValidator implements EmployeeValidatorService {
    
    @Override
    public boolean isValidEmployee(Employee employee) {
        boolean validator=true;
        
        if (!isPresent(employee.getName())) {
            validator=false;
            return validator;
        }
        employee.setName(employee.getName().trim());

        if (!isValidAlphaNumeric(employee.getName())) {
            validator=false;
            return validator;
        }
        if (employee.getEmail() == null || employee.getEmail().trim().length() == 0) {
            validator=false;
            return validator;
        }
        employee.setEmail(employee.getEmail().trim());
        if (!isValidEmail(employee.getEmail())) {
            validator=false;
            return validator;
        }

        if (!isValidSalary(employee.getSalary())) {
            validator=false;
            return validator;
        }
        
        if (!isValidCompensation(employee.getTotalCompensation())) {
            validator=false;
            return validator;
          }
        
        if (!isValidServiceYear(employee.getNumberOfServiceYear())) {
            validator=false;
            return validator;
            }
        
        
        return validator;
        
    }

    private boolean isPresent(String value) {
        return value != null && value.trim().length() > 0;
    }

    private boolean isValidAlphaNumeric(String value) {
        Pattern pattern = Pattern.compile("[^A-Za-z0-9]");
        Matcher matcher = pattern.matcher(value);
        return !matcher.find();
    }

    private boolean isValidEmail(String value) {
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(value);
        return matcher.find();
    }

    private boolean isValidSalary(double salary) {
        return salary > 0;
    }

    private boolean isValidCompensation(double compensation) {
        return compensation > 0;
    }

    private boolean isValidServiceYear(int serviceYear) {
        return serviceYear > 0;
    }
}
