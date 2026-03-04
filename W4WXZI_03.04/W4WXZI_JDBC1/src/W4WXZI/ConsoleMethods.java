package W4WXZI;

import java.until.Scanner;

public class ConsoleMethods {

		private final java.util.Scanner scanner = new Scanner(System.in);
		public String readString(String message)
		{
			System.out.println(message);
			return scanner.nextLine().trim();
		}
		
		public int readInt(String message) {
			while (true) {
				
				System.out.println(message);
				String line =scanner.nextLine().trim();
				
				try {
					return Integer.parseInt(line);
				} catch (NumberFormatException e) {
					System.out.println("Hibás szám, próbáld újra!");
				}
			}
		}
}
