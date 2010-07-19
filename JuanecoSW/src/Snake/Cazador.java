/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snake;

import Snake.util.SnakeUtil;
import javax.microedition.lcdui.Image;

/**
 *
 * @author Manuel Sotelo A
 */
public class Cazador extends Personajes {

    private int vidas;
    private Image cazador;
    private Image bala;

    public Cazador() {
        this.setVidas(5);

    }

    public void cargaimagen() {
        this.setCazador(SnakeUtil.createImage("/cazador.jpg"));
        this.setBala(SnakeUtil.createImage("/bala.jpg"));

    }

    /**
     * @return the vidas
     */
    public int getVidas() {
        return vidas;
    }

    /**
     * @param vidas the vidas to set
     */
    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    /**
     * @return the cazador
     */
    public Image getCazador() {
        return cazador;
    }

    /**
     * @param cazador the cazador to set
     */
    public void setCazador(Image cazador) {
        this.cazador = cazador;
    }

    /**
     * @return the bala
     */
    public Image getBala() {
        return bala;
    }

    /**
     * @param bala the bala to set
     */
    public void setBala(Image bala) {
        this.bala = bala;
    }
}
