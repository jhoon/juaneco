/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Snake;
import javax.microedition.lcdui.Image;

/**
 *
 * @author Manuel Sotelo A
 */
public class Obstaculos extends ElementoJuego {
private Image Obstaculo;
private int tipo;
private int tamano;

public Obstaculos(){
super();
}

    /**
     * @return the tipo
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

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

}
