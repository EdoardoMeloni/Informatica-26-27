public class Contocorrente {

    private String nome;
    private String cognome;
    private String codice;
    private double saldo;

    public Contocorrente(String nome, String cognome, String codice) {
        this.nome = nome;
        this.cognome = cognome;
        this.codice = codice;
        this.saldo = 0;
    }

    public double preleva(double quantita) {

        if (quantita >= 0 && saldo - quantita >= 0) {
            saldo = saldo - quantita;
        }

        return saldo;
    }

    public double deposita(double quantita) {

        if (quantita >= 0) {
            saldo = saldo + quantita;
        }

        return saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getCodice() {
        return codice;
    }

    public String getNominativo() {
        return nome + " " + cognome;
    }

    @Override
    public String toString() {
        return "Correntista: " + getNominativo()
                + ", codice: " + codice
                + ", saldo: " + saldo + " euro";
    }
}