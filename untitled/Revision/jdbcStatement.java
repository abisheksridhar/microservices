package Revision;

import java.sql.*;
import java.util.ArrayList;

public class jdbcStatement {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection
                ("jdbc:postgresql://localhost:5432/test","abisheks","12345678");

        Employee employee = new Employee(1000,"abc","a_b_c");
        Employee employee1 = new Employee(1001,"def","d_e_f");
        Employee employee2 = new Employee(1002,"ghi","g_h_i");
        ArrayList<Employee> e1= new ArrayList<>();
        e1.add(employee);
        e1.add(employee2);
        e1.add(employee1);
        String query = "insert into employee values(?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        connection.setAutoCommit(false);
        for(Employee x:e1)
        {
            preparedStatement.setInt(1,x.getEmployeeId());
            preparedStatement.setString(2,x.getEmployeeName());
            preparedStatement.setString(3,x.getEmployeeDesignation());
            preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();
        connection.commit();

        String query2 = "select * from employee";
        preparedStatement = connection.prepareStatement(query2);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getInt(1));
            System.out.println(rs.getString(2));
            System.out.println(rs.getString(3));
        }
        connection.close();
    }
}
