import java.util.Random;

public class Dado {
    private int faccie;
    private Random random = new Random();


    public Dado() {
       this.faccie = 6;
    }

    public Dado(int faccie){
        if (faccie <= 3) {
            this.faccie = 6;
        } else {
            this.faccie = faccie;
        }
    }

    public Dado(Dado d){
        this.faccie = d.faccie;
    }

    public int lancio () {
        return random.nextInt(faccie) + 1;
    }

    @Override
    public String toString() {
        return "Il dado ha" + faccie + "faccie";
    }
}