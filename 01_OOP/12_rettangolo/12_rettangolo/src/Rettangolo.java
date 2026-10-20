class Rettangolo {
    private Punto a;
    private Punto b;

    public Rettangolo(Punto a, Punto b) {
        this.a = a;
        this.b = b;
    }

    public Punto getA() { return a; }
    public Punto getB() { return b; }

    public double altezza() {
        if (b.getY() > a.getY()) {
            return b.getY() - a.getY();
        }
        return a.getY() - b.getY();
    }

    public double base() {
        if (b.getX() > a.getX()) {
            return b.getX() - a.getX();
        }
        return a.getX() - b.getX();
    }

    public double calcolaPerimetro() {
        return 2 * (base() + altezza());
    }

    public double calcolaArea() {
        return base() * altezza();
    }

    public Rettangolo effettuatrasla(double dx, double dy) {
        Punto nuovoA = new Punto(a.getX() + dx, a.getY() + dy);
        Punto nuovoB = new Punto(b.getX() + dx, b.getY() + dy);
        Rettangolo nuovoRettangolo = new Rettangolo(nuovoA, nuovoB);
        return nuovoRettangolo;
    }

    public boolean contenido(Rettangolo r) {
        double r1MinX, r1MaxX, r1MinY, r1MaxY;
        if (this.a.getX() < this.b.getX()) {
            r1MinX = this.a.getX(); r1MaxX = this.b.getX();
        } else {
            r1MinX = this.b.getX(); r1MaxX = this.a.getX();
        }
        if (this.a.getY() < this.b.getY()) {
            r1MinY = this.a.getY(); r1MaxY = this.b.getY();
        } else {
            r1MinY = this.b.getY(); r1MaxY = this.a.getY();
        }

        double r2MinX, r2MaxX, r2MinY, r2MaxY;
        if (r.getA().getX() < r.getB().getX()) {
            r2MinX = r.getA().getX(); r2MaxX = r.getB().getX();
        } else {
            r2MinX = r.getB().getX(); r2MaxX = r.getA().getX();
        }
        if (r.getA().getY() < r.getB().getY()) {
            r2MinY = r.getA().getY(); r2MaxY = r.getB().getY();
        } else {
            r2MinY = r.getB().getY(); r2MaxY = r.getA().getY();
        }

        if (r2MinX >= r1MinX && r2MaxX <= r1MaxX && r2MinY >= r1MinY && r2MaxY <= r1MaxY) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "A(" + a.getX() + ", " + a.getY() + ") B(" + b.getX() + ", " + b.getY() + ")";
    }
}