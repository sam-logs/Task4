package com.bhavna.dao;

import com.bhavna.bean.Employee;
import com.bhavna.utility.MyConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Operations {
    public void fetchData() {
        Connection connection = MyConnection.connection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.
                    executeQuery("select * from employee e inner join department d on e.employeeId = d.employeeId;");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + "  " + resultSet.getString(2) + "  " + resultSet.getDouble(3) + " "
                        + resultSet.getString(4) + " " + resultSet.getInt(5) + " " + resultSet.getString(6));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateData() {
        Connection connection = MyConnection.connection();
        try {
            Statement statement = connection.createStatement();
            String query = "UPDATE employee set employeeName = 'Akshay' where employeeId = 904";
            statement.executeUpdate(query);
            ResultSet resultSet = statement.executeQuery("select * from employee;");

            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " "
                        + resultSet.getDouble(3) + " " + resultSet.getString(4));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void saveData(Employee employee) {
        Connection connection = MyConnection.connection();
        try {
            Statement statement = connection.createStatement();
            String q1 = "insert into employee values('" + employee.getEmployeeId() + "', '" + employee.getEmployeeName() + "', '"
                    + employee.getSalary() + "', '" + employee.getJoiningDate()
                    + "')";
            statement.executeUpdate(q1);
            ResultSet resultSet = statement.executeQuery("select * from employee");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " "
                        + resultSet.getDouble(3) + " " + resultSet.getString(4));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void countEmployeeData() {
        Connection connection = MyConnection.connection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select d.departmentName, count(*) from department d inner join employee e on e.employeeId = d.employeeId where d.departmentName = \"Meridian Link\" and e.employeeSalary > 30000;");

            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + " " + resultSet.getInt(2));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
