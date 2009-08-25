package Snake;

import Snake.util.SnakeUtil;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.GameCanvas;
import java.util.Random;
import javax.microedition.midlet.MIDlet;

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
    private boolean fifin;
    private MidletJuaneco midlet;

    public Canvas(MidletJuaneco midlet) {
        super(true);
        this.midlet = midlet;
    }

    public Canvas() {
        super(true);

    }

    public void start() {

        //Se cargan las imagenes de la cabeza de Juaneco por cada punto cardinal

        this.getEscenario().inicializa();
        // Se inicializa a juaneco, escenario y comida
        getEscenario().setPantalla(1);
        getEscenario().setSeleccion(4);
        Thread hilo = new Thread(this);

        hilo.start();
    }

    public void run() {
        try {
            Graphics g = getGraphics();
            while (true) {

                checkUserInput();
                updateGameScreen(getGraphics());


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
        int state = getKeyStates();
        if (getEscenario().getPantalla() == 1) {
            getEscenario().setFondo(SnakeUtil.createImage("/pantalla1.jpg"));
            getEscenario().setOpc(SnakeUtil.createImage("/cazador.gif"));
            g.drawImage(getEscenario().getFondo(), lado / 2, 290, Graphics.HCENTER | Graphics.BOTTOM);

            if ((state & DOWN_PRESSED) != 0) {
                switch (getEscenario().getSeleccion()) {
                    case 1:
                        getEscenario().setSeleccion(2);
                        break;
                    case 2:
                        getEscenario().setSeleccion(3);
                        break;
                    case 3:
                        getEscenario().setSeleccion(4);
                        break;
                    case 4:
                        getEscenario().setSeleccion(5);
                        break;
                    case 5:
                        getEscenario().setSeleccion(1);
                        break;

                }
            } else if ((state & UP_PRESSED) != 0) {
                switch (getEscenario().getSeleccion()) {
                    case 1:
                        getEscenario().setSeleccion(5);
                        break;
                    case 2:
                        getEscenario().setSeleccion(1);
                        break;
                    case 3:
                        getEscenario().setSeleccion(2);
                        break;
                    case 4:
                        getEscenario().setSeleccion(3);
                        break;
                    case 5:
                        getEscenario().setSeleccion(4);
                        break;
                }
            }
            switch (getEscenario().getSeleccion()) {
                case 1: {
                    g.drawImage(getEscenario().getOpc(), 20, 252, Graphics.VCENTER | Graphics.RIGHT);
                    if ((state & FIRE_PRESSED) != 0) {
                        getEscenario().setPantalla(1);
                    }
                    break;
                }
                case 2: {
                    g.drawImage(getEscenario().getOpc(), 20, 274, Graphics.VCENTER | Graphics.RIGHT);
                    if ((state & FIRE_PRESSED) != 0) {
                        getEscenario().setPantalla(2);
                    }
                    break;
                }
                case 3: {
                    g.drawImage(getEscenario().getOpc(), 124, 237, Graphics.VCENTER | Graphics.RIGHT);
                    if ((state & FIRE_PRESSED) != 0) {

                        midlet.destroyApp(true);
                    }
                    break;
                }
                case 4: {
                    g.drawImage(getEscenario().getOpc(), 20, 200, Graphics.VCENTER | Graphics.RIGHT);
                    if ((state & FIRE_PRESSED) != 0) {
                        getEscenario().setPantalla(4);
                        getEscenario().inicializa();
                        getEscenario().setFin(false);
                        getEscenario().setNivel(0);
                        getEscenario().setPuntaje(0);
                    }
                    break;
                }
                case 5: {
                    g.drawImage(getEscenario().getOpc(), 20, 227, Graphics.VCENTER | Graphics.RIGHT);
                    if ((state & FIRE_PRESSED) != 0) {
                        getEscenario().setFin(false);
                        getEscenario().setNivel(1);
                        getEscenario().setPantalla(4);
                        getEscenario().inicializa();
                        getEscenario().setPuntaje(0);
                    }
                    break;
                }
                default:
                    break;

            }



            flushGraphics();

        } else if (getEscenario().getPantalla() == 2) {
        } else if (getEscenario().getPantalla() == 3) {
        } else if (getEscenario().getPantalla() == 4) {

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
            if (getEscenario().getNivel() != 0) {
                if (getEscenario().getPuntaje() == 350) {
                    getEscenario().setPuntaje(0);
                    if (getEscenario().getNivel() < 3) {
                        getEscenario().setNivel(getEscenario().getNivel() + 1);
                    }
                    getEscenario().inicializa();
                }
            }

            if (getEscenario().isFin()) {

                getEscenario().setPantalla(1);


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
        } else if (getEscenario().getPantalla() == 5) {
        }
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

    /**
     * @return the fifin
     */
    public boolean isFifin() {
        return fifin;
    }

    /**
     * @param fifin the fifin to set
     */
    public void setFifin(boolean fifin) {
        this.fifin = fifin;
    }
}

