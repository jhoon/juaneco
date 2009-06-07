/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Snake;

/**
 *
 * @author Manuel Sotelo A
 */
public class ElementoJuego {
private int PosicionX;
private int PosicionY;
private int direccion;
// ahora esto no indica las posiciones en pixeles, sino implica celda que ocpa en la matriz encontrada en el Canvas
public ElementoJuego(int x, int y, int di){
this.PosicionX = x;
this.PosicionY = y;
this.direccion = di;
}
public ElementoJuego(){


}
    /**
     * @return the PosicionX
     */
    public int getPosicionX() {
        return PosicionX;
    }

    /**
     * @param PosicionX the PosicionX to set
     */
    public void setPosicionX(int PosicionX) {
        this.PosicionX = PosicionX;
    }

    /**
     * @return the PosicionY
     */
    public int getPosicionY() {
        return PosicionY;
    }

    /**
     * @param PosicionY the PosicionY to set
     */
    public void setPosicionY(int PosicionY) {
        this.PosicionY = PosicionY;
    }

    /**
     * @return the direccion
     */
    public int getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }



}
