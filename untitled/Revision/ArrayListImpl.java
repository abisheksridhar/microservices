package Revision;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ArrayListImpl {

    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        Employee e1 = new Employee(1000,"abc","eng");
        Employee e2 = new Employee(2000,"bca","eng2");
        Employee e3 = new Employee(3000,"cab","eng3");
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        ArrayList<Employee> E2 = new ArrayList<>();
        E2.addAll(employees);
        System.out.println(E2);
        ArrayList<Employee> E3 = new ArrayList<>();
        E3=(ArrayList<Employee>) E2.clone();
        System.out.println(E3);
        E3.remove(2);
        Predicate<Employee> pr = employee -> employee.getEmployeeId()<2000;
        E3.removeIf(pr);
        System.out.println(E3);
        Consumer<Employee> con = employee -> {
            if(employee.getEmployeeDesignation().equals("eng"))
            employee.setEmployeeId((int)employee.getEmployeeId()+1000);};
        E2.forEach(con);
        ListIterator iterator = E2.listIterator();
        while(iterator.hasNext())
        {
            Employee e = (Employee) iterator.next();
            System.out.println(e.employeeId);
            System.out.println(e.employeeDesignation);
            System.out.println(e.employeeName);
        }
    }
}
