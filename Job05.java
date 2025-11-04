import java.util.Scanner;

public class Job05 {

    // On compte le nombre d'occurrences
    public static int occurrences(String str, char caractere) {
        int count = 0;
        for (char c : str.toCharArray()) {
            count += (c == caractere) ? 1 : 0;
        }
        return count;
    }

    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // On demande à l'utilisateur de saisir texte
        System.out.print("Entrez une phrase : ");
        String texte = scanner.nextLine();

        // On demande à l'utilisateur de saisir un caractère
        System.out.print("Entrez le caractère à compter : ");
        char lettre = scanner.next().charAt(0); // On prend le premier caractère saisi

        // On appelle la méthode occurrences
        int resultat = occurrences(texte, lettre);

        System.out.println("Le caractère '" + lettre + "' apparaît " + resultat + " fois.");

        scanner.close();
    }
}
