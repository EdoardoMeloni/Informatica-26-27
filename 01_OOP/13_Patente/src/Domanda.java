public class Domanda {
    private String testo;
    private int valore;
    private Risposta [] risposte;
    private int rispostaData;

    public Domanda (String t, Risposta [] r) {
        this.testo = t;
        this.risposte = new Risposta[4];
        risposte = r.clone();
        this.valore = 1;
    }

    public Domanda (Domanda d) {
        this.testo = d.testo;
        this.valore = d.valore;
        this.rispostaData = -1;
        this.risposte = d.risposte.clone();
    }

    public boolean rispondi (int k) {
        if (this.risposte[k].isCorretta()){
            this.rispostaData = k;
            return true;
        }
        this.rispostaData = k;
        return false;
    }

    public void setValore(int valore) {
        if (valore > 0){
            this.valore = valore;
        }
    }

    public int getValore() {
        return valore;
    }

    public boolean completata () {
        if (rispostaData != -1){
            return true;
        }
        return false;
    }

    public int getPunteggio () {
        if (rispondi (rispostaData)) {
            return valore;
        }
        else if (!completata()){
            return -1;
        }
        return 0;
    }

    public String getRispostaCorretta () {
        for (int i = 0; i < risposte.length; i++){
            if (risposte[i].isCorretta()){
                return risposte[i].getTestoRisposta();
            }
        }
        return "nessuna risposta corretta";
    }

   public String getRispostaData (){
        return risposte[rispostaData].getTestoRisposta();
   }

   @Override
    public String toString () {
        String s = testo + "\n";
       for (int i = 0; i < risposte.length ; i++) {
           s += risposte[i].getTestoRisposta() + "\n";
       }
       return s;
   }


}
