package com.algonquin.cst8288.assignment1.controller;

import com.algonquin.cst8288.assignment1.emoloyee.ContractEmployeeService;
import java.io.IOException;

import com.algonquin.cst8288.assignment1.emoloyee.Employee;
import com.algonquin.cst8288.assignment1.emoloyee.PermanentEmployeeService;
import com.algonquin.cst8288.assignment1.persistence.PersistenceService;
import com.algonquin.cst8288.assignment1.validation.EmployeeValidatorService;

/**
 * 
 * Process data.
 * @author Siqian Liu 041103621
 * date: May 31, 2024
 * 
 */

public class EmployeeController {
    
        private final PersistenceService persistenceService;
        private final EmployeeValidatorService employeeValidatorService;
        private PermanentEmployeeService permanentEmployeeService;
        private ContractEmployeeService contractEmployeeService;

        public EmployeeController(PermanentEmployeeService permanentEmployeeService,
                                  EmployeeValidatorService employeeValidatorService,
                                  PersistenceService persistenceService) {
            this.permanentEmployeeService = permanentEmployeeService;
            this.employeeValidatorService = employeeValidatorService;
            this.persistenceService = persistenceService;
        }

        public EmployeeController(ContractEmployeeService contractEmployeeService,
                                  EmployeeValidatorService employeeValidatorService,
                                  PersistenceService persistenceService) {
            this.contractEmployeeService = contractEmployeeService;
            this.employeeValidatorService = employeeValidatorService;
            this.persistenceService = persistenceService;
        }
        
	public String processPermanent(Employee employee) throws IOException {

		
		// Process data
		// Calculate bonus, 
		// total compensation, 
		// pension contribution, 
		// renewal date etc.
               
               employee.setBonus(permanentEmployeeService.calculateBonus(employee));
               employee.setTotalCompensation(permanentEmployeeService.calculateTotalCompensation(employee));
               employee.setPension(permanentEmployeeService.pensionContribution(employee));
		
		
		// Validate data
		if (!employeeValidatorService.isValidEmployee(employee)) {
			return "FALIED";
		}
		
		
		// Store data
		persistenceService.saveEmployee(employee, "employee_data.txt");
		return "SUCCESS";
	}
      
        
	public String processContract(Employee employee) throws IOException {
	
                employee.setRenewalDate(contractEmployeeService.renewalDate());
		
		// Validate data
		if (!employeeValidatorService.isValidEmployee(employee)) {
			return "FALIED";
		}
		
		
		// Store data
		persistenceService.saveEmployee(employee, "employee_data.txt");
		return "SUCCESS";
	}
}