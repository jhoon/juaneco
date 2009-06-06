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
public class Bonos extends Animales {
private int tiempo;
private Image bono;
private Image bono1;
private Image bono2;
private Image bono3;

public Bonos()
{
super();
}
public void cargabono() throws IOException{
            this.setBono1(Image.createImage(Canvas.class.getResourceAsStream("/gallito.gif")));
            this.setBono2(Image.createImage(Canvas.class.getResourceAsStream("/conejo.gif")));
            this.setBono3(Image.createImage(Canvas.class.getResourceAsStream("/gato.gif")));


            this.setBono(this.getBono1());

    }

    /**
     * @return the tiempo
     */
    public int getTiempo() {
        return tiempo;
    }

    /**
     * @param tiempo the tiempo to set
     */
    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    /**
     * @return the bono
     */
    public Image getBono() {
        return bono;
    }

    /**
     * @param bono the bono to set
     */
    public void setBono(Image bono) {
        this.bono = bono;
    }

    /**
     * @return the bono1
     */
    public Image getBono1() {
        return bono1;
    }

    /**
     * @param bono1 the bono1 to set
     */
    public void setBono1(Image bono1) {
        this.bono1 = bono1;
    }

    /**
     * @return the bono2
     */
    public Image getBono2() {
        return bono2;
    }

    /**
     * @param bono2 the bono2 to set
     */
    public void setBono2(Image bono2) {
        this.bono2 = bono2;
    }

    /**
     * @return the bono3
     */
    public Image getBono3() {
        return bono3;
    }

    /**
     * @param bono3 the bono3 to set
     */
    public void setBono3(Image bono3) {
        this.bono3 = bono3;
    }
}
