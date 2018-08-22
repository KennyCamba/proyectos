/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rectangleMoving;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author rociomera
 */
public class rectangleMoving extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane p = new Pane();
        Rectangle rect = new Rectangle(50,60);
        rect.setFill(Color.AQUA);
        rect.setX(100);
        rect.setY(100);
        p.getChildren().add(rect);
        
        Scene scene = new Scene(p, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("RECTANGLE ANIMATION");	
        primaryStage.show();
        
        //KeyValue asociado con la propiedad scale del rectangulo
        //el valor inicial es 1 y el valor final es 2
        KeyValue kvx = new KeyValue(rect.scaleXProperty(),2);
        KeyValue kvy = new KeyValue(rect.scaleYProperty(),2);
        
        //creamos un KeyFrame de 2 segundos de duracion asociado con los KeyValues
        //kvx y kvy
        KeyFrame kf = new KeyFrame(Duration.seconds(2),kvx,kvy);
        
        //creamos el Timeline
        Timeline tl = new Timeline(kf);
        //fijamos que se repita la animacion 10 veces
        tl.setCycleCount(5);
        //fijamos AutoReverse a false
        tl.setAutoReverse(false);
        //iniciamos la animacion
        tl.play();
    }
    
    public static void main(String[] args) { 
        Application.launch(args);
    }
}
