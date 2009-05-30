/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snake;

import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;

/**
 *
 * @author Manuel Sotelo A
 */
public class Juaneco extends Personajes {

    private Image cabeza;
    private Image cabezaIzq;
    private Image cabezaDer;
    private Image cabezaArr;
    private Image cabezaAba;
    private Image tronco;
    private Image troncoH;
    private Image troncoV;
    private Image cola;
    private Image colaIzq;
    private Image colaDer;
    private Image colaArr;
    private Image colaAba;
    private int Velocidad;
    private int Incremento;

    public Juaneco() {
        super();
    }

    public void movder(int borde) {
        switch (borde) {
            case 0: {
                if (this.getPosicionX() <= 240) {
                    this.setPosicionX(this.getPosicionX() + 10);
                } else {
                    this.setPosicionX(0);
                }
                break;
            }

            case 1: {
                if (this.getPosicionX() <= 240) {
                    this.setPosicionX(this.getPosicionX() + 10);
                }
                break;
            }
        }
    }

    public void movizq(int borde) {
        switch (borde) {
            case 0: {
                if (this.getPosicionX() >= 0) {
                    this.setPosicionX(this.getPosicionX() - 10);
                } else {
                    this.setPosicionX(240);
                }
                break;
            }

            case 1: {
                if (this.getPosicionX() >= 0) {
                    this.setPosicionX(this.getPosicionX() - 10);
                }
                break;
            }
        }
    }

    public void movup(int borde) {
        switch (borde) {
            case 0: {
                if (this.getPosicionY() >= 0) {
                    this.setPosicionY(this.getPosicionY() - 10);
                } else {
                    this.setPosicionY(290);
                }
                break;
            }

            case 1: {
                if (this.getPosicionY() >= 0) {
                    this.setPosicionY(this.getPosicionX() - 10);
                }
                break;
            }
        }
    }

    public void movdwn(int borde) {
        switch (borde) {
            case 0: {
                if (this.getPosicionY() <= 290) {
                    this.setPosicionY(this.getPosicionY() + 10);
                } else {
                    this.setPosicionY(0);
                }
                break;
            }

            case 1: {
                if (this.getPosicionY() <= 290) {
                    this.setPosicionY(this.getPosicionX() + 10);
                }
                break;
            }
        }
    }

    /**
     * @return the Velocidad
     */
    public int getVelocidad() {
        return Velocidad;
    }

    /**
     * @param Velocidad the Velocidad to set
     */
    public void setVelocidad(int Velocidad) {
        this.Velocidad = Velocidad;
    }

    /**
     * @return the Incremento
     */
    public int getIncremento() {
        return Incremento;
    }

    /**
     * @param Incremento the Incremento to set
     */
    public void setIncremento(int Incremento) {
        this.Incremento = Incremento;
    }

    /**
     * @return the cabeza
     */
    public Image getCabeza() {
        return cabeza;
    }

    /**
     * @param cabeza the cabeza to set
     */
    public void setCabeza(Image cabeza) {
        this.cabeza = cabeza;
    }

    /**
     * @return the tronco
     */
    public Image getTronco() {
        return tronco;
    }

    /**
     * @param tronco the tronco to set
     */
    public void setTronco(Image tronco) {
        this.tronco = tronco;
    }

    /**
     * @return the cola
     */
    public Image getCola() {
        return cola;
    }

    /**
     * @param cola the cola to set
     */
    public void setCola(Image cola) {
        this.cola = cola;
    }

    /**
     * @return the cabezaIzq
     */
    public Image getCabezaIzq() {
        return cabezaIzq;
    }

    /**
     * @param cabezaIzq the cabezaIzq to set
     */
    public void setCabezaIzq(Image cabezaIzq) {
        this.cabezaIzq = cabezaIzq;
    }

    /**
     * @return the cabezaDer
     */
    public Image getCabezaDer() {
        return cabezaDer;
    }

    /**
     * @param cabezaDer the cabezaDer to set
     */
    public void setCabezaDer(Image cabezaDer) {
        this.cabezaDer = cabezaDer;
    }

    /**
     * @return the cabezaArr
     */
    public Image getCabezaArr() {
        return cabezaArr;
    }

    /**
     * @param cabezaArr the cabezaArr to set
     */
    public void setCabezaArr(Image cabezaArr) {
        this.cabezaArr = cabezaArr;
    }

    /**
     * @return the cabezaAba
     */
    public Image getCabezaAba() {
        return cabezaAba;
    }

    /**
     * @param cabezaAba the cabezaAba to set
     */
    public void setCabezaAba(Image cabezaAba) {
        this.cabezaAba = cabezaAba;
    }

    /**
     * @return the troncoH
     */
    public Image getTroncoH() {
        return troncoH;
    }

    /**
     * @param troncoH the troncoH to set
     */
    public void setTroncoH(Image troncoH) {
        this.troncoH = troncoH;
    }

    /**
     * @return the troncoV
     */
    public Image getTroncoV() {
        return troncoV;
    }

    /**
     * @param troncoV the troncoV to set
     */
    public void setTroncoV(Image troncoV) {
        this.troncoV = troncoV;
    }

    /**
     * @return the colaIzq
     */
    public Image getColaIzq() {
        return colaIzq;
    }

    /**
     * @param colaIzq the colaIzq to set
     */
    public void setColaIzq(Image colaIzq) {
        this.colaIzq = colaIzq;
    }

    /**
     * @return the colaDer
     */
    public Image getColaDer() {
        return colaDer;
    }

    /**
     * @param colaDer the colaDer to set
     */
    public void setColaDer(Image colaDer) {
        this.colaDer = colaDer;
    }

    /**
     * @return the colaArr
     */
    public Image getColaArr() {
        return colaArr;
    }

    /**
     * @param colaArr the colaArr to set
     */
    public void setColaArr(Image colaArr) {
        this.colaArr = colaArr;
    }

    /**
     * @return the colaAba
     */
    public Image getColaAba() {
        return colaAba;
    }

    /**
     * @param colaAba the colaAba to set
     */
    public void setColaAba(Image colaAba) {
        this.colaAba = colaAba;
    }
}
