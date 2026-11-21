import graphics.Color;
import graphics.Ellipse;

public class Lampadina {
    private int potenza;
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
        this.x = x;
        this.y = y;
        this.accesa = false;
        this.nome = "";
        this.colore = "giallo";
        this.lamp = new Ellipse(x, y, potenza, potenza);
        this.lamp.setColor(Color.LIGHT_GRAY);
        this.lamp.fill();
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
        if (c.equals("giallo") || c.equals("rosso") || c.equals("blu") || c.equals("verde") || c.equals("arancione") || c.equals("rosa")) {
            this.colore = c;
        } else {
            throw new ColoreNonValidoException();
        }

        if (this.accesa) {
            accendi();
        }
    }

    public void accendi() {
        this.accesa = true;
        if (this.colore.equals("giallo")) {
            this.lamp.setColor(Color.YELLOW);
        } else if (this.colore.equals("rosso")) {
            this.lamp.setColor(Color.RED);
        } else if (this.colore.equals("blu")) {
            this.lamp.setColor(Color.BLUE);
        } else if (this.colore.equals("verde")) {
            this.lamp.setColor(Color.GREEN);
        } else if (this.colore.equals("arancione")) {
            this.lamp.setColor(Color.ORANGE);
        } else if (this.colore.equals("rosa")) {
            this.lamp.setColor(Color.PINK);
        }
        this.lamp.fill();
    }

    public void spegni() {
        this.accesa = false;
        this.lamp.setColor(Color.LIGHT_GRAY);
        this.lamp.fill();
    }

    @Override
    public String toString() {
        return "Lampadina{" +
                " potenza = " + potenza +
                ", accesa = " + accesa +
                ", nome = '" + nome + '\'' +
                ", colore = '" + colore + '\'' +
                ", posizione = (" + x + ", " + y + ")" +
                '}';
    }
}
