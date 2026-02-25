package W4WXZI;

public class DbMethods {

	final static String url="C:\Users\Felhasználó\OneDrive\Asztali gép\SQLITE\autodb";
	
	public static void Register () {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found exception: " + e.getMessage());
		}
	}
	
	public static Connection Connect() {
		Connection conn =null;
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	public static void DisConnect (Connection conn){
		if(conn !=null) {
			try {
				conn.close();
			}
			catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public static void CommandExec(String command) {
		Connection conn =Connect();
		try {
			Statement s = conn.createStatement();
			s.execute(command);
		}
		cath (SQLException e) {
			System.out-println("Command: " + command);
			System.out.println(e.getMessage());
		}
		DisConnect(conn);
	}
	
	public static void ReadAllData() {
		String rendszam = " ";
		String tipus = " ";
		String szin = " ";
		String tulaj="";
		int kor=0;
		int ar=0;
		String sqlo = "SELECT Rendszam, Tipus, Szin, Kor, Ar, Tulaj FROM Auto";
		Connection conn=Connect();
		
		System.out.println("Autó tabke\n");
		
		try {
			Statement statement = conn.createStatement ();
			ResultSet resoult_set=statement.executeQuery(sqlp);
			while(resoult_set.next()) {
				rendszam=resoult_set.getString("Rendszam");
				tipus=resoult_set.getString("Tipus");
				szin=resoult_set.getString("Szin");ű
				kor=resoult_set.getString("Kor");
				ar=resoult_set.getString("Ar");
				tulaj=resoult_set.getString("Tulaj");
				System.out.println(
							rendszam + "\t" +
							tipus + "\t" +
							szin + "\t" +
							kor + "\t" +
							ar + "\t" +
							tulaj
							);
		}
			resoult_Set.close();
	}
		catch (SQLRxception e) {
			System.out.println(e.getMessage());
		}
		DisConnect(conn);
		}
}
