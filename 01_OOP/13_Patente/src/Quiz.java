public class Quiz {
    private String titoloquiz;
    private Domanda[] domande;
    private final int maxDomande = 100;
    private int numeroDomande;

    public Quiz(String s) {
        this.titoloquiz = s;
        this.domande = new Domanda[maxDomande];
        this.numeroDomande = 0;
    }

    public Quiz(Quiz q) {
        if (q == null) {
            throw new IllegalArgumentException("Il quiz da copiare non può essere null");
        }

        this.titoloquiz = q.titoloquiz;
        this.domande = new Domanda[maxDomande];
        this.numeroDomande = q.numeroDomande;
        for (int i = 0; i < numeroDomande; i++) {
            this.domande[i] = new Domanda(q.domande[i]);
        }
    }

    public void add(Domanda d) {
        if (d == null) {
            throw new IllegalArgumentException("La domanda non può essere null");
        }
        if (numeroDomande == maxDomande) {
            throw new IllegalStateException("Il quiz può contenere al massimo 100 domande");
        }

        domande[numeroDomande] = d;
        numeroDomande++;
    }

    public int getQuanteDomande() {
        return numeroDomande;
    }

    public int getQuanteRisposte() {
        int contatore = 0;
        for (int i = 0; i < numeroDomande; i++) {
            if (domande[i].completata()) {
                contatore++;
            }
        }
        return contatore;
    }

    public int[] getDomandeNonDate() {
        int quante = numeroDomande - getQuanteRisposte();
        int[] nonDate = new int[quante];
        int posizione = 0;

        for (int i = 0; i < numeroDomande; i++) {
            if (!domande[i].completata()) {
                nonDate[posizione] = i + 1;
                posizione++;
            }
        }
        return nonDate;
    }

    public Domanda getDomanda(int indice) {
        if (indice < 1 || indice > numeroDomande) {
            return null;
        }
        return domande[indice - 1];
    }

    public int getTotale() {
        int totale = 0;
        for (int i = 0; i < numeroDomande; i++) {
            totale += domande[i].getValore();
        }
        return totale;
    }

    public int getPunteggio() {
        int punteggio = 0;
        for (int i = 0; i < numeroDomande; i++) {
            int valore = domande[i].getPunteggio();
            if (valore != -1) {
                punteggio += valore;
            }
        }
        return punteggio;
    }

    @Override
    public String toString() {
        return "Quiz: " + titoloquiz + "\n" +
                "Numero domande: " + numeroDomande + "\n" +
                "Punteggio totale: " + getTotale() + " punti";
    }
}
