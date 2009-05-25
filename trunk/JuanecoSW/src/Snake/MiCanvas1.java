/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Snake;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.GameCanvas;
import java.io.IOException;

/**
 *
 * @author Manuel Sotelo A
 */
public class MiCanvas1 extends GameCanvas implements Runnable {
private int tiempo_ms = 50;
private int mov;
Juaneco juaneco = new Juaneco();
public final int centrox = getWidth()/2;
public final int centroy = getHeight()/2;
Escenario escenario = new Escenario();




 public MiCanvas1() {
 super(true);

 }
public void start() {
try{


//Se cargan las imagenes de la cabeza de Juaneco por cada punto cardinal
juaneco.setCabezaIzq(Image.createImage(MiCanvas1.class.getResourceAsStream("/worm2.gif")));
juaneco.setCabezaAba(Image.createImage(MiCanvas1.class.getResourceAsStream("/worm3.gif")));
juaneco.setCabezaDer(Image.createImage(MiCanvas1.class.getResourceAsStream("/worm4.gif")));
juaneco.setCabezaArr(Image.createImage(MiCanvas1.class.getResourceAsStream("/worm1.gif")));

//Se carga la cabeza principal de juaneco como la cabezaIzq para empezar
juaneco.setCabeza(juaneco.getCabezaIzq());

juaneco.setPosicionX(centrox);
juaneco.setPosicionY(centroy);
escenario.setBorde(0);

}
catch(IOException e){
System.err.println(e);
}
Thread hilo = new Thread (this);

hilo.start ();
}

public void run(){
Graphics g = getGraphics();

    while (true){

verifyGameState();

checkUserInput();

updateGameScreen(getGraphics());
        try {
        Thread.sleep(tiempo_ms);
        }catch (InterruptedException e ){
        e.printStackTrace();
        }
    }
}

private void checkUserInput(){

int estado_boton = getKeyStates();

cambio_coor(estado_boton);
if (mov == 1){
juaneco.movizq(escenario.getBorde());
juaneco.setCabeza(juaneco.getCabezaIzq());
}

if (mov == 2){
juaneco.movder(escenario.getBorde());
juaneco.setCabeza(juaneco.getCabezaDer());
}
if (mov == 3){

juaneco.movup(escenario.getBorde());
juaneco.setCabeza(juaneco.getCabezaArr());


}
if (mov == 4){

juaneco.movdwn(escenario.getBorde());
juaneco.setCabeza(juaneco.getCabezaAba());

}

}

private void verifyGameState(){


}

private void updateGameScreen(Graphics g){
g.setColor(0xffffff);
g.fillRect(0, 0, getWidth(), getHeight());

g.drawImage(juaneco.getCabeza(),juaneco.getPosicionX() , juaneco.getPosicionY(), Graphics.HCENTER|Graphics.BOTTOM);


flushGraphics();

}

private void cambio_coor (int estado_boton){

if ((estado_boton &LEFT_PRESSED) != 0){
if (mov != 2) {
    juaneco.movizq(escenario.getBorde());
    mov = 1;
}
} else if ((estado_boton &RIGHT_PRESSED) != 0){
if (mov != 1) {
    juaneco.movder(escenario.getBorde());
    mov = 2;
}
} else if ((estado_boton &UP_PRESSED) != 0){
if (mov != 4) {
    juaneco.movup(escenario.getBorde());
    mov = 3;
}
} else if ((estado_boton &DOWN_PRESSED) != 0){
if (mov != 3) {
    juaneco.movdwn(escenario.getBorde());
    mov = 4;
}
}

}
}
