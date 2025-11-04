import java.util.Scanner;

public class Job02 {
    public static void bonjour(boolean jour) {
        if (jour) {
            System.out.println("Bonjour");
        } else {
            System.out.println("Bonsoir");
        }
    }

    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quelle heure est il ? (entrez un nombre entre 0 et 23) : ");
        int heure = scanner.nextInt();

        boolean jour = (heure >= 4 && heure < 19); // Jour entre 4h et 19h
        bonjour(jour);

        scanner.close();
    }
}
