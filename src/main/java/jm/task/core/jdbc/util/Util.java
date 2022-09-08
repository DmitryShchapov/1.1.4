package jm.task.core.jdbc.util;


import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    public final static String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    public final static String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    public final static String DB_USERNAME = "admin";
    public final static String DB_PASSWORD = "admin";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


    public static SessionFactory getFactory() {
        Properties prop = new Properties();
        prop.setProperty("hibernate.connection.url", DB_URL);
        prop.setProperty("hibernate.connection.driver_class", DB_DRIVER);
        prop.setProperty("hibernate.connection.username", DB_USERNAME);
        prop.setProperty("hibernate.connection.password", DB_PASSWORD);
        prop.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        prop.setProperty("hibernate.current_session_context_class", "thread");

        return new Configuration()
                .addProperties(prop)
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
    }
}
