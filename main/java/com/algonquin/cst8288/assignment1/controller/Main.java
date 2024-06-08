package com.algonquin.cst8288.assignment1.controller;


import com.algonquin.cst8288.assignment1.emoloyee.ContractEmployeeImpl;
import com.algonquin.cst8288.assignment1.emoloyee.ContractEmployeeService;
import com.algonquin.cst8288.assignment1.emoloyee.Employee;
import com.algonquin.cst8288.assignment1.emoloyee.PermanentEmployeeImpl;
import com.algonquin.cst8288.assignment1.emoloyee.PermanentEmployeeService;
import com.algonquin.cst8288.assignment1.persistence.PersistenceImpl;
import com.algonquin.cst8288.assignment1.persistence.PersistenceService;
import com.algonquin.cst8288.assignment1.validation.ContractValidator;
import com.algonquin.cst8288.assignment1.validation.PermanentValidator;
import com.algonquin.cst8288.assignment1.validation.EmployeeValidatorService;
import java.io.IOException;

/**
 * 
 * Main class to execute the application
 * @author Siqian Liu 041103621
 * date: May 31, 2024
 */

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		

		// Instantiate two Employee objects and use PermanentEmployeeService.java 
		// and ContractEmployeeService.java to calculate and populate required data for objects
		// Utilize EmployeeController.java to save both objects in JSON and Text formats, 
		// saving the data in files named json_employee_data.txt and text_employee_data.txt.
		// Do the same thing to output the data to the console instead of saving it to a file.
                
                Employee permanent = new Employee("AnnPermanent","ann@123.com","prince of wales street",3000,3);
                Employee contract = new Employee("BobContract","bob@123.com","Medowland street", 2000);
                
                PermanentEmployeeService permanentservice = new PermanentEmployeeImpl();
                ContractEmployeeService contractservice = new ContractEmployeeImpl();
                PersistenceService printout = new PersistenceImpl();
                EmployeeValidatorService permanentvalidator = new PermanentValidator();
                EmployeeValidatorService contractvalidator = new ContractValidator();
                
                EmployeeController permanentcontroler = new EmployeeController(permanentservice, permanentvalidator, printout);
                EmployeeController contractcontroler = new EmployeeController(contractservice, contractvalidator, printout);
                
                permanentcontroler.processPermanent(permanent);
                contractcontroler.processContract(contract);
                           
                
		
	}	

}
