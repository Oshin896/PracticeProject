package com.company;

public class EmployeeNode {

    Employee employee;
    String key;

    public EmployeeNode(Employee employee, String key) {
        this.employee = employee;
        this.key = key;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "EmployeeNode{" +
                "employee=" + employee +
                ", key='" + key + '\'' +
                '}';
    }
}
