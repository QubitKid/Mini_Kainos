package com.kainos.ea.project;

public class SalesEmployee extends Employee{

    private int commissionRate;
    private int salesTotal;


    public SalesEmployee(String name, String address, String nin, int salary, int deptID, int isManager, String accNum, String sortCode, int commissionRate, int salesTotal){
        super(name,address,nin,salary,deptID,isManager,accNum,sortCode);
        this.setCommissionRate(commissionRate);
        this.setSalesTotal(salesTotal);
    }

    public int getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(int commissionRate) {
        this.commissionRate = commissionRate;
    }

    public int getSalesTotal() {
        return salesTotal;
    }

    public void setSalesTotal(int salesTotal) {
        this.salesTotal = salesTotal;
    }
}
