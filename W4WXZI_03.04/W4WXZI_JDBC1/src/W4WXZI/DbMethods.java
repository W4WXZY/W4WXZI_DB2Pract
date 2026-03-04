package W4WXZI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbMethods {

    private static final String url = "\"C:\\Users\\Felhasználó\\OneDrive\\Asztali gép\\SQLITE\\autodb\"";

    public static void Register() {
        // Driver betöltés
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.out.println("SQLite JDBC driver nem található: " + e.getMessage());
        }
        
        String sql=
        		"CRREATE TABLE IF NOT EXISTS Autp ("+
        				"Renszam char PRIMARY KEY,"+
        				"Tipus char NOT NULL,"+
        				"Szin char NOT NULL,"+
        				"Kor INTEGER NOT NULL,"+
        				"Ar INTENGER NOT NULL,"+
        				"Tulaj char NOT NULL"+
        				");";
        try (Connection conn = Connect();
        		Statement st=conn.createStatement()) {
        	
        	st.execute(sql);
        } catch (SQLException e) {
        	System.out.println("Register hiba: " + e.getMessage());
        }
    }
    
    public static Connection Connect() throws SQLException {
    	return DriveManager.getConnection(url);
    }
    
    public static void ReadAllData() {
        String sql = "SELECT Rendszam, Tipus, Szin, Kor, Ar, Tulaj FROM Auto ORDER BY Rendszam";

        try (Connection conn = Connect();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            System.out.println("\nRendszam\tTipus\tSzin\tKor\tAr\tTulaj");
            System.out.println("--------------------------------------------------------------");

            rs.getString("Rendszam") + "\t" +
            rs.getString("Tipus") + "\t" +
            rs.getString("Szin") + "\t" +
            rs.getInt("Kor") + "\t" +
            rs.getInt("Ar") + "\t" +
            rs.getString("Tulaj")
        	);
        }

    	} catch (SQLException e) {
    		System.out.println("Hiba a lekérdezés során: " + e.getMessage());
    	}
}
public static void Insert(String rendszam, String tipus, String szin, int kor, int ar, String tulaj) {
	String sql="INSERT INTO Auto"
}

        

      