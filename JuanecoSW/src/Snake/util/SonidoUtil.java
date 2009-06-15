package Snake.util;

import javax.microedition.media.*;
import java.io.InputStream;

public class SonidoUtil {

    private String nombre;
    private String tipo;
    private Player player;

    public SonidoUtil(String tema, String tipo) throws Exception {
        this.nombre = tema;
        this.tipo = tipo;
        CrearPlayer(nombre, tipo);
    }

    public void DestruirMidiPlayer() {
        if (player != null) {
            player.close();
            player = null;
        }
    }

    private void CrearPlayer(String File, String Formato) throws Exception {
        try {
            InputStream Is = getClass().getResourceAsStream(File);
            player = Manager.createPlayer(Is, Formato);
            player.prefetch();
        } catch (MediaException me) {
        }
    }

    private void EmpezarPlayer(Player P) {
        if (P != null) {
            try {
                P.stop();
                P.setMediaTime(0L);
                P.start();
            } catch (MediaException me) {
            }
        }
    }

    public void Mute() {
        if (player != null) {
            try {
                player.stop();
            } catch (Exception e) {
            }
        }
    }

    public void NoMute() {
        if (player != null) {
            try {
                player.start();
            } catch (Exception e) {
            }
        }
    }

    public Player getPlayer() {


        return player;
    }
}


