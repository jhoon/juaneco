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
public class Obstaculos extends ElementoJuego {

    private Image Obstaculo;
    private Image Obstaculo2;
    private int tamano;

    public Obstaculos() {
        super();
    }

    public void inicializar(int tipo) {

        if (tipo == 1) {
            this.setObstaculo(SnakeUtil.createImage("/rio.jpg"));
            this.setObstaculo2(SnakeUtil.createImage("/selva_obs.jpg"));

        // falta la matriz
        } else if (tipo == 2) {
            this.setObstaculo(SnakeUtil.createImage("/sierra_obs.jpg"));
            this.setObstaculo2(SnakeUtil.createImage("/huayco.jpg"));

        // falta la matriz
        }
        if (tipo == 3) {
            this.setObstaculo(SnakeUtil.createImage("/costa_obs.jpg"));
            this.setObstaculo2(SnakeUtil.createImage("/terremoto.jpg"));

        // falta la matriz
        }


    }

    /**
     * @return the tipo
     */
    /**
     * @return the tamano
     */
    public int getTamano() {
        return tamano;
    }

    /**
     * @param tamano the tamano to set
     */
    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    /**
     * @return the Obstaculo
     */
    public Image getObstaculo() {
        return Obstaculo;
    }

    /**
     * @param Obstaculo the Obstaculo to set
     */
    public void setObstaculo(Image Obstaculo) {
        this.Obstaculo = Obstaculo;
    }

    /**
     * @return the Obstaculo2
     */
    public Image getObstaculo2() {
        return Obstaculo2;
    }

    /**
     * @param Obstaculo2 the Obstaculo2 to set
     */
    public void setObstaculo2(Image Obstaculo2) {
        this.Obstaculo2 = Obstaculo2;
    }
}
