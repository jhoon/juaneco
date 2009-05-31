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

/**
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
    private final int posicion1 = lado / 10;
// Variables del juego
    private int mov;
    private int choque = 0;
    private int[][] posicion = new int[lado / 5][lado / 5];

    public Canvas() {
        super(true);

    }

    public void start() {
        try {


//Se cargan las imagenes de la cabeza de Juaneco por cada punto cardinal
            juaneco.cargaim();
            animal.setFigura(Image.createImage(Canvas.class.getResourceAsStream("/link.gif")));
            escenario.setFondo(Image.createImage(Canvas.class.getResourceAsStream("/fondo1.jpg")));
// Se inicializa a juaneco, escenario y comida
            juaneco.setIncremento(0);
            juaneco.setPosicionX(lado / 10);
            juaneco.setPosicionY(lado / 10);
            animal.setPosicionX(rndx.nextInt(getWidth()));
            animal.setPosicionY(rndy.nextInt(getHeight()));
            escenario.setBorde(0);
            juaneco.setVelocidad(5);

// Se crea la matriz de movimiento
            for (int i = 0; i < lado/5; i++) {
                for (int j = 0; j < lado/5; j++) {
                    if ((i == (juaneco.getPosicionX()/5-1))&(j == (juaneco.getPosicionY()/5)-1))
                    posicion[i][j] = 1;
                    else
                    posicion[i][j] = 0;
                }
            }


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
            posicion[juaneco.getPosicionX()][juaneco.getPosicionY()] = 1;

        }

        if (mov == 2) {
            juaneco.movder(escenario.getBorde(), lado);
            juaneco.setCabeza(juaneco.getCabezaDer());
        }
        if (mov == 3) {

            juaneco.movup(escenario.getBorde(), lado);
            juaneco.setCabeza(juaneco.getCabezaArr());


        }
        if (mov == 4) {

            juaneco.movdwn(escenario.getBorde(), lado);
            juaneco.setCabeza(juaneco.getCabezaAba());

        }
    }

    private void shock() {

        if ((juaneco.getPosicionX() == animal.getPosicionX()) & (juaneco.getPosicionY() == animal.getPosicionY())) {
            choque = 1;
        }

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
        if (choque == 0) {
            g.drawImage(animal.getFigura(), animal.getPosicionX(), animal.getPosicionY(), Graphics.HCENTER | Graphics.BOTTOM);
        }

        g.drawString("posicion1posicion2" + posicion[juaneco.getPosicionX() / 5 - 1][juaneco.getPosicionY() / 5 - 1], centrox, centroy - juaneco.getVelocidad(), Graphics.BASELINE | Graphics.HCENTER);
        flushGraphics();

    }

    private void cambio_coor(int estado_boton) {

        if (((estado_boton & LEFT_PRESSED) != 0) && (mov != 1)) {
            if (mov != 2) {
                juaneco.movizq(escenario.getBorde(), lado);
                mov = 1;
            }
        } else if (((estado_boton & RIGHT_PRESSED) != 0) && (mov != 2)) {
            if (mov != 1) {
                juaneco.movder(escenario.getBorde(), lado);
                mov = 2;
            }
        } else if (((estado_boton & UP_PRESSED) != 0) && (mov != 3)) {
            if (mov != 4) {
                juaneco.movup(escenario.getBorde(), lado);
                mov = 3;
            }
        } else if (((estado_boton & DOWN_PRESSED) != 0) && (mov != 4)) {
            if (mov != 3) {
                juaneco.movdwn(escenario.getBorde(), lado);
                mov = 4;
            }
        }

    }
}
