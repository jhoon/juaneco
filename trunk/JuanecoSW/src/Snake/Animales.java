/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Snake;
import java.io.IOException;
import java.util.Random;
import javax.microedition.lcdui.Image;
/**
 *
 * @author Manuel Sotelo A
 */
public class Animales extends Personajes{
private int puntaje;
private int animal;
private int visibilidad;
private Image figura;
private Image animal1;
private Image animal2;
private Image animal3;

public Animales(){
super();
}

public void cargaanimal() throws IOException{
            this.setAnimal1(Image.createImage(Canvas.class.getResourceAsStream("/vizcacha.gif")));
            this.setAnimal2(Image.createImage(Canvas.class.getResourceAsStream("/cuy.gif")));
            this.setAnimal3(Image.createImage(Canvas.class.getResourceAsStream("/raton.gif")));


            this.setFigura(this.getAnimal1());

    }
public void primeranimal(Random rnd, int posesc[][], int lado){
if ((posesc[rnd.nextInt(lado / 16)][rnd.nextInt(lado / 16)] != 1) & (posesc[rnd.nextInt(lado / 16)][rnd.nextInt(lado / 16)] != 2) & (posesc[rnd.nextInt(lado / 16)][rnd.nextInt(lado / 16)] != 3)) {
                posesc[1 + rnd.nextInt(lado / 16 - 2)][1 + rnd.nextInt(lado / 16 - 2)] = 12;
            }

}
    /**
     * @return the puntaje
     */
    public int getPuntaje() {
        return puntaje;
    }

    /**
     * @param puntaje the puntaje to set
     */
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    /**
     * @return the animal
     */
    public int getAnimal() {
        return animal;
    }

    /**
     * @param animal the animal to set
     */
    public void setAnimal(int animal) {
        this.animal = animal;
    }

    /**
     * @return the visibilidad
     */
    public int getVisibilidad() {
        return visibilidad;
    }

    /**
     * @param visibilidad the visibilidad to set
     */
    public void setVisibilidad(int visibilidad) {
        this.visibilidad = visibilidad;
    }

    /**
     * @return the figura
     */
    public Image getFigura() {
        return figura;

    }

    /**
     * @param figura the figura to set
     */
    public void setFigura(Image figura) {
        this.figura = figura;
    }

    /**
     * @return the animal1
     */
    public Image getAnimal1() {
        return animal1;
    }

    /**
     * @param animal1 the animal1 to set
     */
    public void setAnimal1(Image animal1) {
        this.animal1 = animal1;
    }

    /**
     * @return the animal2
     */
    public Image getAnimal2() {
        return animal2;
    }

    /**
     * @param animal2 the animal2 to set
     */
    public void setAnimal2(Image animal2) {
        this.animal2 = animal2;
    }

    /**
     * @return the animal3
     */
    public Image getAnimal3() {
        return animal3;
    }

    /**
     * @param animal3 the animal3 to set
     */
    public void setAnimal3(Image animal3) {
        this.animal3 = animal3;
    }


}
