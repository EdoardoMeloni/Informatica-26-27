public class Quiz {
    private String titoloquiz;
    private Domanda[] domande;
    private int punteggiotot;
    private int punteggiotuo;
    private final int maxDomande = 100;
    private int numeroDomande = 0;

    public Quiz (String s){
        this.titoloquiz = s;

    }

    public Quiz (Quiz q){
        this.domande = q.domande.clone();
        for (int i = 0; i < domande.length; i++) {
            domande[i] = new Domanda (q.domande[i]);
        }
    }

    public void add (Domanda d) {
        if (domande.length < maxDomande){
            domande[numeroDomande] = d;
            numeroDomande++;
        }
    }

    public int getNumeroDomande() {
        return numeroDomande;
    }

   public int getQuanterisposte () {
        int a = 0;
       for (int i = 0; i < domande.length; i++) {
           if (domande[i].completata()) {
               a++;
           }
       }
       return a;
   }

    public int [] getDomandenondate () {
        int [] a;
        a = new int [maxDomande];
        int b=0;
        for (int i = 0; i < domande.length; i++) {
            if (!domande[i].completata()) {
                a[b] = i;
                b++;

            }
        }
        return a;
    }



}
