package konyvtar;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Program indul...");

        if (!LoginKezelo.bejelentkezes()) {
            System.out.println("Kilepes...");
            return;
        }

        AdatbazisLetrehozo.tablakatLetrehoz();

        Scanner scanner = new Scanner(System.in);
        int valasztas;

        do {
            System.out.println("\n=== FO MENÜ ===");
            System.out.println("1 - Uj tag");
            System.out.println("2 - Tagok listazasa");
            System.out.println("3 - Kereses nev alapjan");
            System.out.println("4 - Modositas");
            System.out.println("5 - Torles");
            System.out.println("6 - Uj kolcsonzes");
            System.out.println("7 - Kolcsonzesek listazasa");
            System.out.println("8 - Kapcsolt kolcsonzesek");
            System.out.println("0 - Kilepes");

            System.out.print("Valasztas: ");
            valasztas = scanner.nextInt();
            scanner.nextLine();

            switch (valasztas) {

                case 1:
                    System.out.print("Nev: ");
                    String nev = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Szuletesi datum: ");
                    String birth = scanner.nextLine();

                    System.out.print("Csatlakozas datum: ");
                    String join = scanner.nextLine();

                    System.out.print("Tagsagi dij: ");
                    double fee = scanner.nextDouble();
                    scanner.nextLine();

                    TagKezelo.ujTagHozzaadas(nev, email, birth, join, fee);
                    break;

                case 2:
                    TagKezelo.tagokListazasa();
                    break;

                case 3:
                    System.out.print("Keresett nev: ");
                    String keres = scanner.nextLine();
                    TagKezelo.tagKeresesNevAlapjan(keres);
                    break;

                case 4:
                    System.out.print("Modositando ID: ");
                    int modId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Uj nev: ");
                    String ujNev = scanner.nextLine();

                    System.out.print("Uj email: ");
                    String ujEmail = scanner.nextLine();

                    System.out.print("Uj szuletesi datum: ");
                    String ujBirth = scanner.nextLine();

                    System.out.print("Uj csatlakozas datum: ");
                    String ujJoin = scanner.nextLine();

                    System.out.print("Uj dij: ");
                    double ujFee = scanner.nextDouble();
                    scanner.nextLine();

                    TagKezelo.tagModositasa(modId, ujNev, ujEmail, ujBirth, ujJoin, ujFee);
                    break;

                case 5:
                    System.out.print("Torolendo ID: ");
                    int torId = scanner.nextInt();
                    scanner.nextLine();

                    TagKezelo.tagTorlese(torId);
                    break;

                case 6:
                    System.out.print("Tag ID: ");
                    int memberId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Konyv cime: ");
                    String book = scanner.nextLine();

                    System.out.print("Kolcsonzes datuma: ");
                    String loan = scanner.nextLine();

                    System.out.print("Hatarido: ");
                    String due = scanner.nextLine();

                    System.out.print("Visszahozas datum (ha nincs, hagyd uresen): ");
                    String ret = scanner.nextLine();

                    System.out.print("Buntetes osszeg: ");
                    double fine = scanner.nextDouble();
                    scanner.nextLine();

                    KolcsonzesKezelo.ujKolcsonzesHozzaadas(memberId, book, loan, due, ret, fine);
                    break;

                case 7:
                    KolcsonzesKezelo.kolcsonzesekListazasa();
                    break;

                case 8:
                    KolcsonzesKezelo.kapcsoltKolcsonzesekListazasa();
                    break;

                case 0:
                    System.out.println("Kilepes...");
                    break;

                default:
                    System.out.println("Ervenytelen valasztas!");
            }

        } while (valasztas != 0);

        System.out.println("Program vege.");
    }
}