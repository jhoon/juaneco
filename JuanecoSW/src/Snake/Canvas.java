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
    Random rndx = new Random();
    Random rndy = new Random();
    private int tiempo_ms = 50;
    private int mov;
    Juaneco juaneco = new Juaneco();
    public final int centrox = getWidth() / 2;
    public final int centroy = getHeight() / 2;
    Escenario escenario = new Escenario();
    Animales animal = new Animales ();
    private int choque = 0;
    public Canvas() {
        super(true);

    }

    public void start() {
        try {


//Se cargan las imagenes de la cabeza de Juaneco por cada punto cardinal
            juaneco.setCabezaIzq(Image.createImage(Canvas.class.getResourceAsStream("/worm2.gif")));
            juaneco.setCabezaAba(Image.createImage(Canvas.class.getResourceAsStream("/worm3.gif")));
            juaneco.setCabezaDer(Image.createImage(Canvas.class.getResourceAsStream("/worm4.gif")));
            juaneco.setCabezaArr(Image.createImage(Canvas.class.getResourceAsStream("/worm1.gif")));
            animal.setFigura(Image.createImage(Canvas.class.getResourceAsStream("/link.gif")));
//Se carga la cabeza principal de juaneco como la cabezaIzq para empezar
            juaneco.setCabeza(juaneco.getCabezaArr());
            juaneco.setPosicionX(centrox);
            juaneco.setPosicionY(centroy);
            animal.setPosicionX(rndx.nextInt(getWidth()));
            animal.setPosicionY(rndy.nextInt(getHeight()));
            escenario.setBorde(0);

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

    private void movcon(){
    if (mov == 1) {
            juaneco.movizq(escenario.getBorde());
            juaneco.setCabeza(juaneco.getCabezaIzq());
        }

        if (mov == 2) {
            juaneco.movder(escenario.getBorde());
            juaneco.setCabeza(juaneco.getCabezaDer());
        }
        if (mov == 3) {

            juaneco.movup(escenario.getBorde());
            juaneco.setCabeza(juaneco.getCabezaArr());


        }
        if (mov == 4) {

            juaneco.movdwn(escenario.getBorde());
            juaneco.setCabeza(juaneco.getCabezaAba());

        }
    }
private void shock (){

if((juaneco.getPosicionX() == animal.getPosicionX())&(juaneco.getPosicionY() == animal.getPosicionY()))
 choque = 1;

}
    private void verifyGameState() {
    }

    private void updateGameScreen(Graphics g) {
        movcon();
        shock();
        g.setColor(0x00acde);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.drawImage(juaneco.getCabeza(), juaneco.getPosicionX(), juaneco.getPosicionY(), Graphics.HCENTER | Graphics.BOTTOM);
        if(choque == 0)
        g.drawImage(animal.getFigura(), animal.getPosicionX(), animal.getPosicionY(), Graphics.HCENTER | Graphics.BOTTOM);
        
        flushGraphics();

    }

    private void cambio_coor(int estado_boton) {

        if (((estado_boton & LEFT_PRESSED) != 0) && (mov != 1)) {
            if (mov != 2) {
                juaneco.movizq(escenario.getBorde());
                mov = 1;
            }
        } else if (((estado_boton & RIGHT_PRESSED) != 0) && (mov != 2)) {
            if (mov != 1) {
                juaneco.movder(escenario.getBorde());
                mov = 2;
            }
        } else if (((estado_boton & UP_PRESSED) != 0) && (mov != 3)) {
            if (mov != 4) {
                juaneco.movup(escenario.getBorde());
                mov = 3;
            }
        } else if (((estado_boton & DOWN_PRESSED) != 0) && (mov != 4)) {
            if (mov != 3) {
                juaneco.movdwn(escenario.getBorde());
                mov = 4;
            }
        }

    }
}
