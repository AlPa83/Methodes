import java.util.Scanner;

public class Job02 {
    public static void bonjour(boolean jour) {
        if (jour) {
            System.out.println("Bonjour");
        } else {
            System.out.println("Bonsoir");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int heure = -1;

        // Boucle jusqu'à ce qu'une heure valide soit entrée
        while (true) {
            System.out.print("Quelle heure est-il ? (entrez un nombre entre 0 et 24) : ");

            // Vérifie si l'entrée est un entier
            if (scanner.hasNextInt()) {
                heure = scanner.nextInt();

                // Vérifie si l'heure est valide
                if (heure >= 0 && heure <= 24) {
                    break; // Sort de la boucle si valide
                } else {
                    System.out.println("Erreur : veuillez entrer un nombre entre 0 et 24.");
                }
            } else {
                System.out.println("Erreur : veuillez entrer un nombre valide.");
                scanner.next();
            }
        }

        boolean jour = (heure >= 4 && heure < 19); // Jour entre 4h et 19h
        bonjour(jour);

        scanner.close();
    }
}
