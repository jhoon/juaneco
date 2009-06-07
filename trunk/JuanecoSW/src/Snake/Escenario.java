/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snake;

import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import java.util.Random;

/**
 *
 * @author Manuel Sotelo A
 */
public class Escenario {

    Juaneco juaneco = new Juaneco();
    Obstaculos obsta1 = new Obstaculos();
    Bonos bono = new Bonos();
    Animales animal = new Animales();
    private int borde;
    private int dimensiones;
    private Image Tipo1;
    private Image Tipo3;
    private Image Tipo2;
    private Image fondo;
    private int cuenta;
    Random rnd = new Random();
//private Image fondoPant;
    private Image nuevoJuego;
    private Image ayuda;
    private Image opciones;
    private int lado = 240;
    private int[][] posesc = new int[lado / 16][lado / 16]; // posicion escenario
    private int[] posx = new int[lado / 16];
    private int[] posy = new int[lado / 16];

    public Escenario() {
        super();
        try {
            juaneco.cargaim();
            animal.cargaanimal();
            bono.cargabono();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void inicializa() throws IOException {
        this.setFondo(Image.createImage(Canvas.class.getResourceAsStream("/fondoGame.jpg")));
        for (int i = 0; i < getLado() / 16; i++) {
            for (int j = 0; j < getLado() / 16; j++) {
                posx[i] = (8 + 16 * i);
                posy[j] = 16 + 16 * j;
                posesc[i][j] = 0;
            }
        }

        posesc[8][8] = 1;   /*La posicion i=8, j=8 es la cabeza*/
        posesc[8][9] = 9;     /*La posicion i=8, j=9 es el tronco en horizontal*/
        animal.primeranimal(rnd, posesc, lado);
        juaneco.setVelocidad(100);

    }

    public void movotronco(int mov) {
        boolean Condicion = false;
        int x;
        int y;
        int xx;
        int yy;
        int movi;
        int movii;
        int cabezax = 0;
        int cabezay = 0;
        for (int i = 1; i < getLado() / 16; i++) {
            for (int j = 0; j < getLado() / 16; j++) {
                if (posesc[i][j] == 1) {
                    cabezax = i;
                    cabezay = j;
                    Condicion = true;
                    break;
                }

            }

            if (Condicion) {
                break;
            }
        }
        if ((mov ==1)|(mov==3))
        {}else{}

        for (int i = (juaneco.getTronquitoXY().capacity() - 2); i > 0; i--) {
            x = ((ElementoJuego) juaneco.getTronquitoXY().elementAt(i - 1)).getPosicionX();
            y = ((ElementoJuego) juaneco.getTronquitoXY().elementAt(i - 1)).getPosicionY();
           movi = ((ElementoJuego) juaneco.getTronquitoXY().elementAt(i - 1)).getDireccion();
            ((ElementoJuego) juaneco.getTronquitoXY().elementAt(i)).setPosicionX(x);
            ((ElementoJuego) juaneco.getTronquitoXY().elementAt(i)).setPosicionY(y);
            ((ElementoJuego) juaneco.getTronquitoXY().elementAt(i)).setPosicionY(movi);

        }
        ((ElementoJuego) juaneco.getTronquitoXY().elementAt(0)).setPosicionX(cabezax);
        ((ElementoJuego) juaneco.getTronquitoXY().elementAt(0)).setPosicionY(cabezay);
        

        for (int i = 0; i < (juaneco.getTronquitoXY().capacity() - 1); i++) {
            xx = ((ElementoJuego) juaneco.getTronquitoXY().elementAt(i)).getPosicionX();
            yy = ((ElementoJuego) juaneco.getTronquitoXY().elementAt(i)).getPosicionY();
            movii = ((ElementoJuego) juaneco.getTronquitoXY().elementAt(i)).getDireccion();
            
            posesc[xx][yy]=movii;
  



       
        }


    }

    public void movcabeza(int mov, boolean cabeza, int movant, int puntaje, Random rnd) {

        cabeza = false;
        if (mov == 1) {
            juaneco.setCabeza(juaneco.getCabezaIzq());
            for (int i = 1; i < getLado() / 16; i++) {
                for (int j = 0; j < getLado() / 16; j++) {

                    if (posesc[i][j] == 1) {

                        switch (posesc[i - 1][j]) {
                            case 0: {
                                posesc[i - 1][j] = 1;
                                posesc[i][j] = 0;
                                break;
                            }
                            case 12: {
                                puntaje = animal.getPuntaje() + puntaje;
                                animal.primeranimal(rnd, posesc, lado);
                                posesc[i - 1][j] = 1;
                                juaneco.getTronquitoXY().addElement(new ElementoJuego(i, j, 2 ));

                                break;
                            }

                            case 13: {
                                puntaje = animal.getPuntaje() + puntaje;

                                posesc[i - 1][j] = 1;

                                juaneco.getTronquitoXY().addElement(new ElementoJuego(i, j, 2 ));
                                break;
                            }

                        }


                        cabeza = true;
                        break;
                    }
                    if (cabeza) {
                        break;
                    }


                }
            }
        }
        if (mov == 2) {
            juaneco.setCabeza(juaneco.getCabezaDer());
            for (int i = 0; i < (getLado() / 16 - 1); i++) {
                for (int j = 0; j < getLado() / 16; j++) {
                    if (posesc[i][j] == 1) {
                        switch (posesc[i + 1][j]) {
                            case 0: {
                                posesc[i + 1][j] = 1;
                                posesc[i][j] = 0;
                                break;
                            }
                            case 12: {
                                puntaje = animal.getPuntaje() + puntaje;
                                posesc[1 + rnd.nextInt(lado / 16 - 2)][1 + rnd.nextInt(lado / 16 - 2)] = 13;
                                posesc[i + 1][j] = 1;
                                juaneco.getTronquitoXY().addElement(new ElementoJuego(i, j, 2 ));
                                break;

                            }

                            case 13: {
                                puntaje = bono.getPuntaje() + puntaje;
                                posesc[1 + rnd.nextInt(lado / 16 - 2)][1 + rnd.nextInt(lado / 16 - 2)] = 12;
                                posesc[i + 1][j] = 1;
                                juaneco.getTronquitoXY().addElement(new ElementoJuego(i, j, 2 ));
                                break;
                            }

                        }





                        cabeza = true;
                        break;
                    }
                }
                if (cabeza) {
                    break;
                }

            }

        }
        if (mov == 3) {
            juaneco.setCabeza(juaneco.getCabezaArr());
            for (int i = 0; i < getLado() / 16; i++) {
                for (int j = 1; j < getLado() / 16; j++) {



                    if (posesc[i][j] == 1) {
                        switch (posesc[i][j - 1]) {
                            case 0: {

                                posesc[i][j - 1] = 1;
                                posesc[i][j] = 0;
                                break;
                            }
                            case 12: {
                                puntaje = animal.getPuntaje() + puntaje;
                                posesc[1 + rnd.nextInt(lado / 16 - 2)][1 + rnd.nextInt(lado / 16 - 2)] = 13;

                                posesc[i][j - 1] = 1;
                                juaneco.getTronquitoXY().addElement(new ElementoJuego(i, j, 3 ));
                                break;
                            }

                            case 13: {
                                puntaje = bono.getPuntaje() + puntaje;
                                posesc[1 + rnd.nextInt(lado / 16 - 2)][1 + rnd.nextInt(lado / 16 - 2)] = 12;

                                posesc[i][j - 1] = 1;
                                juaneco.getTronquitoXY().addElement(new ElementoJuego(i, j, 3 ));
                                break;
                            }


                        }

                        mov = 3;
                        cabeza = true;
                        break;
                    }
                }
                if (cabeza) {
                    break;
                }
            }
        }
        if (mov == 4) {
            juaneco.setCabeza(juaneco.getCabezaAba());
            for (int i = 0; i < getLado() / 16; i++) {
                for (int j = 0; j < (getLado() / 16 - 1); j++) {
                    if (posesc[i][j] == 1) {
                        switch (posesc[i][j + 1]) {

                            case 0: {

                                posesc[i][j + 1] = 1;
                                posesc[i][j] = 0;
                                break;
                            }
                            case 12: {
                                puntaje = animal.getPuntaje() + puntaje;
                                posesc[1 + rnd.nextInt(lado / 16 - 2)][1 + rnd.nextInt(lado / 16 - 2)] = 13;
                                posesc[i][j + 1] = 1;
                                juaneco.getTronquitoXY().addElement(new ElementoJuego(i, j, 3 ));
                                break;
                            }

                            case 13: {
                                puntaje = bono.getPuntaje() + puntaje;
                                posesc[1 + rnd.nextInt(lado / 16 - 2)][ 1 + rnd.nextInt(lado / 16 - 2)] = 12;

                                posesc[i][j + 1] = 1;
                                juaneco.getTronquitoXY().addElement(new ElementoJuego(i, j, 3 ));
                                break;
                            }

                        }


                        cabeza = true;
                        break;
                    }
                    if (cabeza) {
                        break;
                    }
                }
            }

        }

    }

    public void dibuja(Graphics g) {
        g.drawImage(this.getFondo(), lado / 2, 290, Graphics.HCENTER | Graphics.BOTTOM);
        for (int i = 0; i <
                getLado() / 16; i++) {
            for (int j = 0; j < lado / 16; j++) {
                switch (posesc[i][j]) {

                    case 1: {
                        g.drawImage(juaneco.getCabeza(), posx[i], posy[j], Graphics.HCENTER | Graphics.BOTTOM);
                        break;

                    } // Caso 1: Cabeza

                    case 2: {
                        g.drawImage(juaneco.getTroncoH(), posx[i], posy[j], Graphics.HCENTER | Graphics.BOTTOM);
                        break;

                    }// Caso 2: Tronco Horizonal


                    case 3: {
                        g.drawImage(juaneco.getTroncoV(), posx[i], posy[j], Graphics.HCENTER | Graphics.BOTTOM);
                        break;

                    }// Caso 3: Tronco Vertial


                    case 4: {
                        g.drawImage(juaneco.getCodo1(), posx[i], posy[j], Graphics.HCENTER | Graphics.BOTTOM);
                        break;

                    }// Caso 4: Codo Down-R / R-Up


                    case 5: {
                        g.drawImage(juaneco.getCodo2(), posx[i], posy[j], Graphics.HCENTER | Graphics.BOTTOM);
                        break;

                    }// Caso 5: Codo Up-L / L-Down


                    case 6: {
                        g.drawImage(juaneco.getCodo3(), posx[i], posy[j], Graphics.HCENTER | Graphics.BOTTOM);
                        break;

                    }// Caso 6: Codo Down - L / L -Up


                    case 7: {
                        g.drawImage(juaneco.getCodo4(), posx[i], posy[j], Graphics.HCENTER | Graphics.BOTTOM);
                        break;

                    }// Caso 7: Codo Up - R / R - Down


                    case 8: {
                        g.drawImage(juaneco.getColaArr(), posx[i], posy[j], Graphics.HCENTER | Graphics.BOTTOM);
                        break;

                    }// Caso 8: Cola Arriba


                    case 9: {
                        g.drawImage(juaneco.getColaAba(), posx[i], posy[j], Graphics.HCENTER | Graphics.BOTTOM);
                        break;

                    }// Caso 9: Cola Abajo


                    case 10: {
                        g.drawImage(juaneco.getColaDer(), posx[i], posy[j], Graphics.HCENTER | Graphics.BOTTOM);
                        break;

                    }// Caso 10: Cola Derecha


                    case 11: {
                        g.drawImage(juaneco.getColaIzq(), posx[i], posy[j], Graphics.HCENTER | Graphics.BOTTOM);
                        break;

                    }// Caso 11: Cola Izquierda


                    case 12: {
                        g.drawImage(animal.getFigura(), posx[i], posy[j], Graphics.HCENTER | Graphics.BOTTOM);
                        break;

                    }// Caso 12: Animal


                    case 13: {
                        g.drawImage(bono.getBono(), posx[i], posy[j], Graphics.HCENTER | Graphics.BOTTOM);
                        break;

                    }// Caso 13: Bono


                    case 14: {
                        g.drawImage(obsta1.getObstaculo(), posx[i], posy[j], Graphics.HCENTER | Graphics.BOTTOM);
                        break;

                    }// Caso 15: Obstaculo 1


                    case 15: {
                        g.drawImage(obsta1.getObstaculo(), posx[i], posy[j], Graphics.HCENTER | Graphics.BOTTOM);
                        break;

                    }// Caso 15: Obstaculo 2

                    default: {
                        break;
                    }

                }
            }
        }
    }

    /**
     * @return the borde
     */
    public int getBorde() {
        return borde;
    }

    /**
     * @param borde the borde to set
     */
    public void setBorde(int borde) {
        this.borde = borde;
    }

    /**
     * @return the dimensiones
     */
    public int getDimensiones() {
        return dimensiones;
    }

    /**
     * @param dimensiones the dimensiones to set
     */
    public void setDimensiones(int dimensiones) {
        this.dimensiones = dimensiones;
    }

    /**
     * @return the fondo
     */
    public Image getFondo() {

        return fondo;
    }

    /**
     * @param fondo the fondo to set
     */
    public void setFondo(Image fondo) {
        this.fondo = fondo;
    }

    /**
     * @return the nuevoJuego
     */
    public Image getNuevoJuego() {
        return nuevoJuego;
    }

    /**
     * @param nuevoJuego the nuevoJuego to set
     */
    public void setNuevoJuego(Image nuevoJuego) {
        this.nuevoJuego = nuevoJuego;
    }

    /**
     * @return the ayuda
     */
    public Image getAyuda() {
        return ayuda;
    }

    /**
     * @param ayuda the ayuda to set
     */
    public void setAyuda(Image ayuda) {
        this.ayuda = ayuda;
    }

    /**
     * @return the opciones
     */
    public Image getOpciones() {
        return opciones;
    }

    /**
     * @param opciones the opciones to set
     */
    public void setOpciones(Image opciones) {
        this.opciones = opciones;
    }

    /**
     * @return the Tipo2
     */
    public Image getTipo2() {
        return Tipo2;
    }

    /**
     * @param Tipo2 the Tipo2 to set
     */
    public void setTipo2(Image Tipo2) {
        this.Tipo2 = Tipo2;
    }

    /**
     * @return the lado
     */
    public int getLado() {
        return lado;
    }

    /**
     * @param lado the lado to set
     */
    public void setLado(int lado) {
        this.lado = lado;
    }
}
