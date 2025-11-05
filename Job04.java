import java.util.Scanner;

public class Job04 {

    public static double calcule(double a, char operateur, double b) {
        switch (operateur) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return (b != 0) ? a / b : 0;
            case '%': return (b != 0) ? a % b : 0;
            default:
                // Cette partie ne devrait jamais être atteinte si la saisie est validée
                return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = 0, b = 0;
        char operateur = ' ';

        // Lecture du premier nombre avec validation
        while (true) {
            System.out.print("Entrez le premier nombre : ");
            if (scanner.hasNextDouble()) {
                a = scanner.nextDouble();
                break;
            } else {
                System.out.println("Erreur : veuillez entrer un nombre valide !");
                scanner.next();
            }
        }

        // Lecture de l'opérateur avec validation
        while (true) {
            System.out.print("Entrez un opérateur (+, -, *, /, %) : ");
            String input = scanner.next();
            if (input.length() == 1 && "+-*/%".contains(input)) {
                operateur = input.charAt(0);
                break;
            } else {
                System.out.println("Erreur : opérateur invalide !");
            }
        }

        // Lecture du deuxième nombre avec validation
        while (true) {
            System.out.print("Entrez le deuxième nombre : ");
            if (scanner.hasNextDouble()) {
                b = scanner.nextDouble();
                if ((operateur == '/' || operateur == '%') && b == 0) {
                    System.out.println("Erreur : division par zéro impossible !");
                } else {
                    break;
                }
            } else {
                System.out.println("Erreur : veuillez entrer un nombre valide !");
                scanner.next();
            }
        }

        System.out.println("Résultat : " + calcule(a, operateur, b));
        scanner.close();
    }
}
