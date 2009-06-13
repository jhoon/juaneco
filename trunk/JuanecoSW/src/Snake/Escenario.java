/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snake;

import Snake.util.SnakeUtil;
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
    private int puntaje;
    private int dimensiones;
    private int nivel;
    private Image Tipo1;
    private Image Tipo3;
    private Image Tipo2;
    private Image Boss;
    private Image fondo;
    private boolean fin;

    Random rnd = new Random();
//private Image fondoPant;
    private Image nuevoJuego;
    private Image ayuda;
    private Image opciones;
    private int lado = 240;
    private int[][] posesc = new int[lado / 16][lado / 16]; // posicion escenario
    private int[] posx = new int[lado / 16];
    private int[] posy = new int[lado / 16];

    public Escenario(int getWidth) {
        super();
        this.setLado(getWidth);
        try {
            juaneco.cargaim();
            animal.cargaanimal();
            bono.cargabono();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public void inicializa(boolean bandera) throws IOException {
        if (bandera == true) {
            this.setFondo(SnakeUtil.createImage("/costaFondo.jpg"));
        }
        if (bandera == false) {
            this.setFondo(SnakeUtil.createImage("/fondoGame.jpg"));
        }
        for (int i = 0; i < lado / 16; i++) {
            for (int j = 0; j < lado / 16; j++) {
                posx[i] = (8 + 16 * i);
                posy[j] = 16 + 16 * j;
                posesc[i][j] = 0;}
        }
    }
            

    public void inicializa() {
        try {
            if (nivel == 0) {
                this.setFondo(SnakeUtil.createImage("/fondoGame.jpg"));
            } else if (nivel == 1) {
                this.setFondo(SnakeUtil.createImage("/costa.jpg"));
                this.obsta1.inicializar(1, posesc);
            } else if (nivel == 2) {
                this.setFondo(SnakeUtil.createImage("/sierra.jpg"));
                this.obsta1.inicializar(2, posesc);
            } else if (nivel == 3) {
                this.setFondo(SnakeUtil.createImage("/selva.jpg"));
                this.obsta1.inicializar(3, posesc);
            } else if (nivel == 4) {
                this.setFondo(SnakeUtil.createImage("/selva.jpg"));

            }
            for (int i = 0; i < lado / 16; i++) {
                for (int j = 0; j < lado / 16; j++) {
                    posx[i] = (8 + 16 * i);
                    posy[j] = 16 + 16 * j;
                    posesc[i][j] = 0;
                }
            }

            posesc[8][8] = 1;   /*La posicion i=8, j=8 es la cabeza*/
            agregaTronco(8, 9, 3); // Aumenta la cola
            // posesc[8][9] = 9;     /*La posicion i=8, j=9 es el tronco en horizontal*/
            animal.apareceanimal(rnd, posesc, lado, 12);
            animal.setPuntaje(20);
            bono.setPuntaje(50);
            bono.setTiempo(100);
            juaneco.setVelocidad(80);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void movotronco(int mov) {
        boolean Condicion = false;
        int x;
        int y;
        int xx;
        int yy;
        int movi;
        int movii;
        int moviant;
        int cabezax = 0;
        int cabezay = 0;
        for (int i = 0; i < (this.getLado() / 16); i++) {
            for (int j = 0; j < (this.getLado() / 16); j++) {
                if (posesc[i][j] == 1) {
                    // Se busca la cabeza anterior
                    switch (mov) {
                        //si se movio izq, quiero la posicion q estaba a la derecha
                        case 1:
                            cabezax = i + 1;
                            cabezay = j;
                            break;
                        //si se movio der, quiero la posicion q estaba a la izq
                        case 2:
                            cabezax = i - 1;
                            cabezay = j;
                            break;
                        //si se movio arr, quiero la posicion q estaba abajo
                        case 3:
                            cabezax = i;
                            cabezay = j + 1;
                            break;
                        //si se movio aba, quiero la posicion q estaba arriba
                        case 4:
                            cabezax = i;
                            cabezay = j - 1;
                            break;
                    }
                    Condicion = true;
                    break;
                }
            }

            if (Condicion) {
                break;
            }
        }


        for (int i = (juaneco.getTronquitoXY().capacity() - 1); i > 0; i--) {
            //saca las posiciones del movimiento anterior
            x = ((ElementoJuego) juaneco.getTronquitoXY().elementAt(i - 1)).getPosicionX();
            y = ((ElementoJuego) juaneco.getTronquitoXY().elementAt(i - 1)).getPosicionY();
            movi = ((ElementoJuego) juaneco.getTronquitoXY().elementAt(i - 1)).getDireccion();
            // Asigna dichas posiciones
            ((ElementoJuego) juaneco.getTronquitoXY().elementAt(i)).setPosicionX(x);
            ((ElementoJuego) juaneco.getTronquitoXY().elementAt(i)).setPosicionY(y);
            ((ElementoJuego) juaneco.getTronquitoXY().elementAt(i)).setDireccion(movi);

        }
        ((ElementoJuego) juaneco.getTronquitoXY().elementAt(0)).setPosicionX(cabezax);
        ((ElementoJuego) juaneco.getTronquitoXY().elementAt(0)).setPosicionY(cabezay);

        ((ElementoJuego) juaneco.getTronquitoXY().elementAt(0)).setDireccion(mov);

        //Volvemos a limpiar la matriz colocandole valor 0 solo si encuentra tronco
        for (int k = 0; k < (getLado() / 16); k++) {
            for (int m = 0; m < (getLado() / 16); m++) {
                if (posesc[k][m] >= 2 & posesc[k][m] <= 11) {
                    posesc[k][m] = 0;
                }
            }
        }
        // Colocamos los nuevos valores
        for (int i = 0; i < (juaneco.getTronquitoXY().capacity()); i++) {
            xx = ((ElementoJuego) juaneco.getTronquitoXY().elementAt(i)).getPosicionX();
            yy = ((ElementoJuego) juaneco.getTronquitoXY().elementAt(i)).getPosicionY();
            movii = ((ElementoJuego) juaneco.getTronquitoXY().elementAt(i)).getDireccion();
            if (i == (juaneco.getTronquitoXY().capacity() - 1)) {
                switch (movii) {
                    case 1: {
                        posesc[xx][yy] = 10;
                        break;
                    }
                    case 2: {
                        posesc[xx][yy] = 11;
                        break;
                    }
                    case 3: {
                        posesc[xx][yy] = 9;
                        break;
                    }
                    case 4: {
                        posesc[xx][yy] = 8;
                        break;
                    }

                }
            } else if (movii == 1 || movii == 2) {
                posesc[xx][yy] = 2;
            } else if (movii == 3 || movii == 4) {
                posesc[xx][yy] = 3;

            }//Caso 4: Codo Down-R / R-Up
            if (i < (juaneco.getTronquitoXY().capacity() - 1)) {
                moviant = ((ElementoJuego) juaneco.getTronquitoXY().elementAt(i + 1)).getDireccion();
                if (moviant != movii) {
                    if (((moviant == 4) & (movii == 1)) | ((moviant == 2) & (movii == 3))) {
                        posesc[xx][yy] = 5; // Caso 5: Codo Up-L / L-Down
                    }
                    if (((moviant == 4) & (movii == 2)) | ((moviant == 1) & (movii == 3))) {
                        posesc[xx][yy] = 7;// Caso 7: Codo Up - R / R - Down
                    }
                    if (((moviant == 3) & (movii == 1)) | ((moviant == 2) & (movii == 4))) {
                        posesc[xx][yy] = 6;// Caso 6: Codo Down - L / R -Up
                    }
                    if (((moviant == 3) & (movii == 2)) | ((moviant == 1) & (movii == 4))) {
                        posesc[xx][yy] = 4;// Caso 4: Codo Down-R / L-Up
                    }


                }
            }


        }


    }

    public void agregaTronco(int i, int j, int mov) {
        // Se encarga de juntar el tronco con la cabeza
        int xTronco = 0;
        int yTronco = 0;
        if (juaneco.getTronquitoXY().capacity() > 0) {

            ElementoJuego aux = (ElementoJuego) juaneco.getTronquitoXY().lastElement();
            switch (aux.getDireccion()) {
                case 1:
                    xTronco = aux.getPosicionX() + 1;
                    yTronco = aux.getPosicionY();
                    break;
                case 2:
                    xTronco = aux.getPosicionX() - 1;
                    yTronco = aux.getPosicionY();
                    break;
                case 3:
                    xTronco = aux.getPosicionX();
                    yTronco = aux.getPosicionY() + 1;
                    break;
                case 4:
                    xTronco = aux.getPosicionX();
                    yTronco = aux.getPosicionY() - 1;
                    break;
            }
            juaneco.getTronquitoXY().addElement(new ElementoJuego(xTronco, yTronco, aux.getDireccion()));
        } else {
            juaneco.getTronquitoXY().addElement(new ElementoJuego(i, j, mov));
        }
    }

    public void movcabeza(int mov, boolean cabeza, int movant, Random rnd) {

        bono.bontim(posesc, lado);
        puntaje = 0;
        cabeza = false;


        for (int i = 0; i < getLado() / 16; i++) {
            for (int j = 0; j < getLado() / 16; j++) {
                if (posesc[i][j] == 1) {
                    if (mov == 1) {
                        juaneco.setCabeza(juaneco.getCabezaIzq());
                        if (i == 0) {
                            this.setFin(true);
                        } else {
                            switch (posesc[i - 1][j]) {
                                case 0: {
                                    posesc[i - 1][j] = 1;
                                    posesc[i][j] = 0;

                                    break;
                                }
                                case 12: {
                                    setPuntaje(animal.getPuntaje() + getPuntaje());
                                    animal.apareceanimal(rnd, posesc, lado, 12);
                                    posesc[i - 1][j] = 1;
                                    posesc[i][j] = 0;
                                    agregaTronco(i, j, movant);
                                    bono.aparebono(rnd, posesc, lado);
                                    break;
                                }
                                case 13: {

                                    setPuntaje(bono.getPuntaje() + getPuntaje());
                                    posesc[i - 1][j] = 1;
                                    posesc[i][j] = 0;
                                    agregaTronco(i, j, movant);

                                    break;
                                }
                                default: {
                                    this.setFin(true);
                                    break;
                                }
                            }
                        }
                        movant = mov;
                        cabeza = true;
                        break;
                    } else if (mov == 2) {
                        juaneco.setCabeza(juaneco.getCabezaDer());
                        if (i == (getLado() / 16 - 1)) {
                            this.setFin(true);
                        } else {
                            switch (posesc[i + 1][j]) {
                                case 0: {
                                    posesc[i + 1][j] = 1;
                                    posesc[i][j] = 0;
                                    break;
                                }
                                case 12: {
                                    setPuntaje(animal.getPuntaje() + getPuntaje());
                                    animal.apareceanimal(rnd, posesc, lado, 12);
                                    posesc[i + 1][j] = 1;
                                    posesc[i][j] = 0;
                                    agregaTronco(i, j, movant);
                                    bono.aparebono(rnd, posesc, lado);
                                    break;
                                }
                                case 13: {
                                    setPuntaje(bono.getPuntaje() + getPuntaje());
                                    posesc[i + 1][j] = 1;
                                    posesc[i][j] = 0;
                                    agregaTronco(i, j, movant);
                                    break;
                                }
                                default: {
                                    this.setFin(true);
                                    break;
                                }
                            }
                        }
                        movant = mov;
                        cabeza = true;
                        break;
                    } else if (mov == 3) {
                        juaneco.setCabeza(juaneco.getCabezaArr());
                        if (j == 0) {
                            this.setFin(true);
                        } else {
                            switch (posesc[i][j - 1]) {
                                case 0: {
                                    posesc[i][j - 1] = 1;
                                    posesc[i][j] = 0;
                                    break;
                                }
                                case 12: {
                                    setPuntaje(animal.getPuntaje() + getPuntaje());
                                    animal.apareceanimal(rnd, posesc, lado, 12);
                                    posesc[i][j - 1] = 1;
                                    posesc[i][j] = 0;
                                    agregaTronco(i, j, movant);
                                    bono.aparebono(rnd, posesc, lado);
                                    break;
                                }
                                case 13: {
                                    setPuntaje(bono.getPuntaje() + getPuntaje());
                                    posesc[i][j - 1] = 1;
                                    posesc[i][j] = 0;
                                    agregaTronco(i, j, movant);
                                    break;
                                }
                                default: {
                                    this.setFin(true);
                                    break;
                                }
                            }
                        }
                        movant = mov;
                        cabeza = true;
                        break;
                    } else if (mov == 4) {
                        juaneco.setCabeza(juaneco.getCabezaAba());
                        if (j == (getLado() / 16 - 1)) {
                            this.setFin(true);
                        } else {
                            switch (posesc[i][j + 1]) {
                                case 0: {
                                    posesc[i][j + 1] = 1;
                                    posesc[i][j] = 0;
                                    break;
                                }
                                case 12: {
                                    setPuntaje(animal.getPuntaje() + getPuntaje());
                                    animal.apareceanimal(rnd, posesc, lado, 12);
                                    posesc[i][j + 1] = 1;
                                    posesc[i][j] = 0;
                                    agregaTronco(i, j, mov);
                                    bono.aparebono(rnd, posesc, lado);
                                    break;
                                }
                                case 13: {
                                    setPuntaje(bono.getPuntaje() + getPuntaje());

                                    posesc[i][j + 1] = 1;
                                    posesc[i][j] = 0;
                                    agregaTronco(i, j, mov);

                                    break;
                                }
                                default: {
                                    this.setFin(true);
                                    break;
                                }
                            }
                        }
                        movant = mov;
                        cabeza = true;
                        break;
                    }
                }

            }
            if (cabeza) {
                break;

            }
        }
        
    }

    public void dibuja(Graphics g) {
        g.drawImage(this.getFondo(), lado / 2, 290, Graphics.HCENTER | Graphics.BOTTOM);
        for (int i = 0; i <
                getLado() / 16; i++) {
            for (int j = 0; j <
                    lado / 16; j++) {
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

    public int getBorde() {
        return borde;
    }

    public void setBorde(int borde) {
        this.borde = borde;
    }

    public int getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(int dimensiones) {
        this.dimensiones = dimensiones;
    }

    public Image getFondo() {

        return fondo;
    }

    public void setFondo(Image fondo) {
        this.fondo = fondo;
    }

    public Image getNuevoJuego() {
        return nuevoJuego;
    }

    public void setNuevoJuego(Image nuevoJuego) {
        this.nuevoJuego = nuevoJuego;
    }

    public Image getAyuda() {
        return ayuda;
    }

    public void setAyuda(Image ayuda) {
        this.ayuda = ayuda;
    }

    public Image getOpciones() {
        return opciones;
    }

    public void setOpciones(Image opciones) {
        this.opciones = opciones;
    }

    public Image getTipo2() {
        return Tipo2;
    }

    public void setTipo2(Image Tipo2) {
        this.Tipo2 = Tipo2;
    }

    public int getLado() {
        return lado;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }

    public boolean isFin() {
        return fin;
    }

    public void setFin(boolean fin) {
        this.fin = fin;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
//<<<<<<< .mine

//=======

    /**
     * @return the nivel
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * @param nivel the nivel to set
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    /**
     * @return the Tipo1
     */
    public Image getTipo1() {
        return Tipo1;
    }

    /**
     * @param Tipo1 the Tipo1 to set
     */
    public void setTipo1(Image Tipo1) {
        this.Tipo1 = Tipo1;
    }

    /**
     * @return the Tipo3
     */
    public Image getTipo3() {
        return Tipo3;
    }

    /**
     * @param Tipo3 the Tipo3 to set
     */
    public void setTipo3(Image Tipo3) {
        this.Tipo3 = Tipo3;
    }

    /**
     * @return the Boss
     */
    public Image getBoss() {
        return Boss;
    }

    /**
     * @param Boss the Boss to set
     */
    public void setBoss(Image Boss) {
        this.Boss = Boss;
    }
//>>>>>>> .r54
}
