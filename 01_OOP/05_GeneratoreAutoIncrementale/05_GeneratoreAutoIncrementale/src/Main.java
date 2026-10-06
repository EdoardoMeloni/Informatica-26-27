import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner tastiera = new Scanner(System.in);

        System.out.print("Inserisci il prefisso: ");
        String prefisso = tastiera.nextLine();

        System.out.print("Inserisci il numero di cifre: ");
        int cifre = tastiera.nextInt();

        GeneratoreAutoIncrementale generatore =
                new GeneratoreAutoIncrementale(prefisso, cifre);

        int scelta;

        do {

            System.out.println("----");
            System.out.println("1. Genera nuovo codice");
            System.out.println("2. Visualizza generatore");
            System.out.println("0. Esci");

            System.out.print("Scelta:");
            scelta = tastiera.nextInt();

            switch (scelta) {

                case 1:
                    System.out.println(generatore.genera());
                    break;

                case 2:
                    System.out.println(generatore);
                    break;

                case 0:
                    System.out.println("Programma terminato");
                    break;

                default:
                    System.out.println("Scelta non valida");
            }

        } while (scelta != 0);
    }
}