package Snake;


import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;

public class MidletJuaneco extends MIDlet {


    private Canvas gamecanvas;

   

    public MidletJuaneco() {
         gamecanvas = new Canvas(this);


    }

    public void startApp() {


    Display display = Display.getDisplay(this);
    gamecanvas.start();
    display.setCurrent(gamecanvas);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    notifyDestroyed();
    }
}
