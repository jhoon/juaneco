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

    public Animales() {
        super();
    }

    public void cargaanimal(int tipo) {
        Random a = new Random();
        if (tipo == 0) {
            tipo = (a.nextInt(2) + 1);
        }
        if (tipo == 1) {
            this.setFigura(SnakeUtil.createImage("/vizcacha.jpg"));
        } else if (tipo == 2) {
            this.setFigura(SnakeUtil.createImage("/cuy.jpg"));
        } else if (tipo == 3) {
            this.setFigura(SnakeUtil.createImage("/raton.jpg"));
        } else if (tipo == 4) {
            this.setFigura(SnakeUtil.createImage("/barril.jpg"));
        }


    }

    public void apareceanimal(Random rnd, int posesc[][], int lado, int tipo) {
        int a;
        int b;
        while (true) {
            a = rnd.nextInt(lado / 16 - 2) + 1;
            b = rnd.nextInt(lado / 16 - 2) + 1;
            if ((posesc[a][b] == 0) && (posesc[a + 1][b] == 0) && (posesc[a - 1][b] == 0) && (posesc[a][b + 1] == 0) && (posesc[a][b - 1] == 0)) {
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
}
