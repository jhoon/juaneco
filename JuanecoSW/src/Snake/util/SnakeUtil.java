/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Snake.util;

import java.io.IOException;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;

/**
 *
 * @author Maya
 */
public class SnakeUtil {

    public static Image createImage(String url){
        try {
            return Image.createImage(SnakeUtil.class.getResourceAsStream(url));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static Sprite createSprite(String url,int frameWith,int frameHeigth){
        Image imagen=createImage(url);
        Sprite sprite=new Sprite(imagen,frameHeigth,frameWith);
        return sprite;
    }

    public static Sprite createSprite(String url,int frameWith,int frameHeigth,int x,int y){
        Sprite sprite=createSprite(url,frameHeigth,frameWith);
        sprite.setPosition(x, y);
        return sprite;
    }
    
}
