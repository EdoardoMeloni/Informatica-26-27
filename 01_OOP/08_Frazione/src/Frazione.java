
public class Frazione {
    private int numeratore;
    private int denominatore;

    public Frazione() {
        numeratore = 0;
        denominatore = 1;
    }

    public Frazione(int numeratore, int denominatore) {
        this.numeratore = numeratore;

        if (denominatore == 0) {
            this.denominatore = 1;
        } else {
            this.denominatore = denominatore;
        }
    }

    public Frazione(Frazione altra) {
        numeratore = altra.numeratore;
        denominatore = altra.denominatore;
    }

    public int getNumeratore() {
        return numeratore;
    }

    public int getDenominatore() {
        return denominatore;
    }

    public void setNumeratore(int numeratore) {
        this.numeratore = numeratore;
    }

    public void setDenominatore(int denominatore) {
        if (denominatore != 0) {
            this.denominatore = denominatore;
        }
    }

    public double toDouble() {
        return (double) numeratore / denominatore;
    }

    public Frazione somma(Frazione altra) {
        int n = numeratore * altra.denominatore
                + altra.numeratore * denominatore;
        int d = denominatore * altra.denominatore;

        return new Frazione(n, d);
    }

    public Frazione differenza(Frazione altra) {
        int n = numeratore * altra.denominatore
                - altra.numeratore * denominatore;
        int d = denominatore * altra.denominatore;

        return new Frazione(n, d);
    }

    public Frazione prodotto(Frazione altra) {
        int n = numeratore * altra.numeratore;
        int d = denominatore * altra.denominatore;

        return new Frazione(n, d);
    }

    public Frazione quoziente(Frazione altra) {
        if (altra.numeratore == 0) {
            throw new ArithmeticException("Divisione per zero");
        }

        int n = numeratore * altra.denominatore;
        int d = denominatore * altra.numeratore;

        return new Frazione(n, d);
    }

    private static int mcd(long a, long b) {
        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0) {
            long resto = a % b;
            a = b;
            b = resto;
        }

        return a;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Frazione)) {
            return false;
        }

        Frazione altra = (Frazione) obj;

        return (long) numeratore * altra.denominatore
                == (long) altra.numeratore * denominatore;
    }

    @Override
    public String toString() {
        long n = numeratore;
        long d = denominatore;

        long divisore = mcd(n, d);
        n = n / divisore;
        d = d / divisore;

        if (d < 0) {
            n = -n;
            d = -d;
        }

        if (d == 1) {
            return "" + n;
        }

        return n + "/" + d;
    }
}
