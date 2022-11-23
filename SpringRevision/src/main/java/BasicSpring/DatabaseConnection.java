package BasicSpring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    String URL;
    String UserName;
    String Password;
    String classPath;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getClassPath() {
        return classPath;
    }

    public void setClassPath(String classPath) {
        this.classPath = classPath;
    }

    public DatabaseConnection(String URL, String userName, String password, String classPath) {
        this.URL = URL;
        UserName = userName;
        Password = password;
        this.classPath = classPath;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    Connection dbConnection() throws ClassNotFoundException, SQLException {
        Class.forName(classPath);
        Connection connection = DriverManager.getConnection(URL,UserName,Password);
        return connection;
    }
}
