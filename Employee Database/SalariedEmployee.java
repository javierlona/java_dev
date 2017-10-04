import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

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
