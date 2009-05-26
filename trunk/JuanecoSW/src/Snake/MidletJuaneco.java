/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Snake;

import javax.microedition.midlet.MIDlet;
import javax.microedition.lcdui.Display;

/**
 * @author Manuel Sotelo A
 */
public class MidletJuaneco extends MIDlet {

    private Canvas gamecanvas;

    public MidletJuaneco(){
    gamecanvas = new Canvas();

    }

    public void startApp() {
    Display display = Display.getDisplay(this);
    gamecanvas.start();
    display.setCurrent(gamecanvas);

    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {

    }
}
