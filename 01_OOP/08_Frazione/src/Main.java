
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        System.out.println("\n=== MENU FRAZIONI ===");
        System.out.print("Numeratore prima frazione: ");
        int n1 = input.nextInt();
        System.out.print("Denominatore prima frazione: ");
        int d1 = input.nextInt();
        System.out.print("Numeratore seconda frazione: ");
        int n2 = input.nextInt();
        System.out.print("Denominatore seconda frazione: ");
        int d2 = input.nextInt();

        Frazione a = new Frazione(n1, d1);
        Frazione b = new Frazione(n2, d2);

        int scelta;

        do {
            System.out.println("--- ---");
            System.out.println("Prima frazione: " + a);
            System.out.println("Seconda frazione: " + b);
            System.out.println("1. Somma");
            System.out.println("2. Differenza");
            System.out.println("3. Prodotto");
            System.out.println("4. Quoziente");
            System.out.println("5. Confronta frazioni");
            System.out.println("6. Converti in double");
            System.out.println("7. Modifica prima frazione");
            System.out.println("8. Modifica seconda frazione");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");

            scelta = input.nextInt();

            switch (scelta) {
                case 1:
                    System.out.println("Risultato: " + a.somma(b));
                    break;

                case 2:
                    System.out.println("Risultato: " + a.differenza(b));
                    break;

                case 3:
                    System.out.println("Risultato: " + a.prodotto(b));
                    break;

                case 4:
                    if (b.getNumeratore() == 0) {
                        System.out.println("Impossibile dividere per zero");
                    } else {
                        System.out.println("Risultato: " + a.quoziente(b));
                    }
                    break;

                case 5:
                    System.out.println("Sono uguali? " + a.equals(b));
                    break;

                case 6:
                    System.out.println("Prima: " + a.toDouble());
                    System.out.println("Seconda: " + b.toDouble());
                    break;

                case 7:
                    System.out.print("Nuovo numeratore: ");
                    a.setNumeratore(input.nextInt());

                    System.out.print("Nuovo denominatore: ");
                    a.setDenominatore(input.nextInt());
                    break;

                case 8:
                    System.out.print("Nuovo numeratore: ");
                    b.setNumeratore(input.nextInt());

                    System.out.print("Nuovo denominatore: ");
                    b.setDenominatore(input.nextInt());
                    break;

                case 0:
                    System.out.println("Programma terminato");
                    break;

                default:
                    System.out.println("Scelta non valida");
            }

        } while (scelta != 0);

        input.close();
    }
}
