package konyvtar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class KolcsonzesKezelo {

    public static void ujKolcsonzesHozzaadas(int memberId, String bookTitle, String loanDate, String dueDate, String returnDate, double fineAmount) {

        String sql = "INSERT INTO loans (member_id, book_title, loan_date, due_date, return_date, fine_amount) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = AdatbazisKapcsolat.kapcsolodas();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, memberId);
            pstmt.setString(2, bookTitle);
            pstmt.setString(3, loanDate);
            pstmt.setString(4, dueDate);
            pstmt.setString(5, returnDate);
            pstmt.setDouble(6, fineAmount);

            pstmt.executeUpdate();

            System.out.println("Uj kolcsonzes sikeresen hozzaadva!");

        } catch (SQLException e) {
            System.out.println("Hiba a kolcsonzes beszurasanal: " + e.getMessage());
        }
    }

    public static void kolcsonzesekListazasa() {

        String sql = "SELECT * FROM loans";

        try (Connection conn = AdatbazisKapcsolat.kapcsolodas();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("=== KOLCSONZESEK LISTAJA ===");

            while (rs.next()) {
                int id = rs.getInt("id");
                int memberId = rs.getInt("member_id");
                String bookTitle = rs.getString("book_title");
                String loanDate = rs.getString("loan_date");
                String dueDate = rs.getString("due_date");
                String returnDate = rs.getString("return_date");
                double fineAmount = rs.getDouble("fine_amount");

                System.out.println(id + " | " + memberId + " | " + bookTitle + " | " + loanDate + " | " + dueDate + " | " + returnDate + " | " + fineAmount);
            }

        } catch (SQLException e) {
            System.out.println("Hiba a kolcsonzesek lekerdezesenel: " + e.getMessage());
        }
    }

    public static void kapcsoltKolcsonzesekListazasa() {

        String sql = """
            SELECT loans.id, members.name, loans.book_title, loans.loan_date, loans.due_date, loans.return_date, loans.fine_amount
            FROM loans
            INNER JOIN members ON loans.member_id = members.id
        """;

        try (Connection conn = AdatbazisKapcsolat.kapcsolodas();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("=== KAPCSOLT KOLCSONZESEK ===");

            while (rs.next()) {
                int id = rs.getInt("id");
                String memberName = rs.getString("name");
                String bookTitle = rs.getString("book_title");
                String loanDate = rs.getString("loan_date");
                String dueDate = rs.getString("due_date");
                String returnDate = rs.getString("return_date");
                double fineAmount = rs.getDouble("fine_amount");

                System.out.println(id + " | " + memberName + " | " + bookTitle + " | " + loanDate + " | " + dueDate + " | " + returnDate + " | " + fineAmount);
            }

        } catch (SQLException e) {
            System.out.println("Hiba a kapcsolt lekerdezesnel: " + e.getMessage());
        }
    }

    public static void kolcsonzesModositasa(int id, int ujMemberId, String ujBookTitle, String ujLoanDate, String ujDueDate, String ujReturnDate, double ujFineAmount) {

        String sql = "UPDATE loans SET member_id = ?, book_title = ?, loan_date = ?, due_date = ?, return_date = ?, fine_amount = ? WHERE id = ?";

        try (Connection conn = AdatbazisKapcsolat.kapcsolodas();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, ujMemberId);
            pstmt.setString(2, ujBookTitle);
            pstmt.setString(3, ujLoanDate);
            pstmt.setString(4, ujDueDate);
            pstmt.setString(5, ujReturnDate);
            pstmt.setDouble(6, ujFineAmount);
            pstmt.setInt(7, id);

            int sorokSzama = pstmt.executeUpdate();

            if (sorokSzama > 0) {
                System.out.println("A kolcsonzes sikeresen modositva!");
            } else {
                System.out.println("Nem talalhato kolcsonzes ezzel az id-val.");
            }

        } catch (SQLException e) {
            System.out.println("Hiba a kolcsonzes modositasanal: " + e.getMessage());
        }
    }

    public static void kolcsonzesTorlese(int id) {

        String sql = "DELETE FROM loans WHERE id = ?";

        try (Connection conn = AdatbazisKapcsolat.kapcsolodas();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            int sorokSzama = pstmt.executeUpdate();

            if (sorokSzama > 0) {
                System.out.println("A kolcsonzes sikeresen torolve!");
            } else {
                System.out.println("Nem talalhato kolcsonzes ezzel az id-val.");
            }

        } catch (SQLException e) {
            System.out.println("Hiba a kolcsonzes torlesenel: " + e.getMessage());
        }
    }
}