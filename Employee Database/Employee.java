import java.sql.*;
import java.util.Scanner;

public class Employee
{
	protected final String firstName;
	protected final String lastName;
	protected final String socialSecurityNumber;
	protected final String birthday;
	protected String empType;
	protected final String deptName;
	protected final double bonus;


	// constructor
	public Employee(String firstName, String lastName,
		String socialSecurityNumber, String birthday, String empType,
		String deptName, double bonus)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
		this.birthday = birthday;
		this.empType = empType;
		this.deptName = deptName;
		this.bonus = bonus;
	}

   public Employee()
   {
		Scanner input = new Scanner(System.in);

		System.out.printf("Enter Social Security Number: ");
		socialSecurityNumber = input.nextLine();
		System.out.printf("Enter First Name: ");
		firstName = input.nextLine();
		System.out.printf("Enter Last Name: ");
		lastName = input.nextLine();
		System.out.printf("Enter Birthday: ");
		birthday = input.nextLine();
		System.out.printf("Enter Department Name: ");
		deptName = input.nextLine();
		System.out.printf("Enter bonus: ");
		bonus = input.nextDouble();
   }

	public void addNewEmployee(PreparedStatement statement,
		Connection connection) throws SQLException
	{
		statement = connection.prepareStatement(
			"INSERT INTO employees " +
			"(socialSecurityNumber, firstName, lastName, birthday, " +
			"employeeType, departmentName)" +
			"VALUES (?, ?, ?, ?, ?, ?)");

		int result = 0;

		statement.setString(1, socialSecurityNumber);
		statement.setString(2, firstName);
		statement.setString(3, lastName);
		statement.setString(4, birthday);
		statement.setString(5, empType);
		statement.setString(6, deptName);

		result = statement.executeUpdate();
		System.out.printf("%s%d%s%n", "Query Ok, ", result, " row affected in employees table");
	}
} // end class Employee
