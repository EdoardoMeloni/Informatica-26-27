import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner tastiera = new Scanner(System.in);

        System.out.print("Nome playlist: ");
        String nome = tastiera.nextLine();

        System.out.print("Numero di brani: ");
        int numeroBrani = tastiera.nextInt();

        Playlist playlist = new Playlist(nome, numeroBrani);

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
            System.out.println("0. Esci");

            System.out.print("Scelta: ");
            scelta = tastiera.nextInt();

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
                    System.out.println(
                            "Nome: " + playlist.getNome()
                    );
                    break;

                case 8:
                    System.out.println(
                            "Numero brani: " +
                                    playlist.getQuantiBrani()
                    );
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