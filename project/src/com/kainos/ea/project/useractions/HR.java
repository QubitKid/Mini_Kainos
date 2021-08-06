package com.kainos.ea.project.useractions;

import com.kainos.ea.project.DBConnection;
import com.kainos.ea.project.Employee;
import com.kainos.ea.project.Main;

public class HR extends UserAction {

    public static DBConnection db = new DBConnection();

    public void getOptions(){
        System.out.println("1. Add new employee");
        System.out.println("2. Generate employee report");
        System.out.println("3. Add new sales employee");
        // other options
    }

    public void handleOption(String option){
        switch (option){
            case "1":
                HR.addEmployee();
                break;
            case "2":
                HR.showReport();
                break;
            default:
                System.out.println("Invalid option");
        }
    }

    public static void addEmployee() {
        Employee employee = new Employee();

        System.out.println("Full name: ");
        employee.setEmp_name(Main.sc.nextLine());
        System.out.println("Address: ");
        employee.setAddress(Main.sc.nextLine());
        System.out.println("Ni number: ");
//        if(Main.sc.nextLine().length() > 13){
//            System.out.println("Length of NI Number cannot exceed 13 characters. Please try again.");
//        }
        employee.setNi_number(Main.sc.nextLine());
        System.out.println("Starting salary: ");
        while(!Main.sc.hasNextInt()){
            System.out.println("Starting salary must be a number. Please try again.");
            Main.sc.next();
        }
        employee.setStarting_salary(Main.sc.nextInt());
        System.out.println("Department ID: ");
        while(!Main.sc.hasNextInt()){
            System.out.println("Department ID must be a number. Please try again.");
            Main.sc.next();
        }
        employee.setDepartment_id(Main.sc.nextInt());
        System.out.println("Is manager?: ");
        while(!Main.sc.hasNextShort()){
            System.out.println("Is manager must be a bit (1 or 0). Please try again.");
            Main.sc.next();
        }
        employee.setIs_manager(Main.sc.nextShort());
        Main.sc.nextLine();
        System.out.println("Account number: ");
//        if(Main.sc.nextLine().length() > 8){
//            System.out.println("Length of Account Number cannot exceed 8 characters. Please try again.");
//        }
        employee.setAccountNum(Main.sc.nextLine());
        System.out.println("Sort Code: ");
//        if(Main.sc.nextLine().length() > 8){
//            System.out.println("Length of Sort Code cannot exceed 8 characters. Please try again.");
//        }
        employee.setSortCode(Main.sc.nextLine());


        db.addEmployee(employee);

    }

    public static void showReport(){

        db.getEmployees();

    }
}
