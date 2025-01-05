package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean xWin, oWin, emptyCells;
        boolean win = false;
        char currentPlayer = 'X'; // Startspieler
        char[][] partsDim = new char[3][3];

        // Initialisiere das Spielfeld mit Leerzeichen
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                partsDim[i][j] = ' ';
            }
        }

        Scanner scanner = new Scanner(System.in);

        // Hauptspiel-Schleife
        do {
            print(partsDim); // Spielfeld anzeigen
            boolean validMove = false;

            // Eingabevalidierung
            while (!validMove) {
                System.out.println("Enter the coordinates: ");
                if (scanner.hasNextInt()) {
                    int n = scanner.nextInt();
                    int m = scanner.nextInt();
                    validMove = checkCoordinate(n, m, partsDim, currentPlayer);
                } else {
                    System.out.println("You should enter numbers!");
                    scanner.next(); // Ungültige Eingabe überspringen
                }
            }

            // Spielstatus überprüfen
            xWin = check(partsDim, 'X');
            oWin = check(partsDim, 'O');
            emptyCells = false;

            // Prüfe auf leere Zellen
            for (char[] row : partsDim) {
                for (char cell : row) {
                    if (cell == ' ') {
                        emptyCells = true;
                        break;
                    }
                }
                if (emptyCells) break;
            }

            // Überprüfe den Spielstatus
            if (xWin) {
                print(partsDim);
                System.out.println("X wins");
                win = true;
            } else if (oWin) {
                print(partsDim);
                System.out.println("O wins");
                win = true;
            } else if (!emptyCells) {
                print(partsDim);
                System.out.println("Draw");
                win = true;
            } else {
                // Spieler wechseln
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        } while (!win);
    }

    // Methode zur Überprüfung von Gewinnbedingungen
    public static boolean check(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            // Prüfe Zeilen und Spalten
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                    (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        // Prüfe Diagonalen
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    // Prüfe und aktualisiere Koordinaten
    public static boolean checkCoordinate(int n, int m, char[][] partsDim, char currentPlayer) {
        if (n < 1 || n > 3 || m < 1 || m > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        } else if (partsDim[n - 1][m - 1] == 'X' || partsDim[n - 1][m - 1] == 'O') {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        } else {
            partsDim[n - 1][m - 1] = currentPlayer; // Aktualisiere das Spielfeld mit dem aktuellen Spieler
            return true;
        }
    }

    // Spielfeld drucken
    public static void print(char[][] partsDim) {
        System.out.println("---------");
        for (int a = 0; a < 3; a++) {
            System.out.print("| ");
            for (int b = 0; b < 3; b++) {
                System.out.print(partsDim[a][b] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
}
