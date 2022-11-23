package SetterInjection;

import ConstructorInjection.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("SetterInjection.xml");
        Employee employee = (Employee) context.getBean("employee2");
        System.out.println(employee.toString());
    }
}
