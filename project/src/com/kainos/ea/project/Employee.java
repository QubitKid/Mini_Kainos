package com.kainos.ea.project;

public class Employee {

    private short emp_no;
    private String emp_name;
    private String ni_number; //national insurance number
    //private int bank_id; // sort code, account number
    private String sortCode;
    private String accountNum;
    private int starting_salary; //in pence, ie £7000 is 7_000_00
    private int department_id; //department ID
    private int is_manager;

    private String address;


    public Employee(){
        //empty instance
    }

    public Employee(String name, String address, String nin, int salary, int deptID, int isManager, String accNum, String sortCode){
        this.emp_name = name;
        this.address = address;
        this.ni_number = nin;
        this.starting_salary = salary;
        this.department_id =deptID;
        this.is_manager = isManager;
        this.accountNum = accNum;
        this.sortCode = sortCode;

    }

    public short getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(short emp_no) {
        this.emp_no = emp_no;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getNi_number() {
        return ni_number;
    }

    public void setNi_number(String ni_number) {
        this.ni_number = ni_number;
    }



    public int getStarting_salary() {
        return starting_salary;
    }

    public void setStarting_salary(int starting_salary) {
        this.starting_salary = starting_salary;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public int getIs_manager() {
        return is_manager;
    }

    public void setIs_manager(int is_manager) {
        this.is_manager = is_manager;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }
}
