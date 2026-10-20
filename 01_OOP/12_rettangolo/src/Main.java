import java.util.Scanner;
public class Main {
    public static Punto creaPunto(Scanner in) {
        double x = in.nextDouble();
        double y = in.nextDouble();
        return new Punto(x, y);
    }

    public static Rettangolo creaRettangolo(Scanner in) {
        System.out.println("Inserisci x e y del primo punto:");
        Punto p1 = creaPunto(in);
        System.out.println("Inserisci x e y del secondo punto:");
        Punto p2 = creaPunto(in);
        return new Rettangolo(p1, p2);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Rettangolo r1 = null;
        Rettangolo r2 = null;

        System.out.println("-------MENU-------");
        System.out.println("0. per uscire");
        System.out.println("1. per definire i rettangoli r1 e r2");
        System.out.println("2. per visualizzare le coordinate");
        System.out.println("3. per calcolare i perimetri");
        System.out.println("4. per calcolare le aree");
        System.out.println("5. per traslare un rettangolo");
        System.out.println("6. per verificare se r2 è contenuto in r1");
        int scelta = in.nextInt();

        while (scelta > 0) {
            if (scelta == 1) {
                System.out.println("--- CREAZIONE R1 ---");
                r1 = creaRettangolo(in);
                System.out.println("--- CREAZIONE R2 ---");
                r2 = creaRettangolo(in);
            }
            if (scelta >= 2 && scelta <= 6 && (r1 == null || r2 == null)) {
                System.out.println("Errore! Devi prima creare i rettangoli premendo 1.");
            } else {
                if (scelta == 2) {
                    System.out.println("Coordinate r1: " + r1);
                    System.out.println("Coordinate r2: " + r2);
                }
                if (scelta == 3) {
                    System.out.println("Perimetro r1: " + r1.calcolaPerimetro());
                    System.out.println("Perimetro r2: " + r2.calcolaPerimetro());
                }
                if (scelta == 4) {
                    System.out.println("Area r1: " + r1.calcolaArea());
                    System.out.println("Area r2: " + r2.calcolaArea());
                }
                if (scelta == 5) {
                    System.out.println("Quale vuoi traslare? (1 per r1, 2 per r2):");
                    int quale = in.nextInt();
                    System.out.println("Inserisci dx e dy:");
                    double dx = in.nextDouble();
                    double dy = in.nextDouble();
                    // MODIFICATO: Assegniamo il nuovo rettangolo ritornato dal metodo
                    if (quale == 1) {
                        r1 = r1.effettuatrasla(dx, dy);
                        System.out.println("Rettangolo r1 aggiornato con la traslazione.");
                    }
                    if (quale == 2) {
                        r2 = r2.effettuatrasla(dx, dy);
                        System.out.println("Rettangolo r2 aggiornato con la traslazione.");
                    }
                }
                if (scelta == 6) {
                    if (r1.contenido(r2)) {
                        System.out.println("r2 è contenuto in r1");
                    } else {
                        System.out.println("r2 NON è contenuto in r1");
                    }
                }
            }

            System.out.println("-------MENU-------");
            System.out.println("0. per uscire");
            System.out.println("1. per definire i rettangoli r1 e r2");
            System.out.println("2. per visualizzare le coordinate");
            System.out.println("3. per calcolare i perimetri");
            System.out.println("4. per calcolare le aree");
            System.out.println("5. per traslare un rettangolo");
            System.out.println("6. per verificare se r2 è contenuto in r1");
            scelta = in.nextInt();
        }
    }
}