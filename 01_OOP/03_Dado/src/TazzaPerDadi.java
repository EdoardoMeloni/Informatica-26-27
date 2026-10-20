public class TazzaPerDadi {
    private int nDadi;
    Dado[] dadi;

    public TazzaPerDadi(int N){
        //Indica quanti dadi vogliamo
        this.nDadi = N;
        //Crea il vettore, ma vuoto
        this.dadi = new Dado[this.nDadi];
        //Crea gli nDadi richiesti
        for (int i = 0; i < this.nDadi; i++) {
            this.dadi[i] = new Dado();
        }
    }

    public TazzaPerDadi(int N, int F){
        this.nDadi = N;
        this.dadi = new Dado[this.nDadi];
        for (int i = 0; i < N; i++) {
            this.dadi[i] = new Dado(F);
        }
    }

    public int lancia(){
        int somma = 0;
        for (int i = 0; i < this.nDadi; i++) {
            somma += this.dadi[i].lancia();
        }
        return somma;
    }

    public int getMinimo(){
        return this.nDadi;
    }

    public int getMassimo(){
        int massimo = 0;
        for (int i = 0; i < this.nDadi; i++) {
            massimo += this.dadi[i].getFacce();
        }
        return massimo;
    }

    @Override
    public String toString(){
        String s;
        s = "Dadi attualmente contenuti: " + this.nDadi + "\n";
        s += "Lista dei dadi: \n";
        for (int i = 0; i < this.nDadi; i++) {
            s += "- dado da " + this.dadi[i].getFacce() + "\n";
        }
        return s;
    }
}