package model;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

public class Conection {

    protected static String db = "dadosprodutos";
    protected static String ip = "10.0.2.2";
    protected static String port = "3306";
    protected static  String user = "root";
    protected static  String password = "root";
    protected static Connection conn;

    public Conection() {
    }

    public static Connection getConexao() {
        try {
            if (conn == null || conn.isClosed()) {
                Class.forName("com.mysql.jdbc.Driver");
                String connectionString = "jdbc:mysql.jdbc.Driver//" +ip + ":"+ port+ "/"+db;
                conn = DriverManager.getConnection(connectionString, user, password);
            }
            return conn;
        } catch (SQLException | ClassNotFoundException e) {
            Log.e("ERRO", Objects.requireNonNull(e.getMessage()));

        }
        return conn;
    }
}
