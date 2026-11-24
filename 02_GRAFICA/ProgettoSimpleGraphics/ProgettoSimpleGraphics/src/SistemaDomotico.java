
public class SistemaDomotico {

    private Lampadina[] lampadine;
    private int numeroLampadine;
    private int massimoLampadine;

    public SistemaDomotico() {
        massimoLampadine = 100;
        lampadine = new Lampadina[100];
        numeroLampadine = 0;
    }

    public SistemaDomotico(int massimo) {

        if (massimo < 1) {
            massimo = 100;
        }

        massimoLampadine = massimo;
        lampadine = new Lampadina[massimo];
        numeroLampadine = 0;
    }

    public boolean add(Lampadina l) {

        if (l == null) {
            return false;
        }

        if (numeroLampadine >= massimoLampadine) {
            return false;
        }

        for (int i = 0; i < numeroLampadine; i++) {

            if (lampadine[i].getNome().equals(l.getNome())) {
                return false;
            }
        }

        lampadine[numeroLampadine] = l;
        numeroLampadine++;

        return true;
    }

    public Lampadina cerca(String nome) {

        for (int i = 0; i < numeroLampadine; i++) {

            if (lampadine[i].getNome().equals(nome)) {
                return lampadine[i];
            }
        }

        return null;
    }

    public boolean rimuovi(String nome) {

        for (int i = 0; i < numeroLampadine; i++) {

            if (lampadine[i].getNome().equals(nome)) {

                for (int j = i; j < numeroLampadine - 1; j++) {
                    lampadine[j] = lampadine[j + 1];
                }

                numeroLampadine--;

                return true;
            }
        }

        return false;
    }

    public int getQuanteLampadine() {
        return numeroLampadine;
    }

    public String[] getElencoLampadine() {

        String[] elenco = new String[numeroLampadine];

        for (int i = 0; i < numeroLampadine; i++) {
            elenco[i] = lampadine[i].getNome();
        }

        return elenco;
    }

    public void accendiTutte() {

        for (int i = 0; i < numeroLampadine; i++) {
            lampadine[i].accendi();
        }
    }
    public void spegniTutte() {
        for (int i = 0; i < numeroLampadine; i++) {
            lampadine[i].spegni();
        }
    }

    public double getPotenzaAttuale() {
        double potenzaTotale = 0;

        for (int i = 0; i < numeroLampadine; i++) {
            if (lampadine[i].isAccesa()) {
                potenzaTotale += lampadine[i].getPotenza()
                        * lampadine[i].getLuminosita() / 100;
            }
        }

        return potenzaTotale;
    }

}