/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snake;

import Snake.util.SnakeUtil;
import java.util.Random;
import javax.microedition.lcdui.Image;

/**
 *
 * @author Manuel Sotelo A
 */
public class Animales extends Personajes {

    private int puntaje;
    private int animal;
    private int visibilidad;
    private Image figura;
    private Image animal1;
    private Image animal2;
    private Image animal3;

    public Animales() {
        super();
    }

    public void cargaanimal() {
        this.setAnimal1(SnakeUtil.createImage("/vizcacha.gif"));
        this.setAnimal2(SnakeUtil.createImage("/cuy.gif"));
        this.setAnimal3(SnakeUtil.createImage("/raton.gif"));
        this.setFigura(this.getAnimal2());
    }

    public void apareceanimal(Random rnd, int posesc[][], int lado, int tipo) {
        int a;
        int b;
        while (true) {
            a = rnd.nextInt(lado / 16 - 1);
            b = rnd.nextInt(lado / 16 - 1);
            if (posesc[a][b] == 0) {
                posesc[a][b] = tipo;
                break;
            }
        }
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public int getAnimal() {
        return animal;
    }

    public void setAnimal(int animal) {
        this.animal = animal;
    }

    public int getVisibilidad() {
        return visibilidad;
    }

    public void setVisibilidad(int visibilidad) {
        this.visibilidad = visibilidad;
    }

    public Image getFigura() {
        return figura;

    }

    public void setFigura(Image figura) {
        this.figura = figura;
    }

    public Image getAnimal1() {
        return animal1;
    }

    public void setAnimal1(Image animal1) {
        this.animal1 = animal1;
    }

    public Image getAnimal2() {
        return animal2;
    }

    public void setAnimal2(Image animal2) {
        this.animal2 = animal2;
    }

    public Image getAnimal3() {
        return animal3;
    }

    public void setAnimal3(Image animal3) {
        this.animal3 = animal3;
    }
}
