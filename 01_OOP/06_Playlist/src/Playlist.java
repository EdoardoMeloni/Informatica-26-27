
import java.time.Duration;

public class Playlist {

    private String nome;
    private int quantiBrani;
    private int branoCorrente;
    private String stato;

    private boolean stopGiaChiamato;
    private Canzone[] canzoni;

    public Playlist(String nome, Canzone[] brani) {
        this.nome = nome;
        canzoni = new Canzone[100];
        quantiBrani = 0;

        if (brani != null) {
            for (int i = 0; i < brani.length && quantiBrani < 100; i++) {
                if (brani[i] != null) {
                    canzoni[quantiBrani] = brani[i];
                    quantiBrani++;
                }
            }
        }

        branoCorrente = 1;
        stato = "STOP";
        stopGiaChiamato = false;
    }

    public Playlist(Playlist altra) {
        this.nome = altra.nome;
        this.quantiBrani = altra.quantiBrani;
        this.branoCorrente = altra.branoCorrente;
        this.stato = altra.stato;
        this.stopGiaChiamato = altra.stopGiaChiamato;
        this.canzoni = altra.canzoni.clone();
    }

    public String getNome() {
        return nome;
    }

    public int getQuantiBrani() {
        return quantiBrani;
    }

    public Canzone getCanzone(int numero) {
        if (numero < 1 || numero > quantiBrani) {
            return null;
        }

        return canzoni[numero - 1];
    }

    public boolean add(Canzone canzone) {
        if (quantiBrani >= 100 || canzone == null) {
            return false;
        }

        canzoni[quantiBrani] = canzone;
        quantiBrani++;

        return true;
    }

    public Duration durataTotale() {
        Duration totale = Duration.ZERO;

        for (int i = 0; i < quantiBrani; i++) {
            totale = totale.plus(canzoni[i].getDurata());
        }

        return totale;
    }

    public void play() {
        stato = "PLAY";
        stopGiaChiamato = false;
    }

    public void pause() {
        if (!stato.equals("STOP")) {
            stato = "PAUSE";
        }

        stopGiaChiamato = false;
    }

    public void stop() {
        if (stopGiaChiamato) {
            branoCorrente = 1;
        }

        stato = "STOP";
        stopGiaChiamato = true;
    }

    public void branoSuccessivo() {
        if (quantiBrani == 0) {
            return;
        }

        if (branoCorrente == quantiBrani) {
            branoCorrente = 1;
        } else {
            branoCorrente++;
        }
    }

    public void branoPrecedente() {
        if (quantiBrani == 0) {
            return;
        }

        if (branoCorrente == 1) {
            branoCorrente = quantiBrani;
        } else {
            branoCorrente--;
        }
    }

    @Override
    public String toString() {
        String risultato = "Playlist " + nome +
                ", " + quantiBrani +
                " brani, in " + stato;

        if (quantiBrani > 0) {
            Canzone canzone = getCanzone(branoCorrente);

            risultato += " sul brano " +
                    canzone.getTitolo() +
                    " di " + canzone.getArtista();
        } else {
            risultato += ", nessun brano presente";
        }

        return risultato;
    }
}
