package db_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
        private static final String CONNECTION = "jdbc:postgresql://localhost:5432/psg";
//        private static final String SQCONN = "jdbc:sqlite:fc.sqlite";

        public static Connection getConnection() throws SQLException
        {
            try
            {
                Class.forName("org.postgresql.Driver");
                return DriverManager.getConnection(CONNECTION, "postgres", "1denchin");
            }
            catch (ClassNotFoundException ex)
            {
                ex.printStackTrace();
            }

            return null;
        }
    }
