import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner tastiera = new Scanner(System.in);
        Lampadina lampadina = new Lampadina(40);
        int scelta;

        do {

            System.out.println("\n-----------------------------");
            System.out.println("Scegli un'azione da eseguire");
            System.out.println("-----------------------------");

            System.out.println("1 - Accendi lampadina");
            System.out.println("2 - Spegni lampadina");
            System.out.println("3 - Aumenta illuminazione");
            System.out.println("4 - Diminuisci illuminazione");
            System.out.println("5 - Cambia colore");
            System.out.println("6 - Cambia nome");
            System.out.println("7 - Visualizza lampadina");
            System.out.println("0 - Esci");

            System.out.print("\nScelta: ");
            scelta = tastiera.nextInt();

            tastiera.nextLine();

            switch (scelta) {

                case 1:
                    lampadina.accendi();
                    System.out.println("Lampadina accesa.");
                    break;

                case 2:
                    lampadina.spegni();
                    System.out.println("Lampadina spenta.");
                    break;

                case 3:
                    lampadina.aumentaIlluminazione();
                    System.out.println("Illuminazione aumentata.");
                    break;

                case 4:
                    lampadina.diminuisciIlluminazione();
                    System.out.println("Illuminazione diminuita.");
                    break;

                case 5:
                    System.out.print("Inserisci il nuovo colore: ");
                    String colore = tastiera.nextLine();

                    lampadina.setColore(colore);
                    break;

                case 6:
                    System.out.print("Inserisci il nuovo nome: ");
                    String nome = tastiera.nextLine();

                    lampadina.setNome(nome);
                    break;

                case 7:
                    System.out.println(lampadina);
                    break;

                case 0:
                    System.out.println("Programma terminato.");
                    break;

                default:
                    System.out.println("Scelta non valida.");
            }

        } while (scelta != 0);

        tastiera.close();
    }
}

