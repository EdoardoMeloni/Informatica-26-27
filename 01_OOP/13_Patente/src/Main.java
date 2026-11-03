public class Main {
    public static void main(String[] args) {
        Risposta[] risposte1 = {
                new Risposta("Torino", false),
                new Risposta("Berna", true),
                new Risposta("Basilea", false),
                new Risposta("Ginevra", false)
        };

        Risposta[] risposte2 = {
                new Risposta("Il rosso", false),
                new Risposta("Il verde", false),
                new Risposta("Il blu", true),
                new Risposta("Il giallo", false)
        };

        Risposta[] risposte3 = {
                new Risposta("A destra", true),
                new Risposta("A sinistra", false),
                new Risposta("In retromarcia", false),
                new Risposta("Non si può sorpassare", false)
        };

        Domanda d1 = new Domanda("Qual è la capitale della Svizzera?", risposte1);
        Domanda d2 = new Domanda("Qual è il colore del cielo in una giornata serena?", risposte2);
        Domanda d3 = new Domanda("In Italia, in quale corsia si guida normalmente?", risposte3);
        d2.setValore(2);
        d3.setValore(-5);

        Quiz quiz = new Quiz("La patente");
        quiz.add(d1);
        quiz.add(d2);
        quiz.add(d3);

        System.out.println(quiz);
        System.out.println();
        System.out.println("Domande presenti: " + quiz.getQuanteDomande());
        System.out.println("Risposte date: " + quiz.getQuanteRisposte());
        System.out.println("Valore della seconda domanda: " + d2.getValore());
        System.out.println("Valore della terza domanda dopo setValore(-5): " + d3.getValore());
        System.out.println("Punteggio prima di rispondere alla prima domanda: " + d1.getPunteggio());
        System.out.println();

        System.out.println("Prima domanda:");
        System.out.println(quiz.getDomanda(1));
        System.out.println("Risposta corretta: " + d1.getRispostaCorretta());
        System.out.println("Risposta data: " + d1.getRispostaData());
        System.out.println("Completata: " + d1.completata());

        System.out.println();
        System.out.println("Rispondo alla prima domanda scegliendo la risposta 2:");
        System.out.println("Risposta corretta? " + d1.rispondi(2));
        System.out.println("Risposta data: " + d1.getRispostaData());
        System.out.println("Punteggio della domanda: " + d1.getPunteggio());

        System.out.println();
        System.out.println("Rispondo alla seconda domanda scegliendo la risposta 1:");
        System.out.println("Risposta corretta? " + d2.rispondi(1));
        System.out.println("Punteggio della domanda: " + d2.getPunteggio());

        System.out.println();
        System.out.println("Risposte date nel quiz: " + quiz.getQuanteRisposte());
        System.out.print("Indici delle domande non ancora risposte: ");
        int[] nonDate = quiz.getDomandeNonDate();
        for (int i = 0; i < nonDate.length; i++) {
            System.out.print(nonDate[i] + " ");
        }
        System.out.println();

        System.out.println("Punteggio totale possibile: " + quiz.getTotale());
        System.out.println("Punteggio ottenuto finora: " + quiz.getPunteggio());
        System.out.println("Indice non valido (0): " + quiz.getDomanda(0));

        System.out.println();
        Domanda copiaDomanda = new Domanda(d1);
        System.out.println("Copia della prima domanda, senza risposta data:");
        System.out.println("Completata: " + copiaDomanda.completata());
        System.out.println("Risposta data: " + copiaDomanda.getRispostaData());

        Quiz copiaQuiz = new Quiz(quiz);
        System.out.println();
        System.out.println("Copia del quiz:");
        System.out.println(copiaQuiz);
        System.out.println("Risposte date nella copia: " + copiaQuiz.getQuanteRisposte());
    }
}
