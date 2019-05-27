package login;

import db_connection.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserAuthentication
{
    Connection connection;

    public UserAuthentication()
    {
        try
        {
            this.connection = DbConnection.getConnection();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        if (this.connection == null)
        {
            System.exit(1);
        }
    }

    public boolean isConnected ()
    {
        return this.connection != null;
    }

    public boolean isValid(String user, String pass, String opt) throws Exception
    {
        PreparedStatement pr = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM _login WHERE username = ? AND password = ? AND division = ?";

        try
        {
            pr = this.connection.prepareStatement(sql);
            pr.setString(1, user);
            pr.setString(2, pass);
            pr.setString(3, opt);

            rs = pr.executeQuery();

            if(rs.wasNull()) System.out.println("null rs");
            if (rs.next())
            {
                return true;
            }

            return false;
        }
        catch (SQLException ex)
        {
            return false;
        }

        finally {
            pr.close();
            rs.close();
        }
    }
}
