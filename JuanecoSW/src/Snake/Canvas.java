package Snake;

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

    private boolean bandera;
    private Random rnd = new Random();
// Atributos de escenario (animales, jugador, fondo, etc)
    private Escenario escenario = new Escenario(getWidth());
    private Bonos bono = new Bonos();
    private Obstaculos obsta1 = new Obstaculos();
// Llmando al midlet
    private MidletJuaneco midletPadre;
    // Constantes del juego
    // Variables del juego
    private int mov;
    private int movant;
    private int lado = getWidth();
    private boolean cabeza = false;

    public Canvas() {
        super(true);
    }

    public Canvas(MidletJuaneco midlet) {
        super(true);
        this.midletPadre = midlet;
    }

    public void start() {
        try {
//Se cargan las imagenes de la cabeza de Juaneco por cada punto cardinal
            obsta1.inicializar();
            escenario.inicializa(bandera);
// Se inicializa a juaneco, escenario y comida
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread hilo = new Thread(this);

        hilo.start();
    }

    public void run() {
        try {
            Graphics g = getGraphics();
            while (true) {
                if (escenario.isFin() == true) {
                    midletPadre.cambiaPantalla(null, this.midletPadre.getPerdiste());
                    break;
// La funcion anterior se encarga de volver al menu, en el cambio de pantalla debe ir a la pantalla Perdiste y de ahi
                //a la pantalla Menu
                }
                checkUserInput();
                updateGameScreen(getGraphics());
                Thread.sleep(escenario.juaneco.getVelocidad());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void checkUserInput() {
        int estado_boton = getKeyStates();
        cambio_coor(estado_boton);
    }

    /**************************************************************/
    private void updateGameScreen(Graphics g) {
        escenario.movcabeza(mov, cabeza, movant, rnd);
        if (escenario.juaneco.getTronquitoXY().capacity() > 0) {
            escenario.movotronco(mov);
        }
        escenario.dibuja(g);
        g.drawString("Puntuacion:", 7 * lado / 9 + 9, 14 * getHeight() / 16 + 15, Graphics.HCENTER | Graphics.BOTTOM);
        g.drawString("" + escenario.getPuntaje(), 7 * lado / 9 + 9, 15 * getHeight() / 16 + 10, Graphics.HCENTER | Graphics.BOTTOM);
        flushGraphics();
    }

    private void cambio_coor(int estado_boton) {
        cabeza = false;
        if (((estado_boton & LEFT_PRESSED) != 0) & (mov != 1) & (mov != 2)) {
            movant = mov;
            mov = 1;
        } else if (((estado_boton & RIGHT_PRESSED) != 0) & (mov != 1) & (mov != 2)) {
            movant = mov;
            mov = 2;
        } else if (((estado_boton & UP_PRESSED) != 0) & (mov != 3) & (mov != 4)) {
            movant = mov;
            mov = 3;
        } else if (((estado_boton & DOWN_PRESSED) != 0) & (mov != 3) & (mov != 4)) {
            movant = mov;
            mov = 4;
        }else if (((estado_boton & DOWN_PRESSED) != 0) & (mov != 3) & (mov != 4)) {
            movant = mov;
            mov = 4;
        }
    }

    public boolean isBandera() {
        return bandera;
    }

    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }
}

