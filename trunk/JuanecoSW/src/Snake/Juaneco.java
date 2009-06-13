/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snake;

import Snake.util.SnakeUtil;
import java.io.IOException;
import java.util.Vector;
import javax.microedition.lcdui.Image;

/**
 *
 * @author Manuel Sotelo A
 */
public class Juaneco extends Personajes {

    private Vector tronquitoXY = new Vector(0, 1);
    private Image cabeza;
    private Image cabezaIzq;
    private Image cabezaDer;
    private Image cabezaArr;
    private Image cabezaAba;
    private Image troncoH;
    private Image troncoV;
    private Image colaIzq;
    private Image colaDer;
    private Image colaArr;
    private Image colaAba;
    private Image codo1;
    private Image codo2;
    private Image codo3;
    private Image codo4;
    private int Velocidad;
    private int Incremento;

    public Juaneco() {
        super();
    }

    public void cargaim() throws IOException {
        this.setCabezaIzq(SnakeUtil.createImage("/cabeza1.gif"));
        this.setCabezaAba(SnakeUtil.createImage("/cabeza4.gif"));
        this.setCabezaDer(SnakeUtil.createImage("/cabeza3.gif"));
        this.setCabezaArr(SnakeUtil.createImage("/cabeza2.gif"));
        this.setTroncoH(SnakeUtil.createImage("/cuerpoh.gif"));
        this.setTroncoV(SnakeUtil.createImage("/cuerpov.gif"));
        this.setCodo1(SnakeUtil.createImage("/cod1.gif"));
        this.setCodo2(SnakeUtil.createImage("/cod2.gif"));
        this.setCodo3(SnakeUtil.createImage("/cod3.gif"));
        this.setCodo4(SnakeUtil.createImage("/cod4.gif"));
        this.setColaDer(SnakeUtil.createImage("/col1.gif"));
        this.setColaAba(SnakeUtil.createImage("/col2.gif"));
        this.setColaIzq(SnakeUtil.createImage("/col3.gif"));
        this.setColaArr(SnakeUtil.createImage("/col4.gif"));
        this.setCabeza(this.getCabezaArr());

    }

    public int getVelocidad() {
        return Velocidad;
    }

    public void setVelocidad(int Velocidad) {
        this.Velocidad = Velocidad;
    }

    public int getIncremento() {
        return Incremento;
    }

    public void setIncremento(int Incremento) {
        this.Incremento = Incremento;
    }

    public Image getCabeza() {
        return cabeza;
    }

    public void setCabeza(Image cabeza) {
        this.cabeza = cabeza;
    }

    public Image getCabezaIzq() {
        return cabezaIzq;
    }

    public void setCabezaIzq(Image cabezaIzq) {
        this.cabezaIzq = cabezaIzq;
    }

    public Image getCabezaDer() {
        return cabezaDer;
    }

    public void setCabezaDer(Image cabezaDer) {
        this.cabezaDer = cabezaDer;
    }

    public Image getCabezaArr() {
        return cabezaArr;
    }

    public void setCabezaArr(Image cabezaArr) {
        this.cabezaArr = cabezaArr;
    }

    public Image getCabezaAba() {
        return cabezaAba;
    }

    public void setCabezaAba(Image cabezaAba) {
        this.cabezaAba = cabezaAba;
    }

    public Image getTroncoH() {
        return troncoH;
    }

    public void setTroncoH(Image troncoH) {
        this.troncoH = troncoH;
    }

    public Image getTroncoV() {
        return troncoV;
    }

    public void setTroncoV(Image troncoV) {
        this.troncoV = troncoV;
    }

    public Image getColaIzq() {
        return colaIzq;
    }

    public void setColaIzq(Image colaIzq) {
        this.colaIzq = colaIzq;
    }

    public Image getColaDer() {
        return colaDer;
    }

    public void setColaDer(Image colaDer) {
        this.colaDer = colaDer;
    }

    public Image getColaArr() {
        return colaArr;
    }

    public void setColaArr(Image colaArr) {
        this.colaArr = colaArr;
    }

    public Image getColaAba() {
        return colaAba;
    }

    public void setColaAba(Image colaAba) {
        this.colaAba = colaAba;
    }

    public Image getCodo1() {
        return codo1;
    }

    public void setCodo1(Image codo1) {
        this.codo1 = codo1;
    }

    public Image getCodo2() {
        return codo2;
    }

    public void setCodo2(Image codo2) {
        this.codo2 = codo2;
    }

    public Image getCodo3() {
        return codo3;
    }

    public void setCodo3(Image codo3) {
        this.codo3 = codo3;
    }

    public Image getCodo4() {
        return codo4;
    }

    public void setCodo4(Image codo4) {
        this.codo4 = codo4;
    }

    public Vector getTronquitoXY() {
        return tronquitoXY;
    }

    public void setTronquitoXY(Vector tronquitoXY) {
        this.tronquitoXY = tronquitoXY;
    }
}