package konyvtar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TagKezelo {

    public static void ujTagHozzaadas(String name, String email, String birthDate, String joinDate, double fee) {

        String sql = "INSERT INTO members (name, email, birth_date, join_date, membership_fee) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = AdatbazisKapcsolat.kapcsolodas();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, birthDate);
            pstmt.setString(4, joinDate);
            pstmt.setDouble(5, fee);

            pstmt.executeUpdate();

            System.out.println("Uj tag sikeresen hozzaadva!");

        } catch (SQLException e) {
            System.out.println("Hiba a beszurasnal: " + e.getMessage());
        }
    }

    public static void tagokListazasa() {

        String sql = "SELECT * FROM members";

        try (Connection conn = AdatbazisKapcsolat.kapcsolodas();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("=== TAGOK LISTAJA ===");

            while (rs.next()) {
                int id = rs.getInt("id");
                String nev = rs.getString("name");
                String email = rs.getString("email");
                String szuletesiDatum = rs.getString("birth_date");
                String csatlakozas = rs.getString("join_date");
                double dij = rs.getDouble("membership_fee");

                System.out.println(id + " | " + nev + " | " + email + " | " + szuletesiDatum + " | " + csatlakozas + " | " + dij);
            }

        } catch (SQLException e) {
            System.out.println("Hiba a lekerdezesnel: " + e.getMessage());
        }
    }

    public static void tagKeresesNevAlapjan(String keresettNev) {

        String sql = "SELECT * FROM members WHERE name LIKE ?";

        try (Connection conn = AdatbazisKapcsolat.kapcsolodas();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "%" + keresettNev + "%");

            ResultSet rs = pstmt.executeQuery();

            System.out.println("=== KERESÉSI EREDMÉNYEK ===");

            while (rs.next()) {
                int id = rs.getInt("id");
                String nev = rs.getString("name");
                String email = rs.getString("email");
                String szuletesiDatum = rs.getString("birth_date");
                String csatlakozas = rs.getString("join_date");
                double dij = rs.getDouble("membership_fee");

                System.out.println(id + " | " + nev + " | " + email + " | " + szuletesiDatum + " | " + csatlakozas + " | " + dij);
            }

        } catch (SQLException e) {
            System.out.println("Hiba a keresesnel: " + e.getMessage());
        }
    }

    public static void tagModositasa(int id, String ujNev, String ujEmail, String ujBirthDate, String ujJoinDate, double ujFee) {

        String sql = "UPDATE members SET name = ?, email = ?, birth_date = ?, join_date = ?, membership_fee = ? WHERE id = ?";

        try (Connection conn = AdatbazisKapcsolat.kapcsolodas();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, ujNev);
            pstmt.setString(2, ujEmail);
            pstmt.setString(3, ujBirthDate);
            pstmt.setString(4, ujJoinDate);
            pstmt.setDouble(5, ujFee);
            pstmt.setInt(6, id);

            int sorokSzama = pstmt.executeUpdate();

            if (sorokSzama > 0) {
                System.out.println("A tag adatai sikeresen modositva!");
            } else {
                System.out.println("Nem talalhato tag ezzel az id-val.");
            }

        } catch (SQLException e) {
            System.out.println("Hiba a modositasnal: " + e.getMessage());
        }
    }

    public static void tagTorlese(int id) {

        String sql = "DELETE FROM members WHERE id = ?";

        try (Connection conn = AdatbazisKapcsolat.kapcsolodas();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            int sorokSzama = pstmt.executeUpdate();

            if (sorokSzama > 0) {
                System.out.println("A tag sikeresen torolve!");
            } else {
                System.out.println("Nem talalhato tag ezzel az id-val.");
            }

        } catch (SQLException e) {
            System.out.println("Hiba a torlesnel: " + e.getMessage());
        }
    }
}