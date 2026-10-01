import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci nome: ");
        String nome = scanner.nextLine();

        System.out.print("Inserisci cognome: ");
        String cognome = scanner.nextLine();

        System.out.print("Inserisci codice conto: ");
        String codice = scanner.nextLine();

        Contocorrente conto = new Contocorrente(nome, cognome, codice);

        int scelta;

        do {

            System.out.println("\n--- MENU CONTO CORRENTE ---");
            System.out.println("1. Deposita");
            System.out.println("2. Preleva");
            System.out.println("3. Visualizza saldo");
            System.out.println("4. Visualizza codice");
            System.out.println("5. Visualizza nominativo");
            System.out.println("6. Visualizza conto");
            System.out.println("0. Esci");

            System.out.print("Scelta: ");
            scelta = scanner.nextInt();

            switch (scelta) {

                case 1:
                    System.out.print("Quanto vuoi depositare? ");
                    double deposito = scanner.nextDouble();

                    System.out.println(
                            "Saldo: " + conto.deposita(deposito)
                    );
                    break;

                case 2:
                    System.out.print("Quanto vuoi prelevare? ");
                    double prelievo = scanner.nextDouble();

                    System.out.println(
                            "Saldo: " + conto.preleva(prelievo)
                    );
                    break;

                case 3:
                    System.out.println(
                            "Saldo: " + conto.getSaldo()
                    );
                    break;

                case 4:
                    System.out.println(
                            "Codice: " + conto.getCodice()
                    );
                    break;

                case 5:
                    System.out.println(
                            "Nominativo: " + conto.getNominativo()
                    );
                    break;

                case 6:
                    System.out.println(conto);
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