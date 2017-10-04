import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class HourlyEmployee extends Employee
{
	private double wage; // wage per hour
	private int hours; // hours worked for week

	// constructor
	public HourlyEmployee(String firstName, String lastName,
		String socialSecurityNumber, String birthday,
		String deptName, double bonus, double wage, int hours)

	{
		super(firstName, lastName, socialSecurityNumber, birthday, "hourlyEmployee",
				  deptName, bonus);

		this.wage = wage;
		this.hours = hours;
	}

   public HourlyEmployee ()
   {
		super();
		empType = "hourlyEmployee";
		Scanner input = new Scanner(System.in);
		System.out.printf("Enter wage: ");
		wage = input.nextDouble();
		System.out.printf("Enter hours: ");
		hours = input.nextInt();
   }
   @Override
   public void addNewEmployee(PreparedStatement statement,
		   Connection connection) throws SQLException
	{

		super.addNewEmployee(statement, connection);

		statement = connection.prepareStatement(
			"INSERT INTO hourlyEmployees " +
			"(socialSecurityNumber, hours, wage, "+
			"bonus) VALUES (?, ?, ?, ?)");
		statement.setString(1, socialSecurityNumber);
		statement.setInt(2, hours);
		statement.setDouble(3, wage);
		statement.setDouble(4, bonus);

		int result = 0;
		result = statement.executeUpdate();
		  System.out.printf("%s%d%s%n", "Query Ok, ", result, " row affected in hourlyEmployees table");
	}

} // end class HourlyEmployee
