
import java.time.Duration;

public class TestPlaylist {

    public static void main(String[] args) {

        Canzone c1 = new Canzone("Suspicious Minds",
                Duration.ofMinutes(4).plusSeconds(22),
                "Elvis Presley");

        Canzone c2 = new Canzone("Yesterday",
                Duration.ofMinutes(2).plusSeconds(5),
                "The Beatles");

        Canzone c3 = new Canzone("Paint It Black",
                Duration.ofMinutes(3).plusSeconds(45),
                "The Rolling Stones");

        System.out.println("--- TEST CANZONE ---");
        System.out.println(c1);
        System.out.println(c1.getTitolo());
        System.out.println(c1.getDurata());
        System.out.println(c1.getArtista());

        Canzone[] brani = {c1, c2};

        Playlist playlist = new Playlist("Rock anni sessanta", brani);

        System.out.println("\n--- TEST PLAYLIST ---");
        System.out.println(playlist);
        System.out.println(playlist.getNome());
        System.out.println(playlist.getQuantiBrani());
        System.out.println(playlist.getCanzone(1));
        System.out.println(playlist.getCanzone(99));

        System.out.println("\nAggiunta: " + playlist.add(c3));
        System.out.println(playlist);

        System.out.println("\nDurata totale: " +
                playlist.durataTotale().toSeconds() + " secondi");

        playlist.play();
        System.out.println(playlist);

        playlist.branoSuccessivo();
        System.out.println(playlist);

        playlist.pause();
        System.out.println(playlist);

        playlist.branoPrecedente();
        System.out.println(playlist);

        playlist.stop();
        System.out.println(playlist);

        playlist.stop();
        System.out.println(playlist);

        Playlist copia = new Playlist(playlist);
        System.out.println("\nCopia: " + copia);

        System.out.println("\n--- TEST LIMITE 100 ---");

        Playlist piena = new Playlist("Piena", new Canzone[0]);

        for (int i = 0; i < 100; i++) {
            piena.add(c1);
        }

        System.out.println("Numero brani: " + piena.getQuantiBrani());
        System.out.println("Aggiunta numero 101: " + piena.add(c2));
    }
}
