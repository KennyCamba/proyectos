/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageAnimation;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 *
 * @author rociomera
 */
public class PaneOrganizer2 {
    private Pane _root;
    private Target target;
    private Random random;
    private int i=0;
    
    public PaneOrganizer2(){
        random = new Random();
        
        _root = new Pane();
        target = new Target();
        
        Button b = new Button("Start");
        b.setOnAction( (e) ->{
            crearPersonaje();
        });
        _root.getChildren().add(b);
        
        //agrego el imageView del target al root container
        _root.getChildren().add(target.getPersonaje());
        Point2D p = getRandomPos();
        target.moverPersonaje(p.getX(), p.getY());
        
        target.getPersonaje().setOnMouseClicked( (e) ->{
            //cuando doy click en la imagen debo mover la imagen a una nueva 
            //posicion aleatoria dentro del cuadro.
            animar();
        } );
        
        
        
    }
    
    public void crearPersonaje(){
        for(int i=0;i<10;i++){
            Target ti = new Target();
            Point2D pi = getRandomPos();
            _root.getChildren().add(ti.getPersonaje());
            ti.moverPersonaje(pi.getX(), pi.getY());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public Pane getRoot(){
        return _root;
    }
    
    private Point2D getRandomPos()
    {
        int x = random.nextInt(400);
        int y = random.nextInt(400);
        Point2D p = new Point2D(x,y);
        return p;
    }
    
    private void animar(){
        
        //Manejador de evento que llamaremos cuando se termine el KeyFrame
        EventHandler ev = new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                i++;
                target.getPersonaje().setScaleX(i);
                target.getPersonaje().setScaleY(i);
            }
        };
        
        Point2D p2 = getRandomPos();
        //creamos un keyValue asociado con la propiedad layaoutX de nuestro imageView
        //el valor final de la propiedad será el valor generado aleatoriamente
        KeyValue kvlx = new KeyValue(target.getPersonaje().layoutXProperty()
                                    ,p2.getX());
        //creamos un keyValue asociado con la propiedad layaoutY de nuestro imageView
        //el valor final de la propiedad será el valor generado aleatoriamente
        KeyValue kvly = new KeyValue(target.getPersonaje().layoutYProperty()
                                    ,p2.getY());
        //creamos un KeyFrame de duracion 4 sec, asociado a los KeyValues kvlx y kvly
        //y ejecuta el evento ev cuando se termina.
        KeyFrame kf = new KeyFrame(Duration.seconds(4),ev,kvlx,kvly);
        
        Timeline tl = new Timeline();
        tl.setCycleCount(1);
        tl.getKeyFrames().add(kf);
        tl.setAutoReverse(false);
        tl.play();
    }
    
}
