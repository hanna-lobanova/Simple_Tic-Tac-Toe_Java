import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lese die Dimensionen des Arrays
        int n = scanner.nextInt(); // Zeilen
        int m = scanner.nextInt(); // Spalten
        scanner.nextLine(); // Entfernt den Zeilenumbruch nach den Eingaben

        // Initialisiere das 2D-Array
        String[][] twoDimArray = new String[n][m];

        // Lese das ursprüngliche Array
        for (int i = 0; i < n; i++) {
            twoDimArray[i] = scanner.nextLine().split(" ");
        }

        // Rotierte das Array und gebe es aus
        for (int j = 0; j < m; j++) { // Iteriere über die Spalten
            for (int i = n - 1; i >= 0; i--) { // Iteriere über die Zeilen rückwärts
                System.out.print(twoDimArray[i][j] + " ");
            }
            System.out.println(); // Zeilenumbruch für die nächste Zeile
        }
    }
}
