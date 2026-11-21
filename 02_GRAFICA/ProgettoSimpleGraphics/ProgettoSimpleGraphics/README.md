# Simple Java Graphics

Questo progetto mostra come usare la **Simple Java Graphics Library** di Cay Horstmann: una piccola libreria didattica che permette di disegnare forme, testo e immagini con oggetti Java. La libreria si occupa di creare la finestra e aggiornare il disegno, così gli esempi possono concentrarsi su coordinate e oggetti senza dover costruire direttamente un'interfaccia Swing.

La libreria non fa parte delle API standard di Java. In questo progetto le sue classi sono già incluse in `src/graphics/`.

## Contenuto del progetto

- `src/Main.java` è il programma di esempio.
- `src/graphics/` contiene la libreria: `Canvas`, `Shape`, `Color`, `Rectangle`, `Ellipse`, `Line`, `Text` e `Picture`.
- `java.png` è l'immagine usata dall'esempio che mostra una figura con una didascalia.
- `slides.md` contiene una versione sintetica degli argomenti, organizzata in slide.

Il programma principale presenta un menu: inserisci `1` per disegnare un'ellisse, `2` per un rettangolo rosso pieno, oppure `3` per mostrare l'immagine insieme al testo “The Duke”.

## Avviare il progetto

Apri il progetto nell'IDE e avvia la classe `Main`. Se usi IntelliJ IDEA, assicurati che la cartella di lavoro della configurazione di esecuzione sia la cartella principale del progetto: così il percorso relativo `java.png` viene risolto correttamente.

In alternativa, da una shell nella cartella principale puoi compilare ed eseguire con:

