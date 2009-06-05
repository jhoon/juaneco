/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Snake;

/**
 *
 * @author Manuel Sotelo A
 */
public abstract class ElementoJuego {
private int PosicionX;
private int PosicionY;
// ahora esto no indica las posiciones en pixeles, sino implica celda que ocpa en la matriz encontrada en el Canvas
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



}
