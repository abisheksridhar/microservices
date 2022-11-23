package BasicSpring;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class Employee {
    long employeeId;
    String employeeName;
    String employeeDesignation;

//    public Employee() {
//    }
//
//    public Employee(long employeeId, String employeeName, String employeeDesignation) {
//        this.employeeId = employeeId;
//        this.employeeName = employeeName;
//        this.employeeDesignation = employeeDesignation;
//    }

    public long getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeeDesignation() {
        return employeeDesignation;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setEmployeeDesignation(String employeeDesignation) {
        this.employeeDesignation = employeeDesignation;
    }

}
