import java.util.Scanner;

public class Job07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            // Display main menu
            System.out.println("\n=== MENU DE TRANSFORMATIONS ===");
            System.out.println("1 - Gras (entoure les mots commençant par une majuscule de *)");
            System.out.println("2 - César (décalage personnalisable)");
            System.out.println("3 - Plateforme (ajoute _ aux mots finissant par 'me')");
            System.out.println("4 - Quitter");
            System.out.print("Votre choix : ");

            // Check if input is a valid integer
            if (!scanner.hasNextInt()) {
                System.out.println("Erreur : veuillez entrer un nombre valide !");
                scanner.nextLine();
                continue;
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 4) {
                System.out.println("Au revoir !");
                break; // exit program
            }

            if (choice < 1 || choice > 3) {
                System.out.println("Choix invalide !");
                continue; // return to menu
            }

            String text = "";
            if (choice == 2) {
                // Ask user for text containing only letters and spaces
                while (true) {
                    System.out.print("Entrez un texte (lettres et espaces seulement) : ");
                    text = scanner.nextLine();
                    if (text.matches("[a-zA-Z ]+")) {
                        break;
                    } else {
                        System.out.println("Erreur : le texte ne doit contenir que des lettres et des espaces !");
                    }
                }
            } else {
                System.out.print("Entrez un texte : ");
                text = scanner.nextLine();
            }

            String result = "";

            // Perform the selected transformation
            switch (choice) {
                case 1:
                    // Call Bold transformation
                    result = grasTransformation(text);
                    break;
                case 2:
                    int decalage;
                    // Ask for Caesar shift value
                    while (true) {
                        System.out.print("Entrez le décalage (nombre entier) : ");
                        if (scanner.hasNextInt()) {
                            decalage = scanner.nextInt();
                            scanner.nextLine();
                            break;
                        } else {
                            System.out.println("Erreur : veuillez entrer un nombre entier !");
                            scanner.nextLine();
                        }
                    }
                    // Apply Caesar transformation
                    result = cesarTransformation(text, decalage);
                    break;
                case 3:
                    // Apply Platform transformation
                    result = plateformeTransformation(text);
                    break;
            }

            // Display the transformed text
            System.out.println("\nTexte transformé : " + result);
        }

        scanner.close();
    }

    // Bold transformation: add asterisks around words starting with uppercase
    public static String grasTransformation(String text) {
        String[] words = text.split(" ");
        String result = "";
        int count = 0;

        for (String word : words) {
            if (!word.isEmpty() && Character.isUpperCase(word.charAt(0))) {
                result += "*" + word + "*";
            } else {
                result += word;
            }
            if (++count < words.length) result += " "; // Add space between words
        }

        return result;
    }

    // Caesar transformation: shift letters using for-each, keep others unchanged
    public static String cesarTransformation(String text, int decalage) {
        String result = "";

        for (char c : text.toCharArray()) {

            /* c >= 'A' && c <= 'Z' : on vérifie que c'est une lettre majuscule
            (c - 'A') : convertit le caractère en index de 0 à 25 ('A' → 0, 'B' → 1, … 'Z' → 25)
            + decalage : ajoute le décalage souhaité pour le chiffrement
            + 26 : assure que le résultat reste positif même si le décalage est négatif
            % 26 : utilise le modulo 26 pour boucler dans l’alphabet
            + 'A' : convertit l’index à nouveau en caractère majuscule */

            if (c >= 'A' && c <= 'Z') {
                c = (char) (((c - 'A' + decalage + 26) % 26) + 'A');
            } else if (c >= 'a' && c <= 'z') {
                c = (char) (((c - 'a' + decalage + 26) % 26) + 'a');
            }

            // Keep spaces and special characters unchanged
            result += c;
        }
        return result;
    }

/*    // Méthode 2 : transformation "César" alternative
    public static String cesarTransformation(String text, int decalage) {
        String result = "";
        int i = 0;

        do {
            char c = text.charAt(i);

            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                c = (char) ((c - base + decalage) % 26 + base);
            }

            result += c;
            i++;
        } while (i < text.length());

        return result;
    }

*/

    // Platform transformation: add underscore to words ending with "me" using do-while
    public static String plateformeTransformation(String text) {
        String[] array = text.split(" ");
        String result = "";
        int i = 0;

        if (array.length > 0) {
            do {
                String word = array[i]; // if array.length == 1, the word is processed.

                if (word.endsWith("me")) { // checks if the word ends with "me".
                                           // if so, the code adds an underscore after the word.
                    result += word + "_";
                } else {
                    result += word;
                }

                if (i < array.length - 1) {
                    result += " "; // adds space between words but not after the last word.
                                   // without this check, an extra space would appear at the end.
                }

                i++;
            } while (i < array.length);
        }

        return result;
    }
}
