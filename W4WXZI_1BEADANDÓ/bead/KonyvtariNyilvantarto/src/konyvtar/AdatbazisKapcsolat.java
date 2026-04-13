package konyvtar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AdatbazisKapcsolat {

    private static final String URL = "jdbc:sqlite:library.db";

    public static Connection kapcsolodas() {
        try {
            Connection conn = DriverManager.getConnection(URL);
            System.out.println("Sikeres kapcsolat az adatbazishoz!");
            return conn;
        } catch (SQLException e) {
            System.out.println("Hiba a kapcsolodasnal: " + e.getMessage());
            return null;
        }
    }
}