# Table of Contents
* Purpose of the Program
* Environment Requirements
* How to Setup the Program
* Program Design

# Purpose of the Program
Solution to Exercise 24.4 on Page 1105 for Java How to Program 10ed by Deitel. The program adds employees to the appropriate tables in MySQL database. It demonstrates a Java application communicating with a MySQL database.
# Environment Requirements
A Linux machine running a MySQL database.
# How to Setup the Program
Create the database using the Employees-MySQL.sql file with the following command.
```
mysql > source [file path of SQL file]
```
Download the Java JDBC Connector MySQL file from [dev.mysql.com](https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=1&cad=rja&uact=8&ved=0ahUKEwit0dew29rWAhUC9IMKHUJUAVoQFggoMAA&url=https%3A%2F%2Fdev.mysql.com%2Fdownloads%2Fconnector%2Fj%2F5.1.html&usg=AOvVaw17O5ZaUyz20k5-e0sAmPLK). Place the Jar file in your IDE's installation folder. Load the Jar file
Afterwards, load the .java files into a new project. Via IntelliJ click File > Project Structure > Module > Plus Sign > 1. Jar or directories > File location of Jar file.

# Program Design
The superclass in Employee.java and contains asks the user the common information required of all employees. The other four employee files extend the superclass employee. The four employee files ask specific questions related to that employee and override the addNewEmployee() function. <br/>
The SQL queries are executed via prepareStatements.
