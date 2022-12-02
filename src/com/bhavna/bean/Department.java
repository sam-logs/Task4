package com.bhavna.bean;

public class Department {
    private int departmentId;
    private String departmentName;

    private int employeeId;

    public Department(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Department(int departmentId, String departmentName, int employeeId) {

        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.employeeId = employeeId;
    }
}
