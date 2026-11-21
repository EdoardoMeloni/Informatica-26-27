% Simple Java Graphics
% Una libreria essenziale per disegnare con Java
% Cay S. Horstmann · panoramica e guida pratica

## 1 · Una finestra, tante forme

**Simple Java Graphics** è una piccola libreria didattica di Cay Horstmann.

- Rende immediato disegnare forme e immagini con oggetti Java.
- Offre una finestra di disegno (`Canvas`) e classi come `Rectangle`, `Ellipse`, `Line`, `Text` e `Picture`.
- Aiuta a concentrarsi su coordinate, oggetti e trasformazioni senza scrivere subito il codice JavaFX o di altra
libreria grafica più complessa.

La libreria è pensata per imparare e creare semplici visualizzazioni; dietro le quinte usa le API grafiche di Java.

## 2 · Com’è organizzato questo progetto

- `src/graphics/` contiene la libreria usata dagli esempi.
- `src/Main.java` importa `graphics.*` e propone tre prove: ellisse, rettangolo rosso oppure immagine con testo.
- `java.png` è l’immagine locale mostrata dalla terza prova.

Per iniziare, il progetto include già le classi: basta importarle e creare gli oggetti. In un altro progetto, si possono includere le classi necessarie della libreria o scaricarla dalla [pagina di Horstmann](https://horstmann.com/sjsu/graphics/).

## 3 · Il piano di disegno

Le coordinate sono espresse in pixel e partono dall’angolo in alto a sinistra:

```text
(0, 0) ───────────► x
  │
  │   (x, y)
  ▼
  y
```

- `x` aumenta andando a destra; `y` aumenta andando in basso.
- Le posizioni indicano in genere l’angolo in alto a sinistra; larghezza e altezza sono espresse in pixel.

## 4 · Costruire le forme

```java
Rectangle r = new Rectangle(x, y, larghezza, altezza);
Ellipse   e = new Ellipse(x, y, larghezza, altezza);
Line      l = new Line(x1, y1, x2, y2);
Text      t = new Text(x, y, "Ciao!");
```

- `Rectangle`: posizione e dimensioni del rettangolo.
- `Ellipse`: posizione e dimensioni del riquadro che contiene l’ellisse.
- `Line`: coordinate dei due estremi.
- `Text`: posizione del testo e stringa da mostrare.

## 5 · Disegnare o riempire

`draw()` mostra il contorno; `fill()` riempie l’interno di rettangoli ed ellissi.

```java
public class Main {
    public static void main(String[] args) {
        Rectangle r = new Rectangle(40, 40, 180, 100);
        r.setColor(Color.RED);
        r.fill();

        Ellipse e = new Ellipse(260, 40, 100, 100);
        e.setColor(Color.BLUE);
        e.draw();
    }
}
```

La finestra viene gestita dalla libreria: non serve creare manualmente un `JFrame` o un `Canvas`.

## 6 · Il colore

Il package `graphics` fornisce la propria classe `Color`.

```java
r.setColor(Color.RED);                 // colore predefinito
e.setColor(new Color(40, 160, 90));    // rosso, verde, blu: valori da 0 a 255
```

Tra le costanti disponibili ci sono `BLACK`, `WHITE`, `BLUE`, `GREEN`, `YELLOW`, `ORANGE` e `PINK`. Se la forma è già sulla tela, il nuovo colore viene mostrato subito.

## 7 · Spostare e ridimensionare

Le forme sono oggetti modificabili: puoi spostarle o cambiarne le dimensioni dopo averle create.

```java
r.translate(20, 10);  // sposta a destra di 20 e in basso di 10 pixel
r.grow(5, 8);         // allarga di 5 e 8 pixel su ciascun lato
```

`getX()`, `getY()`, `getWidth()` e `getHeight()` restituiscono posizione e dimensioni. Le modifiche aggiornano la finestra; `grow(dw, dh)` espande la forma attorno al suo centro.

## 8 · Mostrare un’immagine

`Picture` carica un file immagine. Il percorso è relativo alla cartella da cui viene avviato il programma.

```java
Picture immagine = new Picture("java.png");
immagine.translate(30, 30);
immagine.draw();
```

Nel progetto, `java.png` si trova nella cartella principale. `translate` la posiziona; `grow` ne cambia la dimensione di visualizzazione.

## 9 · Leggere e modificare i pixel

La classe `Picture` permette anche di lavorare sui singoli pixel. Le coordinate dei pixel partono da zero.

```java
Color pixel = immagine.getColorAt(x, y);
immagine.setColorAt(x, y, new Color(255, 0, 0));
```

- `x` va da `0` a `getWidth() - 1`; `y` da `0` a `getHeight() - 1`.
- `pixels()` restituisce il numero totale di pixel.
- `getGrayLevels()` restituisce una matrice di intensità da 0 a 255: la riga è `y`, la colonna è `x`, quindi si legge `grigi[y][x]`.

## 10 · La tela e le pause

`Canvas` è la superficie condivisa sulla quale la libreria mostra tutte le forme. Di solito non occorre usarla direttamente.

```java
Canvas.pause();     // attende che l’utente chiuda il dialogo
Canvas.snapshot();  // sfuma il disegno attuale sullo sfondo
```

`snapshot()` è utile per mostrare il movimento: salva la scena corrente come sfondo sfumato, poi le nuove forme appaiono nitide.

## 11 · Leggere l’esempio del progetto

In `src/Main.java` il programma chiede quale prova eseguire:

1. **Ellisse**: crea `new Ellipse(100, 100, 200, 300)` e la mostra con `draw()`.
2. **Rettangolo**: crea un `Rectangle`, imposta il rosso e lo riempie con `fill()`.
3. **Immagine e testo**: carica `java.png`, disegna l’immagine e aggiunge la scritta “The Duke”.

Ogni ramo usa lo stesso schema: crea gli oggetti, ne imposta le proprietà e infine li disegna.

## 12 · Da ricordare

- Importa `graphics.*` e usa il `Color` dello stesso package.
- Le coordinate partono dall’angolo in alto a sinistra.
- Usa `draw()` per il contorno e `fill()` per riempire.
- Per le immagini, verifica che il file esista nella cartella di esecuzione.


**Riferimenti:** [guida della Simple Java Graphics Library](https://horstmann.com/sjsu/graphics/) · [documentazione API](https://horstmann.com/sjsu/graphics/api/index.html)
