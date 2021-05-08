package mvc.test;

import mvc.businessLogic.EmployeeBusinessLogic;
import mvc.model.Employee;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EmployeeBusinessLogicTest {
    Employee employee=new Employee();
    EmployeeBusinessLogic employeeBusinessLogic=new EmployeeBusinessLogic();

    @Test
    public void calculateYearlySalarytest() {
        double yearlySalary = 0;
        employee.setName("Oshin");
        employee.setMonthlySalary(10000);
        employee.setAge(23);
        yearlySalary = employeeBusinessLogic.calculateYearlySalary(employee);
        assertEquals(120000,yearlySalary,0.0);
    }
    public void calculateAppraisal() {
        double appraisal = 0;
        employee.setName("Oshin");
        employee.setMonthlySalary(10000);
        employee.setAge(23);
       appraisal=employeeBusinessLogic.calculateAppraisal(employee);
       assertEquals(1000,appraisal,0.0);


    }
}
