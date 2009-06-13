/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snake;

import javax.microedition.midlet.MIDlet;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.Choice;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.ImageItem;
import java.io.IOException;
import javax.microedition.lcdui.ChoiceGroup;

public class MidletJuaneco extends MIDlet implements CommandListener {

    private Command exitCommand;
    private Command okCommand;
    private Command okCommand1;
    private Command backCommand;
    private Command backCommand1;
    private Form historia;
    private Form creditos;
    private Form ayuda;
    private Form menu;
    private Form perdiste;
    private Form selvaSierra;
    private Form sierraCosta;
    private Form Boss;
    private StringItem stringItem;
    private StringItem alu1;
    private StringItem alu2;
    private StringItem alu3;
    private StringItem stHitoria;
    private StringItem stcreditos;
    private StringItem stayuda;
    private Image fondo;
    private ImageItem imagenAyuda;
    private Canvas gamecanvas;
    private ChoiceGroup lista;
    private ImageItem imagenMenu;
    private ImageItem imagenPerdi;
    private ImageItem ganaste;
    private ImageItem selvaysierra;
    private ImageItem sierraycosta;
    private ImageItem bossito;

    public MidletJuaneco() {
        //\ gamecanvas = new Canvas();
    }

    public void startApp() {


        cambiaPantalla(null, getMenu());

    //Display display = Display.getDisplay(this);
    //gamecanvas.start();
    //display.setCurrent(gamecanvas);



    }

    public void commandAction(Command command, Displayable displayable) {

        if (displayable == menu && command == okCommand) {
            listAction();
        } else if (displayable == menu && command == exitCommand) {
            exitMIDlet();
        } else if (displayable == historia && command == backCommand) {
            cambiaPantalla(null, getMenu());
        } else if (displayable == creditos && command == backCommand) {
            cambiaPantalla(null, getMenu());
        } else if (displayable == ayuda && command == backCommand) {
            cambiaPantalla(null, getMenu());
        } else if (displayable == perdiste && command == okCommand) {
            cambiaPantalla(null, getMenu());
        } else if (displayable == historia && command == okCommand) {
            gamecanvas = new Canvas(this);

            gamecanvas.getEscenario().setNivel(1);
            gamecanvas.start();
            
            cambiaPantalla(null, gamecanvas);
        }


    }

    public void cambiaPantalla(Alert alert, Displayable objetoMostrar) {
        Display pantallita = Display.getDisplay(this);

        if (alert == null) {

            pantallita.setCurrent(objetoMostrar);

        } else {

            pantallita.setCurrent(alert, objetoMostrar);
        }
    }

    public void listAction() {

        String opcionseleccionada = lista.getString(lista.getSelectedIndex());

        if (opcionseleccionada != null) {

            if (opcionseleccionada.equals("Nuevo Juego")) {

                gamecanvas = new Canvas(this);
            gamecanvas.getEscenario().setNivel(0);
                gamecanvas.start();
                
                cambiaPantalla(null, gamecanvas);

            } else if (opcionseleccionada.equals("Historia")) {

                cambiaPantalla(null, getHistoria());

            } else if (opcionseleccionada.equals("Creditos")) {

                cambiaPantalla(null, getCreditos());

            } else if (opcionseleccionada.equals("Ayuda")) {

                cambiaPantalla(null, getAyuda());
            }
        }

    }

    public Form getMenu() {
        if (menu == null) {
            menu = new Form("Menu Principal");
            lista = new ChoiceGroup("", Choice.EXCLUSIVE, new String[]{"Nuevo Juego", "Historia", "Creditos", "Ayuda"}, null);
            try {
                imagenMenu = new ImageItem("Juaneco Tour Por el Perú", Image.createImage("/maya1.jpg"), ImageItem.LAYOUT_BOTTOM, "FONDO");
            } catch (Exception e) {
            }
            stringItem = new StringItem("Menu Principal", "");
            //Font font = new Font();
            //stringItem.setFont(font)
            stringItem.setLayout(StringItem.LAYOUT_CENTER);
            menu.append(stringItem);
            menu.append(lista);
            menu.append(imagenMenu);
            menu.addCommand(getExitCommand());
            menu.addCommand(getOkCommand());
            menu.setCommandListener(this);

        }

        return menu;
    }

    public Form getPerdiste() {
        if (perdiste == null) {
            perdiste = new Form("GAME OVER!");
            try {
                imagenPerdi = new ImageItem("Perdiste", Image.createImage("/perdiste.jpg"), ImageItem.LAYOUT_BOTTOM, "PERDISTE");
            } catch (Exception e) {
            }
            perdiste.append(imagenPerdi);
            perdiste.addCommand(getOkCommand());
            perdiste.setCommandListener(this);

        }

        return perdiste;
    }

