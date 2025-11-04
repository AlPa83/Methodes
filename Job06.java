import java.util.Scanner;

public class Job06 {

    // Méthode leetSpeak
    public static String leetSpeak(String str) {
        String result = "";
        for (char c : str.toCharArray()) {
            switch (c) {
                case 'A': case 'a': result += '4'; break;
                case 'B': case 'b': result += '8'; break;
                case 'E': case 'e': result += '3'; break;
                case 'G': case 'g': result += '6'; break;
                case 'L': case 'l': result += '1'; break;
                case 'S': case 's': result += '5'; break;
                case 'T': case 't': result += '7'; break;
                default: result += c; // on ne change pas les autres caractères
            }
        }
        return result; // on retourne la chaine transformée
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez une phrase : ");
        String texte = scanner.nextLine();

        System.out.println("Leet Speak : " + leetSpeak(texte));
        scanner.close();
    }
}
