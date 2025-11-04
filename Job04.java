import java.util.Scanner;

public class Job04 {

    public static double calcule(double a, char operateur, double b) {
        if (operateur == '+') return a + b;
        if (operateur == '-') return a - b;
        if (operateur == '*') return a * b;
        if (operateur == '/') return (b != 0) ? a / b : 0;
        if (operateur == '%') return a % b;

        System.out.println("Erreur : opérateur invalide !");
        return 0;
    }

    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le premier nombre : ");
        double a = scanner.nextDouble();

        System.out.print("Entrez un opérateur (+, -, *, /, %) : ");
        char operateur = scanner.next().charAt(0);

        System.out.print("Entrez le deuxième nombre : ");
        double b = scanner.nextDouble();

        System.out.println("Résultat : " + calcule(a, operateur, b));

        scanner.close();
    }
}
