public class Risposta {
    private String testoRisposta;
    private int indice;
    private boolean corretta;

    public Risposta(String testoRisposta, boolean corretta) {
        this(testoRisposta, 0, corretta);
    }

    public Risposta(String testoRisposta, int indice, boolean corretta) {
        if (testoRisposta == null) {
            throw new IllegalArgumentException("Il testo della risposta non può essere null");
        }
        this.testoRisposta = testoRisposta;
        this.indice = indice;
        this.corretta = corretta;
    }

    public Risposta(Risposta r) {
        this(r.testoRisposta, r.indice, r.corretta);
    }

    public int getIndice() {
        return indice;
    }

    public String getTestoRisposta() {
        return testoRisposta;
    }

    public boolean isCorretta() {
        return corretta;
    }

    @Override
    public String toString() {
        if (indice > 0) {
            return indice + ") " + testoRisposta;
        }
        return testoRisposta;
    }
}
