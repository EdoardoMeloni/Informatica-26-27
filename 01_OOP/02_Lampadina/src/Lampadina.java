public class Lampadina {
    private int potenza;
    private String colore;
    private int intensita;
    private boolean accesa;
    private String nome;

    public Lampadina(int potenza){
        this.potenza = potenza;
        if (this.potenza < 1 || this.potenza > 100) {
            this.potenza = 10;
        }
        this.colore = "bianco";
        this.intensita = 50;
        this.accesa = false;
        this.nome = "";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getColore() {
        return colore;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

    public Lampadina(Lampadina l) {
        this.potenza = l.potenza;
        this.colore = l.colore;
        this.intensita = l.intensita;
        this.accesa = l.accesa;
        this.nome = l.nome;
    }

    public void accendi(){
        this.accesa = true;
    }

    public void spegni(){
        this.accesa = false;
    }

    public void aumentaLuminosita(){
        this.intensita +=10;
        if (this.intensita > 100){
            this.intensita = 100;
        }
    }

    public void diminuisciLuminosita(){
        this.intensita -=10;
        if (this.intensita <= 0){
            this.intensita = 0;
        }
    }

    @Override
    public String toString() {
        return "Lampadina{" +
                "potenza = " + potenza +
                ", colore = '" + colore + '\'' +
                ", intensita = " + intensita +
                ", accesa = " + accesa +
                ", nome = '" + nome + '\'' +
                '}';
    }
}