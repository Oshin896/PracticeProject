package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Employee name1=new Employee("Abcd","efgh",123);
        Employee name2=new Employee("ijkl","efgh",124);
        Employee name3=new Employee("mnop","efgh",125);
        Employee name4=new Employee("qrst","efgh",126);

        EmployeeLinkedList emp=new EmployeeLinkedList();
        emp.addToFront(name1);
        emp.addToFront(name2);
        emp.addToFront(name3);
        emp.addToFront(name4);
        System.out.println(emp.getSize());
        emp.printList();
    }
}
