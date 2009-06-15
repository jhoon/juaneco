package Snake;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.GameCanvas;
import java.util.Random;

/**a
 *

 *
 * @author Manuel Sotelo A
 */
public class Canvas extends GameCanvas implements Runnable {
//clase Random para la aparicion de alimento

    private Random rnd = new Random();
// Atributos de escenario (animales, jugador, fondo, etc)
    private Escenario escenario = new Escenario(getWidth());
// Llmando al midlet
    private MidletJuaneco midletPadre;
    // Constantes del juego
    // Variables del juego
    private int mov = 3;
    private int movant = 3;
    private int lado = getWidth();
    private boolean cabeza = false;
    private int puntaje;

    public Canvas() {
        super(true);
    }

    public Canvas(MidletJuaneco midlet) {
        super(true);
        this.midletPadre = midlet;
    }

    public void start() {

        //Se cargan las imagenes de la cabeza de Juaneco por cada punto cardinal

        this.getEscenario().inicializa();
        // Se inicializa a juaneco, escenario y comida

        Thread hilo = new Thread(this);

        hilo.start();
    }

    public void run() {
        try {
            Graphics g = getGraphics();
            while (true) {

                checkUserInput();
                updateGameScreen(getGraphics());
                if (getEscenario().isFin() == true) {
                    getMidletPadre().cambiaPantalla(null, this.getMidletPadre().getPerdiste());
                    break;
                // La funcion anterior se encarga de volver al menu, en el cambio de pantalla debe ir a la pantalla Perdiste y de ahi
                //a la pantalla Menu
                } else if ((this.getEscenario().getPuntaje() >= 200) && getEscenario().getNivel() != 0) {
                    this.cambioescenario();
                    break;
                }

                Thread.sleep(getEscenario().juaneco.getVelocidad());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void checkUserInput() {
        int estado_boton = getKeyStates();
        cambio_coor(estado_boton);
    }

    private void updateGameScreen(Graphics g) {
        if (getEscenario().isConta()) {
            getEscenario().aleatorionivel();
        }
        getEscenario().movcabeza(mov, cabeza, movant, rnd);

        if (this.getEscenario().isFin() == false) {
            getEscenario().movotronco(getMov());
        }
        if (this.escenario.getNivel() == 4) {
            this.escenario.muevecaza();
        }

        this.getEscenario().dibuja(g);
        g.setColor(120, 120, 120);
        if (this.escenario.getNivel() != 4) {
            g.drawString("Puntuacion:", 7 * getLado() / 9 + 9, 14 * getHeight() / 16 + 15, Graphics.HCENTER | Graphics.BOTTOM);
            g.drawString("" + getEscenario().getPuntaje(), 7 * getLado() / 9 + 9, 15 * getHeight() / 16 + 10, Graphics.HCENTER | Graphics.BOTTOM);
        } else {
            g.drawString("Vidas de Juaneco:", 7 * getLado() / 9 + 9, 14 * getHeight() / 16 + 15, Graphics.HCENTER | Graphics.BOTTOM);
            g.drawString("" + getEscenario().juaneco.getVidas(), 7 * getLado() / 9 + 9, 15 * getHeight() / 16 + 10, Graphics.HCENTER | Graphics.BOTTOM);
            g.drawString("Vidas del Cazador:", 3 * getLado() / 9 + 9, 14 * getHeight() / 16 + 15, Graphics.HCENTER | Graphics.BOTTOM);
            g.drawString("" + getEscenario().caza.getVidas(), 3 * getLado() / 9 + 9, 15 * getHeight() / 16 + 10, Graphics.HCENTER | Graphics.BOTTOM);

        }
        flushGraphics();

    }

    private void cambio_coor(int estado_boton) {
        setCabeza(false);

        if (((estado_boton & LEFT_PRESSED) != 0) & (getMov() != 1) & (getMov() != 2)) {
            setMovant(getMov());
            setMov(1);
        } else if (((estado_boton & RIGHT_PRESSED) != 0) & (getMov() != 1) & (getMov() != 2)) {
            setMovant(getMov());
            setMov(2);
        } else if (((estado_boton & UP_PRESSED) != 0) & (getMov() != 3) & (getMov() != 4)) {
            setMovant(getMov());
            setMov(3);
        } else if (((estado_boton & DOWN_PRESSED) != 0) & (getMov() != 3) & (getMov() != 4)) {
            setMovant(getMov());
            setMov(4);
        } else if (((estado_boton & KEY_NUM5) != 0)) {
            if (this.escenario.getNivel() == 4) {
                if (!this.escenario.juaneco.isDisparo()) {
                    this.escenario.juaneco.setDisparo(true);
                }
            }
        } else {
            this.escenario.juaneco.setDisparo(false);
        }
    }

    public void cambioescenario() {

        if (getEscenario().getNivel() == 1) {
            getMidletPadre().cambiaPantalla(null, this.getMidletPadre().getSelvaSierra());
        } else if (getEscenario().getNivel() == 2) {
            getMidletPadre().cambiaPantalla(null, this.getMidletPadre().getSierraCosta());
        } else if (getEscenario().getNivel() == 3) {
            getMidletPadre().cambiaPantalla(null, this.getMidletPadre().getBoss());
        } else if (getEscenario().getNivel() == 4) {
            getMidletPadre().cambiaPantalla(null, this.midletPadre.getGanaste());
        }

    }

    /**
     * @return the rnd
     */
    public Random getRnd() {
        return rnd;
    }

    /**
     * @param rnd the rnd to set
     */
    public void setRnd(Random rnd) {
        this.rnd = rnd;
    }

    /**
     * @return the puntaje
     */
    public int getPuntaje() {
        return puntaje;
    }

    /**
     * @param puntaje the puntaje to set
     */
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    /**
     * @return the midletPadre
     */
    public MidletJuaneco getMidletPadre() {
        return midletPadre;
    }

    /**
     * @param midletPadre the midletPadre to set
     */
    public void setMidletPadre(MidletJuaneco midletPadre) {
        this.midletPadre = midletPadre;
    }

    /**
     * @return the mov
     */
    public int getMov() {
        return mov;
    }

    /**
     * @param mov the mov to set
     */
    public void setMov(int mov) {
        this.mov = mov;
    }

    /**
     * @return the movant
     */
    public int getMovant() {
        return movant;
    }

    /**
     * @param movant the movant to set
     */
    public void setMovant(int movant) {
        this.movant = movant;
    }

    /**
     * @return the lado
     */
    public int getLado() {
        return lado;
    }

    /**
     * @param lado the lado to set
     */
    public void setLado(int lado) {
        this.lado = lado;
    }

    /**
     * @return the cabeza
     */
    public boolean isCabeza() {
        return cabeza;
    }

    /**
     * @param cabeza the cabeza to set
     */
    public void setCabeza(boolean cabeza) {
        this.cabeza = cabeza;
    }

    /**
     * @return the escenario
     */
    public Escenario getEscenario() {
        return escenario;
    }

    /**
     * @param escenario the escenario to set
     */
    public void setEscenario(Escenario escenario) {
        this.escenario = escenario;
    }
}

