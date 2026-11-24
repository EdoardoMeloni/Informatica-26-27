
import graphics.Color;
import graphics.Ellipse;

public class Lampadina {

    private int potenza;
    private int luminosita;
    private boolean accesa;
    private String nome;
    private String colore;
    private int x;
    private int y;
    private Ellipse lamp;

    public Lampadina(int potenza, int x, int y) throws PotenzaNonValidaException {

        if (potenza < 1 || potenza > 100) {
            throw new PotenzaNonValidaException();
        }

        this.potenza = potenza;
        this.luminosita = 100;
        this.x = x;
        this.y = y;
        this.accesa = false;
        this.nome = "";
        this.colore = "giallo";

        this.lamp = new Ellipse(x, y, potenza, potenza);
        this.lamp.setColor(Color.LIGHT_GRAY);
        this.lamp.fill();
    }

    public void setLuminosita(int luminosita) {

        if (luminosita < 0 || luminosita > 100) {
            throw new IllegalArgumentException("Luminosita non valida");
        }

        this.luminosita = luminosita;

        if (accesa) {
            accendi();
        }
    }

    public int getLuminosita() {
        return luminosita;
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

    public void setColore(String colore) throws ColoreNonValidoException {

        String c = colore.trim().toLowerCase();

        if (c.equals("giallo") || c.equals("rosso") ||
                c.equals("blu") || c.equals("verde") ||
                c.equals("arancione") || c.equals("rosa")) {

            this.colore = c;

        } else {
            throw new ColoreNonValidoException();
        }

        if (accesa) {
            accendi();
        }
    }

    public void accendi() {

        this.accesa = true;

        int r = 255;
        int g = 255;
        int b = 255;

        if (colore.equals("giallo")) {
            r = 255;
            g = 255;
            b = 0;

        } else if (colore.equals("rosso")) {
            r = 255;
            g = 0;
            b = 0;

        } else if (colore.equals("blu")) {
            r = 0;
            g = 0;
            b = 255;

        } else if (colore.equals("verde")) {
            r = 0;
            g = 255;
            b = 0;

        } else if (colore.equals("arancione")) {
            r = 255;
            g = 165;
            b = 0;

        } else if (colore.equals("rosa")) {
            r = 255;
            g = 192;
            b = 203;
        }

        r = r + (255 - r) * (100 - luminosita) / 100;
        g = g + (255 - g) * (100 - luminosita) / 100;
        b = b + (255 - b) * (100 - luminosita) / 100;

        this.lamp.setColor(new Color(r, g, b));
        this.lamp.fill();
    }

    public void spegni() {

        this.accesa = false;
        this.lamp.setColor(Color.LIGHT_GRAY);
        this.lamp.fill();
    }

    public int getPotenza() {
        return potenza;
    }

    public boolean isAccesa() {
        return accesa;
    }

    @Override
    public String toString() {
        return "Lampadina{" +
                " potenza = " + potenza +
                ", luminosita = " + luminosita +
                ", accesa = " + accesa +
                ", nome = '" + nome + '\'' +
                ", colore = '" + colore + '\'' +
                ", posizione = (" + x + ", " + y + ")" +
                '}';
    }
}
