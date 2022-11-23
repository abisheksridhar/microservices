package Revision;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.function.Predicate;

public class HashSetImpl {
    public static void main(String[] args) {
        HashSet<Employee> employee = new HashSet<>();
        Employee e1 = new Employee(1100,"abc","zyx");
        Employee e2 = new Employee(1101,"bcd","yxw");
        Employee e3 = new Employee(1102,"cde","xwv");
        Employee e4 = new Employee(1103,"def","wvu");
        employee.add(e1);
        employee.add(e2);
        employee.add(e3);
        employee.add(e4);
        HashSet<Employee> employee2 = new HashSet<>(employee);
        Iterator<Employee> iterator = employee2.iterator();
        System.out.println(employee2.containsAll(employee));
        Predicate<Employee> pr = employee1 -> employee1.getEmployeeId() == 1100;
        employee.removeIf(pr);
        while (iterator.hasNext())
        {
            System.out.println(iterator.next().getEmployeeId());
        }
        employee.addAll(employee2);
        for(Employee x : employee)
        {
            System.out.println(x.getEmployeeId());
        }
        TreeSet<Employee> treeSet = new TreeSet<>(new EmployeeComparator());
        treeSet.addAll(employee);
        System.out.println("Sorted Set");
        for(Employee x : treeSet)
        {
            System.out.println(x.getEmployeeId());
        }
        System.out.println(treeSet.first().getEmployeeName());
        Predicate<Employee> employeePredicate = employee1 -> employee1.employeeId==1100;
        treeSet.removeIf(employeePredicate);
        treeSet.remove(e4);
        for(Employee x : treeSet)
        {
            System.out.println(x.getEmployeeId());
        }

    }
}
