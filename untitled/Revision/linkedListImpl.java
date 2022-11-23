package Revision;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.function.Predicate;

public class linkedListImpl {
    public static void main(String[] args) {
        LinkedList<Employee> employeesList1 = new LinkedList<>();
        Employee e1 = new Employee(1100,"abc","zyx");
        Employee e2 = new Employee(1101,"bcd","yxw");
        Employee e3 = new Employee(1102,"cde","xwv");
        Employee e4 = new Employee(1103,"def","wvu");
        employeesList1.add(e1);
        employeesList1.add(e2);
        employeesList1.add(e4);
        employeesList1.add(e3);
        LinkedList<Employee> employeesList2 = new LinkedList<>();
        employeesList2 = (LinkedList<Employee>)employeesList1.clone();
        System.out.println(employeesList2.containsAll(employeesList1));
        employeesList1.remove(0);
        ListIterator iterator = employeesList1.listIterator();
        while (iterator.hasNext())
        {
            Employee e = (Employee) iterator.next();
            System.out.println(e.getEmployeeName());
            System.out.println(e.getEmployeeDesignation());
        }
        Predicate<Employee> pr = employee -> employee.getEmployeeId()<1101;
        employeesList1.removeIf(pr);
        System.out.println(employeesList1.size());
        Iterator it = employeesList2.descendingIterator();
        while (it.hasNext())
        {
            System.out.println(((Employee)it.next()).getEmployeeName());
        }

    }
}
