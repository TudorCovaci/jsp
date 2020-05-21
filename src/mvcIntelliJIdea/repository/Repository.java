package mvcIntelliJIdea.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public interface Repository {

    default Statement connect() {
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/jsp", "postgres", "12345678");
            stmt = con.createStatement();
        } catch (Exception ex) {
            System.out.println("Connection failure:" + ex.getMessage());
            ex.printStackTrace();
        }
        return stmt;
    }
}
