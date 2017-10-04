import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class empDB
{
    private static final String CONNECTION =
            "jdbc:mysql://127.0.0.1/employees";

    private static PreparedStatement statement;
    private static final int BASEPLUSCOMMEMP = 1;
    private static final int COMMEMP = 2;
    private static final int HOURLYEMP = 3;
    private static final int SALARYEMP = 4;
    private static final int EXIT = 0;

    public static int whichEmployeeTypeMenu()
    {
        System.out.println("-- Select Employee Type Menu -- ");
        System.out.println("1. Base Plus Commission");
        System.out.println("2. Commission");
        System.out.println("3. Hourly Employee");
        System.out.println("4. Salary Employee");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    public static void main(String[] args) throws
            ClassNotFoundException,SQLException
    {
        // Properties for user and password
        Properties credentials = new Properties();
        credentials.put("user","user1");
        credentials.put("password","password");

        Connection connection = DriverManager.getConnection(CONNECTION, credentials);
        System.out.printf("Successful connection to database.%n%n");

        Employee emp = null;
        int choice = whichEmployeeTypeMenu();

        switch(choice)
        {
            case BASEPLUSCOMMEMP:
                emp = new BasePlusCommissionEmployee();
                break;
            case COMMEMP:
                emp = new CommissionEmployee();
                break;
            case HOURLYEMP:
                emp = new HourlyEmployee();
                break;
            case SALARYEMP:
                emp = new SalariedEmployee();
                break;
            case EXIT:
                System.out.println("Bye.");
                break;
            default:
                System.out.println("Error.");
        }

        if (emp != null)
        {
            emp.addNewEmployee(statement, connection);
        }

        connection.close();
    } // end main

} // end empDB class
