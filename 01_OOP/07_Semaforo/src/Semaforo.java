public class Semaforo {

    private boolean acceso;
    private String colore;

    public Semaforo() {
        acceso = false;
        colore = "";
    }

    public void accendi() {
        acceso = true;
        colore = "VERDE";
    }

    public void spegni() {
        acceso = false;
    }

    public void toggle() {

        if (acceso) {
            spegni();
        } else {
            accendi();
        }
    }

    public void avanza() {

        if (!acceso) {
            return;
        }

        if (colore.equals("VERDE")) {
            colore = "GIALLO";

        } else if (colore.equals("GIALLO")) {
            colore = "ROSSO";

        } else if (colore.equals("ROSSO")) {
            colore = "VERDE";
        }
    }

    public boolean isAcceso() {
        return acceso;
    }

    public String getColore() {

        if (acceso) {
            return colore;
        }

        return "";
    }

    @Override
    public String toString() {

        if (acceso) {
            return "Il semaforo è acceso sul " + colore;
        }

        return "Il semaforo è spento";
    }
}