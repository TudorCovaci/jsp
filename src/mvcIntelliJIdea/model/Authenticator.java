package mvcIntelliJIdea.model;

import java.sql.*;

/**
 * Created by forest on 16.12.2014.
 */
public class Authenticator {
    private Statement stmt;

    public Authenticator() {
        connect();
    }

    public void connect() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jsp",
                                                         "postgres", "12345678");
            stmt = con.createStatement();
        } catch(Exception ex) {
            System.out.println("Connection failure:"+ex.getMessage());
            ex.printStackTrace();
        }
    }

    public User authenticate(String username, String password) {
        ResultSet rs;
        User result = null;
        System.out.println(username+" "+password);
        try {
            rs = stmt.executeQuery("select * from users where username='"+username+"' and " +
                                   "password='"+password+"'");
            if (rs.next()) {
                result = new User(rs.getInt("id"), rs.getString("username"), rs.getString(
                        "password"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
