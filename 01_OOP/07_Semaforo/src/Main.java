import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner tastiera = new Scanner(System.in);

        Semaforo semaforo = new Semaforo();

        int scelta;

        do {

            System.out.println("\n--- SEMAFORO ---");
            System.out.println("1. Accendi");
            System.out.println("2. Spegni");
            System.out.println("3. Toggle");
            System.out.println("4. Avanza");
            System.out.println("5. Controlla se acceso");
            System.out.println("6. Visualizza colore");
            System.out.println("7. Visualizza semaforo");
            System.out.println("0. Esci");

            System.out.print("Scelta: ");
            scelta = tastiera.nextInt();

            switch (scelta) {

                case 1:
                    semaforo.accendi();
                    break;

                case 2:
                    semaforo.spegni();
                    break;

                case 3:
                    semaforo.toggle();
                    break;

                case 4:
                    semaforo.avanza();
                    break;

                case 5:
                    System.out.println(
                            "Acceso: " + semaforo.isAcceso()
                    );
                    break;

                case 6:
                    System.out.println(
                            "Colore: " + semaforo.getColore()
                    );
                    break;

                case 7:
                    System.out.println(semaforo);
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