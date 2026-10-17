public class Cassaforte {
    private boolean aperta;
    private int codice;


    public Cassaforte(int combinazione) {
        if (combinazione > 999999 || combinazione <= 0){
            this.codice = 1;
        } else {
            this.codice = combinazione;
        }
        aperta = false;
    }

    public boolean isAperta() {
        if (this.aperta){
            return true;
        }
        return false;
    }
    public void chiudi () {
        aperta = false;
    }
    public boolean apri (int tentativo) {
        if (tentativo == this.codice && !aperta){
            aperta = true;
            return true;
        }
        return false;
    }
    public boolean cambiacombinazione (int Attuale, int Nuova){
        if (aperta && Attuale == this.codice){
            if (Nuova <= 999999 && Nuova > 0) {
                this.codice = Nuova;
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        if (aperta) {
            return "la cassaforte è aperta";
        } else {
            return "la cassaforte è chiusa";
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cassaforte c = (Cassaforte) obj;
        return this.aperta == c.aperta && this.codice == c.codice;
    }
}