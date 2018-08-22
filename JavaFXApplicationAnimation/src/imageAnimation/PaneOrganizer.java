/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageAnimation;

import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 *
 * @author rociomera
 */
public class PaneOrganizer {
    private Pane _root;
    private Target target;
    private Random random;
    
    public PaneOrganizer(){
        random = new Random();
        _root = new Pane();
        target = new Target();
        
        //agrego el imageView del target al root container
        _root.getChildren().add(target.getPersonaje());
        target.moverPersonaje(200, 100);
        
        //fijamos accion al imageView para que cuando se le de click cambie su posicion
        animarPersonaje();
    }
    
    public Pane getRoot(){
        return _root;
    }
    
    public void animarPersonaje(){
        
        //evento llamado cuando se termina la animacion
        EventHandler ef = new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //al finalizar la animacion mover el target a una nueva posicion
                //fijar su tamano a uno nuevamente
                double x = random.nextInt(400);
                double y = random.nextInt(400);
                target.moverPersonaje(x, y);
            }  
        };
        
        //creamos un keyValue asociado con la propiedad layaoutX de nuestro imageView
        //el valor final de la propiedad será 500
        KeyValue kvx = new KeyValue(target.getPersonaje().layoutXProperty(),500);
        //creamos un keyValue asociado con la propiedad layaoutY de nuestro imageView
        //el valor final de la propiedad será 500
        KeyValue kvy = new KeyValue(target.getPersonaje().layoutYProperty(),450);
        //creamos un KeyFrame que dura 4 segundo que tiene asociado los KeyValues kvx y kvy
        KeyFrame kf1 = new KeyFrame(Duration.seconds(4), ef, kvx,kvy);
        
        //creamos un keyValue asociado con la propiedad scaleX de nuestro imageView
        KeyValue kvsx = new KeyValue(target.getPersonaje().scaleXProperty(),2.5);
        //creamos un keyValue asociado con la propiedad scaley de nuestro imageView
        KeyValue kvsY = new KeyValue(target.getPersonaje().scaleYProperty(),2);
        //creamos un KeyFrame que dura 1 segundo que tiene asociado los KeyValues kvsx y kvsY
        KeyFrame kf2 = new KeyFrame(Duration.seconds(3), kvsx,kvsY);
        
        //creamos el Timeline
        Timeline tl = new Timeline(kf1);
        //fijamos que se repita la animacion 10 veces
        tl.setCycleCount(5);
        //fijamos AutoReverse a false
        tl.setAutoReverse(false);
        //iniciamos la animacion
        tl.play();
    }
    
    
}
