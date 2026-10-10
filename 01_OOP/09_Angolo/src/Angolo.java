public class Angolo
{
    private int gradi;
    private int minuti;
    private int secondi;

    public Angolo (int gradi, int minuti, int secondi){
        this.gradi = gradi;
        this.minuti = minuti;
        this.secondi = secondi;
    }

    public void setGradi (int gradi){
        this.gradi = gradi;
    }

    public void setMinuti (int minuti){
        this.minuti = minuti;
    }

    public void setSecondi(int secondi) {
        this.secondi = secondi;
    }

    public Angolo Sommaangolo (Angolo a){
        int seconditot = this.secondi + a.secondi;
        int minutitot = this.minuti + a.minuti;
        int graditot = this.gradi + a.gradi;

        if (seconditot >= 60) {
            seconditot = seconditot - 60;
            minutitot++;
        }
        if (minutitot >= 60) {
            minutitot = minutitot - 60;
            graditot++;
        }
        if (graditot >= 360){
            graditot -= 360;
        }
        return new Angolo(graditot, minutitot, seconditot);
    }

    public Angolo Sottraiangolo (Angolo a) {
        int seconditot = this.secondi - a.secondi;
        int minutitot = this.minuti - a.minuti;
        int graditot = this.gradi - a.gradi;

        if (seconditot < 0) {
            seconditot += 60;
            minutitot--;
        }

        if (minutitot < 0) {
            minutitot += 60;
            graditot--;
        }

        if (graditot < 0) {
            graditot = Math.abs(graditot);
        }

        return new Angolo(graditot, minutitot, seconditot);
    }
}
