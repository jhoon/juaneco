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
public class Bonos extends Animales {

    private int tiempo;
    private int aparece;
    private Image bono;

    public Bonos() {
        super();
    }

    public void cargabono(int tipo) {
        Random a = new Random();
        if (tipo == 0) {
            tipo = (a.nextInt(2) + 1);
        }
        if (tipo == 1) {
            this.setBono(SnakeUtil.createImage("/gallito.jpg"));
        } else if (tipo == 2) {
            this.setBono(SnakeUtil.createImage("/conejo.jpg"));
        } else if (tipo == 3) {
            this.setBono(SnakeUtil.createImage("/gato.jpg"));
        }
    }

    public void bontim(int posesc[][], int lado) {
        for (int i = 0; i < (lado / 16); i++) {
            for (int j = 0; j < (lado / 16); j++) {
                if (posesc[i][j] == 13) {
                    this.setTiempo(this.getTiempo() - 1);
                    if (this.getTiempo() == 0) {
                        posesc[i][j] = 0;
                    }
                }
            }
        }
    }

    public void aparebono(Random rnd, int posesc[][], int lado) {
        this.setAparece(this.getAparece() + 1);
        if (this.getAparece() == 6) {
            this.apareceanimal(rnd, posesc, lado, 13);
            this.setAparece(0);
            this.setTiempo(62);
        }
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

    public int getAparece() {
        return aparece;
    }

    /**
     * @param aparece the aparece to set
     */
    public void setAparece(int aparece) {
        this.aparece = aparece;
    }
}
