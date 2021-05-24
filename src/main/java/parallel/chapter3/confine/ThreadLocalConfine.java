package parallel.chapter3.confine;

import java.sql.Connection;

public class ThreadLocalConfine {

    private final static String DB_URL = "";
    private static ThreadLocal<Connection> connectionHolder;
    /*
    = new ThreadLocal<Connection>() {
        public Connection initialValue() {
            try {
                return DriverManager.getConnection(DB_URL);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    };
    */

    public static Connection getConnection() {
        return connectionHolder.get();
    }
}
