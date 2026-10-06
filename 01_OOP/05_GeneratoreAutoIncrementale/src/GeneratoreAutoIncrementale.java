public class GeneratoreAutoIncrementale {

    private String prefisso;
    private int cifre;
    private int ultimoValore;
    private int massimo;

    public GeneratoreAutoIncrementale(String prefisso, int cifre) {
        this.prefisso = prefisso;
        this.cifre = cifre;
        this.ultimoValore = 0;

        massimo = 1;

        for (int i = 0; i < cifre; i++) {
            massimo = massimo * 10;
        }

        massimo = massimo - 1;
    }

    public String genera() {

        if (ultimoValore >= massimo) {
            return "Codici esauriti";
        }

        ultimoValore++;

        String numero = String.format("%0" + cifre + "d", ultimoValore);

        return prefisso + numero;
    }

    @Override
    public String toString() {
        return "Prefisso: " + prefisso +
                " ultimo valore generato: " + ultimoValore;
    }
}