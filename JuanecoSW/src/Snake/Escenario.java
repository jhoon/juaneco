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
//private Image fondoPant;
private Image nuevoJuego;
private Image ayuda;
private Image opciones;


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

    /**
     * @return the nuevoJuego
     */
    public Image getNuevoJuego() {
        return nuevoJuego;
    }

    /**
     * @param nuevoJuego the nuevoJuego to set
     */
    public void setNuevoJuego(Image nuevoJuego) {
        this.nuevoJuego = nuevoJuego;
    }

    /**
     * @return the ayuda
     */
    public Image getAyuda() {
        return ayuda;
    }

    /**
     * @param ayuda the ayuda to set
     */
    public void setAyuda(Image ayuda) {
        this.ayuda = ayuda;
    }

    /**
     * @return the opciones
     */
    public Image getOpciones() {
        return opciones;
    }

    /**
     * @param opciones the opciones to set
     */
    public void setOpciones(Image opciones) {
        this.opciones = opciones;
    }


}
