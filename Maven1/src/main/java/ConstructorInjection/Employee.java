package ConstructorInjection;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

public class Employee {
    long empId;
    String empName;
    Address address;
    List<String> skills;

    public Employee()
    {

    }

    public Employee(long empId, String empName, Address address, List<String> skills) {
        this.empId = empId;
        this.empName = empName;
        this.address = address;
        this.skills = skills;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }


    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", address=" + address +
                ", skills=" + skills +
                '}';
    }
}
