/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snake;

import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.GameCanvas;
import java.io.IOException;
import java.util.Random;

/**a
 *

 *
 * @author Manuel Sotelo A
 */
public class Canvas extends GameCanvas implements Runnable {
//clase Random para la aparicion de alimento

    Random rndx = new Random();
    Random rndy = new Random();
// Atributos de escenario (animales, jugador, fondo, etc)
    Juaneco juaneco = new Juaneco();
    Escenario escenario = new Escenario();
    Animales animal = new Animales();
// Constantes del juego
    private final int lado = getWidth();
    private final int centrox = getWidth() / 2;
    private final int centroy = getHeight() / 2;
    private final int tiempo_ms = 50;
// Variables del juego
    private int mov;
    private int[][] posesc = new int[lado / 16][lado / 16]; // posicion escenario
    private int[][] poscel = new int[lado / 16][lado / 16]; //posicion celular px
    

    public Canvas() {
        super(true);

    }

    public void start() {
        try {

//Se cargan las imagenes de la cabeza de Juaneco por cada punto cardinal
            juaneco.cargaim();
            animal.setFigura(Image.createImage(Canvas.class.getResourceAsStream("/rat.jpg")));
            escenario.setFondo(Image.createImage(Canvas.class.getResourceAsStream("/fondo111.jpg")));
// Se inicializa a juaneco, escenario y comida
            juaneco.setIncremento(0);


            escenario.setBorde(1);


// Se crea la matriz de movimiento

            for (int i = 0; i < lado / 16; i++) {
                for (int j = 0; j < lado / 16; j++) {
                    poscel[i][j] = i * j * 8;

                }
            }
// Se crea la matriz de posiciones de objetos (inicializa)            
            for (int i = 0; i < lado / 16; i++) {
                for (int j = 0; j < lado / 16; j++) {
                    posesc[i][j] = 0;
                }
            }
// Se cargan las primeras imagenes de juaneco

        } catch (IOException e) {
            System.err.println(e);
        }
        Thread hilo = new Thread(this);

        hilo.start();
    }

    public void run() {
        Graphics g = getGraphics();

        while (true) {

            verifyGameState();

            checkUserInput();

            updateGameScreen(getGraphics());
            try {
                Thread.sleep(tiempo_ms);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void checkUserInput() {

        int estado_boton = getKeyStates();

        cambio_coor(estado_boton);
    }

    private void movcon() {
        if (mov == 1) {
            juaneco.movizq(escenario.getBorde(), lado);
            juaneco.setCabeza(juaneco.getCabezaIzq());
        }
        if (mov == 2) {
            juaneco.movder(escenario.getBorde(), lado);
            juaneco.setCabeza(juaneco.getCabezaIzq());
        }
        if (mov == 3) {
            juaneco.movup(escenario.getBorde(), lado);
            juaneco.setCabeza(juaneco.getCabezaIzq());
        }
        if (mov == 4) {
            juaneco.movdwn(escenario.getBorde(), lado);
            juaneco.setCabeza(juaneco.getCabezaIzq());
        }

    }

    private void shock() {
    }

    private void verifyGameState() {
    }

    private void updateGameScreen(Graphics g) {
        movcon();
        shock();
        g.setColor(0xffffff);

        g.fillRect(0, 0, getWidth(), getHeight());
        g.drawImage(escenario.getFondo(), centrox, centroy * 2, Graphics.HCENTER | Graphics.BOTTOM);
        g.drawImage(juaneco.getCabeza(), juaneco.getPosicionX(), juaneco.getPosicionY(), Graphics.HCENTER | Graphics.BOTTOM);


    }

    private void cambio_coor(int estado_boton) {


        if (((estado_boton & LEFT_PRESSED) != 0)) {


            if (((estado_boton & LEFT_PRESSED) != 0)) {

                juaneco.movizq(escenario.getBorde(), lado);
                mov = 1;
            } else if (((estado_boton & RIGHT_PRESSED) != 0)) {
                juaneco.movder(escenario.getBorde(), lado);
                mov = 2;
            } else if (((estado_boton & UP_PRESSED) != 0)) {
                juaneco.movup(escenario.getBorde(), lado);
                mov = 3;
            } else if (((estado_boton & DOWN_PRESSED) != 0)) {
                juaneco.movdwn(escenario.getBorde(), lado);
                mov = 4;
            }

        }
    }
}