~~~sh
mkdir -p out
javac -d out src/graphics/*.java src/Main.java
java -cp out Main
~~~

Non serve creare manualmente un `JFrame`. La libreria crea e gestisce la propria finestra quando un oggetto viene mostrato.

## Il modello mentale: crea, configura, mostra

Per disegnare una forma, il programma in genere:

1. crea un oggetto con posizione e dimensioni;
2. imposta colore o altre proprietà;
3. chiama `draw()` oppure `fill()`.

~~~java
import graphics.*;

public class Esempio {
    public static void main(String[] args) {
        Rectangle r = new Rectangle(40, 40, 180, 100);
        r.setColor(Color.RED);
        r.fill();

        Ellipse e = new Ellipse(260, 40, 100, 100);
        e.setColor(Color.BLUE);
        e.draw();
    }
}
~~~

`draw()` mostra il contorno. `fill()` riempie l'interno di rettangoli ed ellissi. Linee, testo e immagini si mostrano con `draw()`. La tela conserva i riferimenti agli oggetti mostrati: se in seguito ne cambi le proprietà, la vista viene aggiornata.

## Coordinate e dimensioni

La tela usa coordinate in pixel con origine nell'angolo in alto a sinistra:

~~~text
(0, 0) ───────────► x
  │
  │   (x, y)
  ▼
  y
~~~

`x` cresce verso destra e `y` verso il basso. Per rettangoli ed ellissi, `x` e `y` identificano l'angolo superiore sinistro del riquadro e gli altri due parametri sono larghezza e altezza.

| Classe | Costruttore | Significato |
| --- | --- | --- |
| `Rectangle` | `new Rectangle(x, y, larghezza, altezza)` | Rettangolo |
| `Ellipse` | `new Ellipse(x, y, larghezza, altezza)` | Ellisse inscritta nel riquadro |
| `Line` | `new Line(x1, y1, x2, y2)` | Segmento tra due estremi |
| `Text` | `new Text(x, y, messaggio)` | Testo con posizione iniziale |
| `Picture` | `new Picture(percorso)` | Immagine caricata da un file |

I parametri di posizione e dimensione accettano valori numerici anche decimali. I metodi `getX()`, `getY()`, `getWidth()` e `getHeight()` restituiscono valori interi arrotondati.

## Colori

La libreria definisce `graphics.Color`, che è distinta da `java.awt.Color`. Le forme iniziano nere; `setColor` permette di scegliere un altro colore.

~~~java
Rectangle box = new Rectangle(20, 20, 120, 80);
box.setColor(Color.ORANGE);
box.fill();

Ellipse disk = new Ellipse(180, 20, 80, 80);
disk.setColor(new Color(40, 160, 90));
disk.fill();
~~~

Puoi usare le costanti `RED`, `GREEN`, `BLUE`, `WHITE`, `BLACK`, `YELLOW`, `ORANGE`, `PINK` e varie tonalità di grigio. Con `new Color(rosso, verde, blu)`, ciascun componente RGB va da 0 a 255.

## Spostare e ridimensionare gli oggetti

Le forme possono essere modificate dopo la creazione:

~~~java
box.translate(20, 10); // 20 pixel a destra e 10 in basso
box.grow(5, 8);        // aggiunge 5 pixel per lato in larghezza e 8 in altezza
~~~

`translate(dx, dy)` sposta l'oggetto. `grow(dw, dh)` lo espande attorno al centro: su un rettangolo o un'ellisse aggiunge `2 * dw` alla larghezza e `2 * dh` all'altezza. Per esempio, `grow(5, 8)` aggiunge 10 pixel alla larghezza complessiva e 16 all'altezza.

Anche `Text` e `Picture` possono essere spostati e ridimensionati con questi metodi. Le modifiche diventano visibili quando l'oggetto è già stato disegnato; è possibile anche configurarlo prima di chiamare `draw()` o `fill()`.

## Immagini e pixel

Per caricare un'immagine, passa a `Picture` il percorso di un file leggibile dal programma:

~~~java
Picture foto = new Picture("java.png");
foto.translate(30, 30);
foto.draw();
~~~

I percorsi relativi, come `java.png`, partono dalla cartella di lavoro del processo, che nell'esempio dovrebbe essere la radice del progetto. `Picture` offre anche `load(percorso)` per caricare un'altra immagine e `grow` per modificarne la dimensione sullo schermo.

La stessa classe consente di leggere e scrivere i colori dei pixel:

~~~java
Color c = foto.getColorAt(x, y);
foto.setColorAt(x, y, new Color(255, 0, 0));
~~~

Le coordinate dei pixel partono da zero: `x` va da `0` a `foto.getWidth() - 1` e `y` da `0` a `foto.getHeight() - 1`. È possibile usare anche un indice lineare da `0` a `foto.pixels() - 1`.

Per esercizi con matrici, `getGrayLevels()` restituisce intensità di grigio da 0 a 255. La prima dimensione rappresenta le righe (`y`), la seconda le colonne (`x`), perciò il pixel si legge come `grigi[y][x]`. Puoi costruire un'altra immagine in scala di grigi passando una matrice al costruttore `new Picture(grigi)`.

~~~java
int[][] grigi = foto.getGrayLevels();

for (int y = 0; y < grigi.length; y++) {
    for (int x = 0; x < grigi[y].length; x++) {
        grigi[y][x] = 255 - grigi[y][x];
    }
}

Picture negativo = new Picture(grigi);
negativo.draw();
~~~

## Canvas, pause e sequenze

`Canvas` è la tela condivisa su cui vengono mostrati gli oggetti. È gestita dalla libreria e, nei casi normali, non occorre crearla né modificarla direttamente.

- `Canvas.pause()` apre un dialogo e attende che l'utente lo chiuda.
- `Canvas.snapshot()` cattura la scena corrente e la usa come sfondo sfumato; le forme disegnate dopo appaiono nitide. Ripetendo il procedimento si possono suggerire tracce di movimento.

La finestra viene aperta dalla libreria quando serve mostrare il disegno. Nell'esecuzione normale, il pulsante di chiusura della finestra termina anche il programma. Anche `System.exit(0)` termina l'intera JVM e quindi chiude la finestra; la libreria non espone un metodo pubblico per chiudere solo la finestra lasciando attivo il programma.

## Errori comuni da evitare

- **Percorso dell'immagine errato:** controlla la cartella di lavoro dell'IDE o usa un percorso corretto.
- **Classe Color sbagliata:** gli argomenti di `setColor` e `setColorAt` sono `graphics.Color`, non `java.awt.Color`.
- **Confusione tra coordinate:** sullo schermo `y` cresce verso il basso; nelle matrici dei grigi l'ordine è `[y][x]`.
- **Aspettarsi che `grow(5, 8)` aumenti la larghezza di soli 5 pixel:** il valore è aggiunto su entrambi i lati, quindi la larghezza aumenta di 10.
- **Creare una finestra per ogni forma:** la libreria usa una tela condivisa; basta disegnare gli oggetti.

## Riferimenti

- [Pagina della Simple Java Graphics Library](https://horstmann.com/sjsu/graphics/)
- [Documentazione API](https://horstmann.com/sjsu/graphics/api/index.html)

