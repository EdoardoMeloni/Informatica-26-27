public class Playlist {

    private String nome;
    private int quantiBrani;
    private int branoCorrente;
    private String stato;

    private boolean stopGiaChiamato;

    public Playlist(String nome, int quantiBrani) {
        this.nome = nome;
        this.quantiBrani = quantiBrani;

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
    }

    public String getNome() {
        return nome;
    }

    public int getQuantiBrani() {
        return quantiBrani;
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

        if (branoCorrente == quantiBrani) {
            branoCorrente = 1;
        } else {
            branoCorrente++;
        }
    }

    public void branoPrecedente() {

        if (branoCorrente == 1) {
            branoCorrente = quantiBrani;
        } else {
            branoCorrente--;
        }
    }

    @Override
    public String toString() {

        return "Playlist " + nome +
                ", " + quantiBrani +
                " brani, in " + stato +
                " sul brano " + branoCorrente;
    }
}