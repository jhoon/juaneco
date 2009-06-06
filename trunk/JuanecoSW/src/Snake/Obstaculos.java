/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Snake;
import java.io.IOException;
import javax.microedition.lcdui.Image;

/**
 *
 * @author Manuel Sotelo A
 */
public class Obstaculos extends ElementoJuego {
private Image Obstaculo;
private Image tipo1;
private Image tipo2;
private Image tipo3;
private int tamano;

public Obstaculos(){
super();
}
public void inicializar()  throws IOException {

            this.setTipo1(Image.createImage(Canvas.class.getResourceAsStream("/rat.jpg")));
            this.setTipo2(Image.createImage(Canvas.class.getResourceAsStream("/rat.jpg")));
            this.setTipo3(Image.createImage(Canvas.class.getResourceAsStream("/rat.jpg")));
            this.setObstaculo(this.getTipo1());


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
     * @return the tipo1
     */
    public Image getTipo1() {
        return tipo1;
    }

    /**
     * @param tipo1 the tipo1 to set
     */
    public void setTipo1(Image tipo1) {
        this.tipo1 = tipo1;
    }

    /**
     * @return the tipo2
     */
    public Image getTipo2() {
        return tipo2;
    }

    /**
     * @param tipo2 the tipo2 to set
     */
    public void setTipo2(Image tipo2) {
        this.tipo2 = tipo2;
    }

    /**
     * @return the tipo3
     */
    public Image getTipo3() {
        return tipo3;
    }

    /**
     * @param tipo3 the tipo3 to set
     */
    public void setTipo3(Image tipo3) {
        this.tipo3 = tipo3;
    }

}
