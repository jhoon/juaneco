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

    Random rnd = new Random();
// Atributos de escenario (animales, jugador, fondo, etc)
    Juaneco juaneco = new Juaneco();
    Escenario escenario = new Escenario();
    Animales animal1 = new Animales();
    Animales animal2 = new Animales();
    Animales animal3 = new Animales();
    Bonos bono = new Bonos();
    Obstaculos obsta1 = new Obstaculos();
    Obstaculos obsta2 = new Obstaculos();
    Obstaculos obsta3 = new Obstaculos();
// Constantes del juego
    private final int lado = getWidth();
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
            animal1.setFigura(Image.createImage(Canvas.class.getResourceAsStream("/rat.jpg")));
            animal2.setFigura(Image.createImage(Canvas.class.getResourceAsStream("/rat.jpg")));
            escenario.setFondo(Image.createImage(Canvas.class.getResourceAsStream("/fondo111.jpg")));
            obsta1.setObstaculo(Image.createImage(Canvas.class.getResourceAsStream("/rat.jpg")));
            obsta2.setObstaculo(Image.createImage(Canvas.class.getResourceAsStream("/rat.jpg")));
            obsta3.setObstaculo(Image.createImage(Canvas.class.getResourceAsStream("/fondo111.jpg")));
// Se inicializa a juaneco, escenario y comida
            juaneco.setIncremento(0);
            escenario.setBorde(1);


// Se crea la matriz de movimiento y la matriz de posiciones

            for (int i = 0; i < lado / 16; i++) {
                for (int j = 0; j < lado / 16; j++) {
                    poscel[i][j] = (i + 1) * (j + 1) * 8;
                    posesc[i][j] = 0;

                }
            }

// Se colocan las primeras posiciones de juaneco

            posesc[lado / 32][lado / 32] = 1;
            posesc[lado / 32][lado / 32 + 1] = 4;
            posesc[lado / 32][lado / 32 + 2] = 8;

            if ((posesc[rnd.nextInt(lado / 16)][rnd.nextInt(lado / 16)] != 1) & (posesc[rnd.nextInt(lado / 16)][rnd.nextInt(lado / 16)] != 2) & (posesc[rnd.nextInt(lado / 16)][rnd.nextInt(lado / 16)] != 3)) {
                posesc[rnd.nextInt(lado / 16)][rnd.nextInt(lado / 16)] = 10;
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
        dibuja(g);
        flushGraphics();

    }

    private void dibuja(Graphics g) {
        for (int i = 0; i < lado / 16; i++) {
            for (int j = 0; j < lado / 16; j++) {
                switch (posesc[i][j]) {

                    case 1: {
                        g.drawImage(juaneco.getCabeza(), poscel[i][j] / (i + 1), poscel[i][j] / (j + 1), Graphics.HCENTER | Graphics.BOTTOM);
                        break;
                    } // Caso 1: Cabeza
                    case 2: {
                        g.drawImage(juaneco.getTroncoH(), poscel[i][j] / (i + 1), poscel[i][j] / (j + 1), Graphics.HCENTER | Graphics.BOTTOM);
                        break;
                    }// Caso 2: Tronco Horizonal
                    case 3: {
                        g.drawImage(juaneco.getTroncoV(), poscel[i][j] / (i + 1), poscel[i][j] / (j + 1), Graphics.HCENTER | Graphics.BOTTOM);
                        break;
                    }// Caso 3: Tronco Vertial
                    case 4: {
                        g.drawImage(juaneco.getCodo1(), poscel[i][j] / (i + 1), poscel[i][j] / (j + 1), Graphics.HCENTER | Graphics.BOTTOM);
                        break;
                    }// Caso 4: Codo Down-R / R-Up
                    case 5: {
                        g.drawImage(juaneco.getCodo2(), poscel[i][j] / (i + 1), poscel[i][j] / (j + 1), Graphics.HCENTER | Graphics.BOTTOM);
                        break;
                    }// Caso 5: Codo Up-L / L-Down
                    case 6: {
                        g.drawImage(juaneco.getCodo3(), poscel[i][j] / (i + 1), poscel[i][j] / (j + 1), Graphics.HCENTER | Graphics.BOTTOM);
                        break;
                    }// Caso 6: Codo Down - L / L -Up
                    case 7: {
                        g.drawImage(juaneco.getCodo4(), poscel[i][j] / (i + 1), poscel[i][j] / (j + 1), Graphics.HCENTER | Graphics.BOTTOM);
                        break;
                    }// Caso 7: Codo Up - R / R - Down
                    case 8: {
                        g.drawImage(juaneco.getColaArr(), poscel[i][j] / (i + 1), poscel[i][j] / (j + 1), Graphics.HCENTER | Graphics.BOTTOM);
                        break;
                    }// Caso 8: Cola Arriba
                    case 9: {
                        g.drawImage(juaneco.getCabezaAba(), poscel[i][j] / (i + 1), poscel[i][j] / (j + 1), Graphics.HCENTER | Graphics.BOTTOM);
                        break;
                    }// Caso 9: Cola Abajo
                    case 10: {
                        g.drawImage(juaneco.getColaDer(), poscel[i][j] / (i + 1), poscel[i][j] / (j + 1), Graphics.HCENTER | Graphics.BOTTOM);
                        break;
                    }// Caso 10: Cola Derecha
                    case 11: {
                        g.drawImage(juaneco.getColaIzq(), poscel[i][j] / (i + 1), poscel[i][j] / (j + 1), Graphics.HCENTER | Graphics.BOTTOM);
                        break;
                    }// Caso 11: Cola Izquierda
                    case 12: {
                        g.drawImage(animal1.getFigura(), poscel[i][j] / (i + 1), poscel[i][j] / (j + 1), Graphics.HCENTER | Graphics.BOTTOM);
                        break;
                    }// Caso 12: Animal 1
                    case 13: {
                        g.drawImage(animal2.getFigura(), poscel[i][j] / (i + 1), poscel[i][j] / (j + 1), Graphics.HCENTER | Graphics.BOTTOM);
                        break;
                    }// Caso 13: Animal 2
                    case 14: {
                        g.drawImage(bono.getFigura(), poscel[i][j] / (i + 1), poscel[i][j] / (j + 1), Graphics.HCENTER | Graphics.BOTTOM);
                        break;
                    }// Caso 14: Bono
                    case 15: {
                        g.drawImage(obsta1.getObstaculo(), poscel[i][j] / (i + 1), poscel[i][j] / (j + 1), Graphics.HCENTER | Graphics.BOTTOM);
                        break;
                    }// Caso 15: Obstaculo 1
                    case 16: {
                        g.drawImage(obsta2.getObstaculo(), poscel[i][j] / (i + 1), poscel[i][j] / (j + 1), Graphics.HCENTER | Graphics.BOTTOM);
                        break;
                    }// Caso 16: Obstaculo 2
                    case 17: {
                        g.drawImage(obsta3.getObstaculo(), poscel[i][j] / (i + 1), poscel[i][j] / (j + 1), Graphics.HCENTER | Graphics.BOTTOM);
                        break;
                    }// Caso 17: Obstaculo 3
                    default: {
                        break;
                    }


                }
            }
        }




    }

    private void cambio_coor(int estado_boton) {

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
