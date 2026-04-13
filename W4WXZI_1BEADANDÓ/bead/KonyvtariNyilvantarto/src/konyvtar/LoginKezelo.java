package konyvtar;

import java.util.Scanner;

public class LoginKezelo {

    public static boolean bejelentkezes() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== BEJELENTKEZÉS ===");

        System.out.print("Felhasznalonev: ");
        String felhasznalonev = scanner.nextLine();

        System.out.print("Jelszo: ");
        String jelszo = scanner.nextLine();

        if (felhasznalonev.equals("admin") && jelszo.equals("1234")) {
            System.out.println("Sikeres bejelentkezes!");
            return true;
        } else {
            System.out.println("Hibas felhasznalonev vagy jelszo!");
            return false;
        }
    }
}