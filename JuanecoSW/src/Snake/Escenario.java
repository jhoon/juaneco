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
public class Escenario {
private int borde;
private int dimensiones;
private int tipoesc;
private Image fondo;

public Escenario(){
super();

}

    /**
     * @return the borde
     */
    public int getBorde() {
        return borde;
    }

    /**
     * @param borde the borde to set
     */
    public void setBorde(int borde) {
        this.borde = borde;
    }

    /**
     * @return the dimensiones
     */
    public int getDimensiones() {
        return dimensiones;
    }

    /**
     * @param dimensiones the dimensiones to set
     */
    public void setDimensiones(int dimensiones) {
        this.dimensiones = dimensiones;
    }

    /**
     * @return the tipoesc
     */
    public int getTipoesc() {
        return tipoesc;
    }

    /**
     * @param tipoesc the tipoesc to set
     */
    public void setTipoesc(int tipoesc) {
        this.tipoesc = tipoesc;
    }

    /**
     * @return the fondo
     */
    public Image getFondo() {
        return fondo;
    }

    /**
     * @param fondo the fondo to set
     */
    public void setFondo(Image fondo) {
        this.fondo = fondo;
    }


}