    public Form getSelvaSierra() {
        if (perdiste == null) {
            perdiste = new Form("GAME OVER!");
            try {
                imagenPerdi = new ImageItem("Perdiste", Image.createImage("/perdiste.jpg"), ImageItem.LAYOUT_BOTTOM, "PERDISTE");
            } catch (Exception e) {
            }
            perdiste.append(imagenPerdi);
            perdiste.addCommand(getOkCommand());
            perdiste.setCommandListener(this);

        }

        return perdiste;
    }

    public Form getSierraCosta() {
        if (sierraCosta == null) {
            sierraCosta = new Form("GAME OVER!");
            try {
                imagenPerdi = new ImageItem("Perdiste", Image.createImage("/perdiste.jpg"), ImageItem.LAYOUT_BOTTOM, "PERDISTE");
            } catch (Exception e) {
            }
            sierraCosta.append(imagenPerdi);
            sierraCosta.addCommand(getOkCommand());
            sierraCosta.setCommandListener(this);

        }

        return sierraCosta;
    }

    public Form getHistoria() {

        historia = new Form("Historia");
        stHitoria = new StringItem(" historia de juaneco", "");
        stHitoria.setLayout(StringItem.LAYOUT_CENTER);
        historia.append(stHitoria);
        historia.addCommand(getOkCommand());
        historia.addCommand(getBackCommand());
        historia.setCommandListener(this);

        return historia;
    }

    public Form getCreditos() {

        creditos = new Form("Creditos");
        stcreditos = new StringItem(" Alumnos ", "");
        stcreditos.setLayout(StringItem.LAYOUT_CENTER);
        creditos.append(stcreditos);
        alu1 = new StringItem(" Manuel Sotelo \n Diego Iparraguirre \n Maria Jesus Chamorro", "");
        alu1.setLayout(StringItem.LAYOUT_LEFT);
        creditos.append(alu1);
        creditos.addCommand(getBackCommand());
        creditos.setCommandListener(this);

        return creditos;
    }

    public Form getAyuda() {

        ayuda = new Form("Ayuda");
        stayuda = new StringItem(" Instrucciones de Juego", "");
        stayuda.setLayout(StringItem.LAYOUT_CENTER);
        try {
            imagenAyuda = new ImageItem("AYUDA", Image.createImage("/ayuda.jpg"), ImageItem.LAYOUT_BOTTOM, "AYUDA");
        } catch (Exception e) {
        }
        ayuda.append(stayuda);
        ayuda.append(imagenAyuda);
        ayuda.addCommand(getBackCommand());
        ayuda.addCommand(getOkCommand());
        ayuda.setCommandListener(this);

        return ayuda;
    }

    public Display getDisplay() {

        return Display.getDisplay(this);
    }

    public Command getOkCommand() {

        if (okCommand == null) {

            okCommand = new Command("Ok", Command.OK, 0);
        }

        return okCommand;
    }

    public Command getOkCommand1() {

        if (okCommand1 == null) {

            okCommand1 = new Command("Ok", Command.OK, 0);
        }

        return okCommand1;
    }

    public Command getExitCommand() {

        if (exitCommand == null) {

            exitCommand = new Command("Exit", Command.EXIT, 0);
        }
        return exitCommand;
    }

    public Command getBackCommand() {

        if (backCommand == null) {

            backCommand = new Command("Back", Command.BACK, 0);

        }

        return backCommand;
    }

    public Command getBackCommand1() {

        if (backCommand1 == null) {

            backCommand = new Command("Back", Command.BACK, 0);
        }

        return backCommand;
    }

    public void pauseApp() {
        try {
            gamecanvas.wait();
        //gCanvas.
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

    }

    public void destroyApp(boolean unconditional) {
    }

    private void exitMIDlet() {
        cambiaPantalla(null, null);
        destroyApp(true);
        notifyDestroyed();
    }

    public void setExitCommand(Command exitCommand) {
        this.exitCommand = exitCommand;
    }

    /**
     * @return the gamecanvas
     */
    public Canvas getGamecanvas() {
        return gamecanvas;
    }

    /**
     * @param gamecanvas the gamecanvas to set
     */
    public void setGamecanvas(Canvas gamecanvas) {
        this.gamecanvas = gamecanvas;
    }

    
}
