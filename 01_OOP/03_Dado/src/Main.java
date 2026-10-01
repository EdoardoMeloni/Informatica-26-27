import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Dado dado = new Dado();
        int scelta;

        do {

            System.out.println("\n--- MENU DADO ---");
            System.out.println("1. Crea dado da 6 facce");
            System.out.println("2. Crea dado con numero di facce scelto");
            System.out.println("3. Lancia il dado");
            System.out.println("4. Visualizza il dado");
            System.out.println("0. Esci");

            System.out.print("Scelta: ");
            scelta = scanner.nextInt();

            switch (scelta) {

                case 1:
                    dado = new Dado();
                    System.out.println("Creato un dado da 6 facce.");
                    break;

                case 2:
                    System.out.print("Inserisci il numero di facce: ");
                    int faccie = scanner.nextInt();

                    dado = new Dado(faccie);

                    System.out.println("Dado creato.");
                    break;

                case 3:
                    System.out.println("È uscito: " + dado.lancio());
                    break;

                case 4:
                    System.out.println(dado);
                    break;

                case 0:
                    System.out.println("Programma terminato.");
                    break;

                default:
                    System.out.println("Scelta non valida.");
            }

        } while (scelta != 0);

        scanner.close();
    }
}