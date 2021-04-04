package basic_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {
    public static void main(String[] args) {
        String user = "root";
        String password = "mariaDB";

        String driver = "mysql";
        String dbAddress = "localhost";
        String dbPort = ":3306";
        String dbName = "digital_innovation_one";

        String urlConnection = "jdbc:" +
                driver + "://" +
                dbAddress + dbPort +
                dbName;


        try (Connection conn = DriverManager.getConnection(urlConnection, user, password);){
            System.out.println("Sucesso!");
        } catch (SQLException e) {
            System.out.println("Falha");
        }
    }
}
