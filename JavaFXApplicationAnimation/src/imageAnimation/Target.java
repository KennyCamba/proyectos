/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageAnimation;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author rociomera
 */
public class Target {
    private ImageView personaje;
    private String imagenFile;
    private static String IMAGE_DEFAULT = "bandido.png";
    
    public Target(){
        this(IMAGE_DEFAULT);
    }
    
    public Target(String ruta){
        imagenFile=CONSTANTES.path_image+"/"+ruta;
        Image img =new Image(imagenFile,
                            80,
                            80,
                            true,
                            true);
        personaje = new ImageView(img);
    }
    
    public ImageView getPersonaje(){
        return personaje;
    }
    
    public void moverPersonaje(double x,double y){
        personaje.setLayoutX(x);
        personaje.setLayoutY(y);
    }
}
