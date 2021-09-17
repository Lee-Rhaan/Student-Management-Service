package com.xgileit.learning.student.service;

import com.xgileit.learning.student.exception.StudentNotFoundException;
import com.xgileit.learning.student.model.Student;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 *  Note: In all of these methods I have established the connection with the database to the server
 *        in a try-with-resources statement. It closes the connection automatically, which leads
 *        to less boilerplate code.
 */

public class StudentService {

    String databaseUrl = "jdbc:mysql://localhost:3306/studentmanagementservice";
    String username = "root";
    String password = "12345";

    private Map<Long, Student> students = new HashMap<>();

    /**
     * Establishing a connection with the database to the server. Then executing a query that gets
     * all the data in the "student" table in the "studentmanagementservice" database.
     * Then i'm using a while loop to iterate through the data with the "resultset.next()" method.
     * With each iteration a new student object gets created and added to the hashmap.
     *
     * @return hashmap containing a list of all the students in the database.
     */
    public Map<Long, Student> getAllStudents()
    {

        try (Connection connection = DriverManager.getConnection(databaseUrl, username, password))
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from student");

            while(resultSet.next())
            {
                Student student = new Student();

                student.setStudentNumber(resultSet.getLong(1));
                student.setFirstName(resultSet.getString(2));
                student.setSecondName(resultSet.getString(3));
                student.setAddress(resultSet.getString(4));

                students.put(student.getStudentNumber(), student);
            }

        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        return students;
    }

    /**
     * Establishing a connection with the database to the server. Then executing a query that inserts
     * the attributes of the student object (that's being passed as an argument to this method),
     * into the rows of the specified columns in the "student" table.
     *
     * @param student object
     * @return String response "Student Added", if the request were successful.
     */
    public String addNewStudent(Student student)
    {
        String sql = "INSERT INTO student(firstname, secondName, address)" +
                "VALUES(?, ?, ?);";

        try (Connection connection = DriverManager.getConnection(databaseUrl, username, password))
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getSecondName());
            preparedStatement.setString(3, student.getAddress());

            preparedStatement.executeUpdate();

        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        return "Student Added";
    }

    /**
     * Establishing a connection with the database to the server. Then executing a query that first
     * checks if the name of the student object (that's being passed as an argument to this method),
     * exists in the "student" table.
     * If it does, then the default data gets replaced with the updated data.
     * If there's no match, this method throws a student not found exception.
     *
     * @param student object
     * @return String response "Student Updated", if the request were successful.
     */
    public String updateStudent(Student student)
    {
        String sql = "UPDATE student SET firstName=?, secondName=?, address=? WHERE firstname=?";

        try (Connection connection = DriverManager.getConnection(databaseUrl, username, password))
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getSecondName());
            preparedStatement.setString(3, student.getAddress());
            preparedStatement.setString(4, student.getFirstName());

            preparedStatement.executeUpdate();

        }
        catch(Exception e)
        {
            throw new StudentNotFoundException("Student: " + student +
                    " not found", e);
        }

        return "Student Updated";
    }

    /**
     * Establishing a connection with the database to the server. Then executing a query that first
     * checks if the studentNumber (that's being passed as an argument to this method),
     * exists in the "student" table.
     * If it does exist, then the student with that studentNumber gets removed from the database.
     * If there's no match, this method throws a student not found exception.
     *
     * @param studentNumber Long
     * @return String response "Student Deleted", if the request were successful.
     */
    public String deleteStudentByStudentNumber(Long studentNumber)
    {
        String sql = "DELETE FROM student WHERE studentNumber=?";

        try (Connection connection = DriverManager.getConnection(databaseUrl, username, password))
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, studentNumber);

            preparedStatement.executeUpdate();

        }
        catch(Exception e)
        {
            throw new StudentNotFoundException("Student with studentNumber: " + studentNumber +
                    " not found", e);
        }

        /*
        added this because when I delete a student from the database, and execute the list all
        method, the deleted student still shows up as a student in the database, although that's
        not true.
         */
        students.remove(studentNumber);
        return "Student Deleted";
    }

    /**
     * Establishing a connection with the database to the server. Then executing a query that finds
     * and selects every student with a studentNumber matching the one being passed as an argument
     * to this method.
     * If there's no match, this method throws a student not found exception.
     *
     * @param studentNumber Long
     * @return student object with matching studentNumber.
     */
    public Student findStudentByStudentNumber(Long studentNumber)
    {
        String sql = "SELECT * FROM student WHERE studentNumber=?";

        try (Connection connection = DriverManager.getConnection(databaseUrl, username, password))
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, studentNumber);

            preparedStatement.executeUpdate();

        }
        catch(Exception e)
        {
            throw new StudentNotFoundException("Student with studentNumber: " + studentNumber +
                    " not found", e);
        }

        return students.get(studentNumber);
    }

}
