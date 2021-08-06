package com.kainos.ea.project;

import java.io.FileInputStream;
import java.sql.*;
import java.util.List;
import java.util.Properties;

public class DBConnection {
    private static Connection c;

    public DBConnection(){
        String user;
        String password;
        String host;

        try (var f = new FileInputStream("employeesdb.properties")){
            Properties props = new Properties();
            props.load(f);
            user = props.getProperty("user");
            password = props.getProperty("password");
            host = props.getProperty("host");
            if (user == null || password == null || host == null)
                throw new IllegalArgumentException(
                        "Properties file must exist and must contain user, " +
                                "password, and host properties.");
            c = DriverManager.getConnection("jdbc:mysql://" + host +
                    "/mini_kainos_blank_venison", user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addEmployee(Employee employee) {
        try {
            String query = "INSERT INTO Employee(emp_name, address, ni_number, starting_salary, department_id, is_manager, acc_no, sortCode) VALUES (?,?,?,?,?,?,?,?)";

            PreparedStatement preparedStmt = c.prepareStatement(query);

            preparedStmt.setString (1, employee.getEmp_name());

            preparedStmt.setString (2, employee.getAddress());

            preparedStmt.setString(3, employee.getNi_number());

            preparedStmt.setInt (4, employee.getStarting_salary());

            preparedStmt.setInt (5, employee.getDepartment_id());

            preparedStmt.setInt (6, employee.getIs_manager());

            preparedStmt.setString (7, employee.getAccountNum());

            preparedStmt.setString (8, employee.getSortCode());

            preparedStmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addSalesEmployee(SalesEmployee employee) {

        addEmployee(employee);
        
        try {
            String query = "INSERT INTO SalesEmployee(emp_no, commission_rate, total_sales) VALUES (?,?,?)";

            PreparedStatement preparedStmt = c.prepareStatement(query);
            preparedStmt.setInt (1, employee.getEmp_no());
            preparedStmt.setInt (2, employee.getCommissionRate());
            preparedStmt.setInt(3, employee.getSalesTotal());

            preparedStmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getEmployees() {
        try {
            Statement s = c.createStatement();
            ResultSet rows = s.executeQuery(
                    """
                        select emp_name, department_name from Employee inner join Department on Employee.department_id = Department.department_id;
                        """);
            while (rows.next()) {
                System.out.println("Employee details: " + rows.getString("emp_name") + ". Works in : " + rows.getString("department_name"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
