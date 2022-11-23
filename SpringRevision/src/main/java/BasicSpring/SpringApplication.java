package BasicSpring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SpringApplication {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext
                                                ("spring.xml");
        DatabaseConnection dbconnection = applicationContext.getBean(DatabaseConnection.class);
        Connection connection = dbconnection.dbConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from employee");
        Employee employee = applicationContext.getBean(Employee.class);
        ArrayList<Employee> employeesList = new ArrayList<>();
        while(rs.next())
        {
            employee.setEmployeeId(rs.getInt(1));
            employee.setEmployeeName(rs.getString(2));
            employee.setEmployeeDesignation(rs.getString(3));
            employeesList.add(employee);
        }

        System.out.println(employeesList.get(2).getEmployeeId());
    }
}
