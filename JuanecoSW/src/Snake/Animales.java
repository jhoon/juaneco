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
public class Animales extends Personajes{
private int puntaje;
private int animal;
private int visibilidad;
private Image figura;

public Animales(){
super();
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


}
