public class Domanda {
    private String testo;
    private int valore;
    private Risposta[] risposte;
    private int rispostaData;

    public Domanda(String t, Risposta[] r) {
        this.testo = t;
        this.valore = 1;
        this.rispostaData = -1;

        if (r == null || r.length != 4) {
            throw new IllegalArgumentException("Servono esattamente 4 risposte");
        }

        this.risposte = new Risposta[4];

        for (int i = 0; i < 4; i++) {
            this.risposte[i] = new Risposta(r[i]);
        }
    }

    public Domanda(Domanda d) {
        this.testo = d.testo;
        this.valore = d.valore;
        this.rispostaData = -1;
        this.risposte = new Risposta[4];

        for (int i = 0; i < 4; i++) {
            this.risposte[i] = new Risposta(d.risposte[i]);
        }
    }

    public boolean rispondi(int k) {
        if (k < 1 || k > 4) {
            return false;
        }

        this.rispostaData = k - 1;

        return this.risposte[rispostaData].isCorretta();
    }

    public void setValore(int valore) {
        if (valore > 0) {
            this.valore = valore;
        }
    }

    public int getValore() {
        return valore;
    }

    public boolean completata() {
        return rispostaData != -1;
    }

    public int getPunteggio() {
        if (!completata()) {
            return -1;
        }

        if (risposte[rispostaData].isCorretta()) {
            return valore;
        }

        return 0;
    }

    public String getRispostaCorretta() {
        for (int i = 0; i < risposte.length; i++) {
            if (risposte[i].isCorretta()) {
                return risposte[i].getTestoRisposta();
            }
        }

        return "nessuna risposta corretta";
    }

    public String getRispostaData() {
        if (!completata()) {
            return "nessuna risposta data";
        }

        return risposte[rispostaData].getTestoRisposta();
    }

    @Override
    public String toString() {
        String s = testo + "\n";

        for (int i = 0; i < risposte.length; i++) {
            s += risposte[i].getTestoRisposta() + "\n";
        }

        return s;
    }
}