package konyvtar;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class AdatbazisLetrehozo {

    public static void tablakatLetrehoz() {

        String membersTabla = """
            CREATE TABLE IF NOT EXISTS members (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT NOT NULL,
                email TEXT NOT NULL UNIQUE,
                birth_date TEXT NOT NULL,
                join_date TEXT NOT NULL,
                membership_fee REAL NOT NULL
            );
        """;

        String loansTabla = """
            CREATE TABLE IF NOT EXISTS loans (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                member_id INTEGER NOT NULL,
                book_title TEXT NOT NULL,
                loan_date TEXT NOT NULL,
                due_date TEXT NOT NULL,
                return_date TEXT,
                fine_amount REAL NOT NULL,
                FOREIGN KEY (member_id) REFERENCES members(id)
            );
        """;

        try (Connection conn = AdatbazisKapcsolat.kapcsolodas();
             Statement stmt = conn.createStatement()) {

            stmt.execute(membersTabla);
            stmt.execute(loansTabla);

            System.out.println("Tablak sikeresen letrehozva!");

        } catch (SQLException e) {
            System.out.println("Hiba a tablák letrehozasakor: " + e.getMessage());
        }
    }
}