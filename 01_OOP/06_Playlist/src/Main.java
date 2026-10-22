
import java.util.Scanner;
import java.time.Duration;

public class Main {

    public static void main(String[] args) {

        Scanner tastiera = new Scanner(System.in);

        System.out.print("Nome playlist: ");
        String nome = tastiera.nextLine();

        Playlist playlist = new Playlist(nome, new Canzone[0]);

        int scelta;

        do {
            System.out.println("\n--- PLAYLIST ---");
            System.out.println("1. Play");
            System.out.println("2. Pause");
            System.out.println("3. Stop");
            System.out.println("4. Brano successivo");
            System.out.println("5. Brano precedente");
            System.out.println("6. Visualizza playlist");
            System.out.println("7. Nome playlist");
            System.out.println("8. Numero brani");
            System.out.println("9. Aggiungi canzone");
            System.out.println("10. Visualizza canzone");
            System.out.println("11. Durata totale");
            System.out.println("12. Visualizza tutte le canzoni");
            System.out.println("0. Esci");

            System.out.print("Scelta: ");
            scelta = tastiera.nextInt();
            tastiera.nextLine();

            switch (scelta) {

                case 1:
                    playlist.play();
                    break;

                case 2:
                    playlist.pause();
                    break;

                case 3:
                    playlist.stop();
                    break;

                case 4:
                    playlist.branoSuccessivo();
                    break;

                case 5:
                    playlist.branoPrecedente();
                    break;

                case 6:
                    System.out.println(playlist);
                    break;

                case 7:
                    System.out.println("Nome: " + playlist.getNome());
                    break;

                case 8:
                    System.out.println("Numero brani: " + playlist.getQuantiBrani());
                    break;

                case 9:
                    System.out.print("Titolo: ");
                    String titolo = tastiera.nextLine();

                    System.out.print("Artista: ");
                    String artista = tastiera.nextLine();

                    System.out.print("Minuti: ");
                    int minuti = tastiera.nextInt();

                    System.out.print("Secondi: ");
                    int secondi = tastiera.nextInt();
                    tastiera.nextLine();

                    if (minuti < 0 || secondi < 0 || secondi >= 60) {
                        System.out.println("Durata non valida");
                        break;
                    }

                    Duration durata = Duration.ofMinutes(minuti).plusSeconds(secondi);

                    Canzone nuova = new Canzone(titolo, durata, artista);

                    if (playlist.add(nuova)) {
                        System.out.println("Canzone aggiunta");
                    } else {
                        System.out.println("Impossibile aggiungere la canzone");
                    }
                    break;

                case 10:
                    System.out.print("Numero canzone: ");
                    int numero = tastiera.nextInt();
                    tastiera.nextLine();

                    Canzone canzone = playlist.getCanzone(numero);

                    if (canzone != null) {
                        System.out.println(canzone);
                    } else {
                        System.out.println("Canzone non trovata");
                    }
                    break;

                case 11:
                    Duration totale = playlist.durataTotale();

                    System.out.println("Durata totale: " +
                            totale.toMinutes() + " minuti e " +
                            totale.toSeconds() % 60 + " secondi");
                    break;

                case 12:
                    for (int i = 1; i <= playlist.getQuantiBrani(); i++) {
                        System.out.println("\nCanzone " + i);
                        System.out.println(playlist.getCanzone(i));
                    }
                    break;

                case 0:
                    System.out.println("Programma terminato");
                    break;

                default:
                    System.out.println("Scelta non valida");
            }

        } while (scelta != 0);

        tastiera.close();
    }
}
