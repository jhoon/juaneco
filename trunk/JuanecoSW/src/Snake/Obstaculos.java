/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Snake;

/**
 *
 * @author Manuel Sotelo A
 */
public class Obstaculos extends Escenario {
private int tipo;
private int tamano;

public Obstaculos(){
super();
}

    /**
     * @return the tipo
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the tamano
     */
    public int getTamano() {
        return tamano;
    }

    /**
     * @param tamano the tamano to set
     */
    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

}
