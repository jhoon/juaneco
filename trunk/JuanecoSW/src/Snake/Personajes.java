/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Snake;

/**
 *
 * @author Manuel Sotelo A
 */
public class  Personajes extends ElementoJuego{

    private int Estado;
private int Tamano;

public Personajes (){
super();
}



 
    /**
     * @return the Tamano
     */
    public int getTamano() {
        return Tamano;
    }

    /**
     * @param Tamano the Tamano to set
     */
    public void setTamano(int Tamano) {
        this.Tamano = Tamano;
    }

    /**
     * @return the Estado
     */
    public int getEstado() {
        return Estado;
    }

    /**
     * @param Estado the Estado to set
     */
    public void setEstado(int Estado) {
        this.Estado = Estado;
    }


}
