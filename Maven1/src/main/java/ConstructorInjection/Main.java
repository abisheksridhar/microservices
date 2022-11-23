package ConstructorInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Employee e = context.getBean(Employee.class);
        Employee e2 = context.getBean(Employee.class);
        System.out.println(e.toString());
        System.out.println(e2.toString());
    }
}
