import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

// Fig. 10.7: CommissionEmployee.java
// CommissionEmployee class extends Employee.

//********************************************************************
//
//  Author:               Javier Lona
//
//  Program #:            12
//
//  File Name:            CommissionEmployee.java
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

public class CommissionEmployee extends Employee 
{
	protected double grossSales; // gross weekly sales
	protected double commissionRate; // commission percentage

   // constructor
	public CommissionEmployee(String firstName, String lastName, 
		String socialSecurityNumber, String birthday, String empType, String 
		deptName, double bonus, double grossSales, double commissionRate)
   {
		super(firstName, lastName, socialSecurityNumber, birthday, "commissionEmployee",
		deptName, bonus);

		this.grossSales = grossSales;
		this.commissionRate = commissionRate;
   }
   
   public CommissionEmployee()
   {
		super();
		empType = "commissionEmployee";
		Scanner input = new Scanner(System.in);
		System.out.printf("Enter gross sales: ");
		grossSales = input.nextDouble();
		System.out.printf("Enter commission rate: ");
		commissionRate = input.nextDouble();
   }
   
   @Override
   public void addNewEmployee(PreparedStatement statement, 
	   Connection connection) throws SQLException
	{
		super.addNewEmployee(statement, connection);
		statement = connection.prepareStatement(
			"INSERT INTO commissionEmployees " +
			"(socialSecurityNumber, grossSales, commissionRate, "+
			"bonus) VALUES (?, ?, ?, ?)");


		statement.setString(1, socialSecurityNumber);
		statement.setDouble(2, grossSales);
		statement.setDouble(3, commissionRate);
		statement.setDouble(4, bonus);

		int result = 0;
		result = statement.executeUpdate();
		System.out.printf("%s%d%s%n", "Query Ok, ", result, " row affected in commissionEmployees table");
	}

} // end class CommissionEmployee
