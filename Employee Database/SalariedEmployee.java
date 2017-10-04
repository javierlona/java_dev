import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

// Fig. 10.5: SalariedEmployee.java
// SalariedEmployee concrete class extends abstract class Employee.

//********************************************************************
//
//  Author:               Javier Lona
//
//  Program #:            12
//
//  File Name:            SalariedEmployee.java
//
//  Course:               ITSE 2317 Intermediate Java
//
//  Due Date:             Wednesday, May 10, 2017
//
//  Instructor:           Fred Kumi 
//
//  Chapter:              Chapter 24: Accessing Databases with JDBC
//
//  Description:
//     Adds employee to appropriate tables in MySQL database.
//
//********************************************************************

public class SalariedEmployee extends Employee 
{
	private double weeklySalary;

	// constructor
	public SalariedEmployee(String firstName, String lastName, 
		String socialSecurityNumber, String birthday, String deptName, 
		double bonus, double weeklySalary)
	{
		super(firstName, lastName, socialSecurityNumber, birthday, 
				  "salariedEmployee", deptName, bonus); 
	  
		this.weeklySalary = weeklySalary;
	}
   
   public SalariedEmployee ()
   {
		super();
		empType = "salariedEmployee";
		Scanner input = new Scanner(System.in);
		System.out.printf("Enter weekly salary: ");
		weeklySalary = input.nextDouble();
   }
   
   @Override
   public void addNewEmployee(PreparedStatement statement, 
		   Connection connection) throws SQLException
   {
		super.addNewEmployee(statement, connection);

		statement = connection.prepareStatement(
		"INSERT INTO salariedEmployees " +
		"(socialSecurityNumber, weeklySalary, bonus) "+
		"VALUES (?, ?, ?)");
		statement.setString(1, socialSecurityNumber);
		statement.setDouble(2, weeklySalary);
		statement.setDouble(3, bonus);

		int result = 0;
		result = statement.executeUpdate();
		System.out.printf("%s%d%s%n", "Query Ok, ", result, " row affected in salariedEmployees table");
   }

} // end class SalariedEmployee
