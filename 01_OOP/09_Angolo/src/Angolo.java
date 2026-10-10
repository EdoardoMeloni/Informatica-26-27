public class Angolo
{
    private int gradi;
    private int primi;
    private int secondi;

    public Angolo (int gradi, int primi, int secondi){
        this.gradi = gradi;
        this.primi = primi;
        this.secondi = secondi;
    }

    public void setGradi (int gradi){
        this.gradi = gradi;
    }

    public void setMinuti (int primi){
        this.primi = primi;
    }

    public void setSecondi(int secondi) {
        this.secondi = secondi;
    }

    public Angolo Sommaangolo (Angolo a){
        int seconditot = this.secondi + a.secondi;
        int primitot = this.primi + a.primi;
        int graditot = this.gradi + a.gradi;

        if (seconditot >= 60) {
            seconditot = seconditot - 60;
            primitot++;
        }
        if (primitot >= 60) {
            primitot = primitot - 60;
            graditot++;
        }
        if (graditot >= 360){
            graditot -= 360;
        }
        return new Angolo(graditot, primitot, seconditot);
    }

    public Angolo Sottraiangolo (Angolo a) {
        int seconditot = this.secondi - a.secondi;
        int primitot = this.primi - a.primi;
        int graditot = this.gradi - a.gradi;

        if (seconditot < 0) {
            seconditot += 60;
            primitot--;
        }

        if (primitot < 0) {
            primitot += 60;
            graditot--;
        }

        if (graditot < 0) {
            graditot = Math.abs(graditot);
        }

        return new Angolo(graditot, primitot, seconditot);
    }
}
