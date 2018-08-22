package CircleAnimation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author rociomera
 */
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.util.Duration;
 
public class OrganizerCircleBounds{
    
    //main timeline
    private Timeline timeline;
    private Pane root;
    private AnimationTimer timer;
    private StackPane stack;
    private Text text;
    private Integer i=0;
 
    public OrganizerCircleBounds(){
        root = new Pane();

        //create a circle with effect
        final Circle circle = new Circle(20,  Color.rgb(156,216,255));
        circle.setEffect(new Lighting());

        //create a text element
        text = new Text (i.toString());
        text.setStroke(Color.BLACK);

        //create a layout for circle with text inside
        stack = new StackPane();
        stack.getChildren().addAll(circle, text);
        stack.setLayoutX(150);
        stack.setLayoutY(150);
        root.getChildren().add(stack);
        
        
        // init timeline
        timeline = new Timeline();
        timeline.setCycleCount( Timeline.INDEFINITE );
        timeline.setAutoReverse( false );
        setAnimation();
    }
    
    public Pane getRoot(){
        return root;
    }
    
    private void setAnimation(){
        
        //cambiamos la posicion de la esfera dentro del panel
        //usando los metodo setLayoutX y setLayoutY
        stack.setLayoutX((java.lang.Math.random()*100)+100);
        stack.setLayoutY((java.lang.Math.random()*100)+100);

        //cambiamos las dimensiones del circulo con el método setScaleX
        //y setScaleY
        double scale = ((java.lang.Math.random()*2)+1);
        stack.setScaleX(scale);
        stack.setScaleY(scale);

        //actualizamos el texto del circulo
        i = i+1;
        text.setText(String.valueOf(i));
        
        
        //1) Creamos los KeyValues
        //creamos un keyValue asociado con la propiedad layaoutX de nuestro imageView
        //el valor final de la propiedad será 500
        KeyValue kvx = new KeyValue(stack.layoutXProperty(),500);
        //creamos un keyValue asociado con la propiedad layaoutY de nuestro imageView
        //el valor final de la propiedad será 500
        KeyValue kvy = new KeyValue(stack.layoutYProperty(),450);
        
        //2) creamos un KeyFrame que dura 4 segundo
        //   que tiene asociado los KeyValues kvx y kvy
        //   cuando se termina de ejecutar el KeyFrame se llama nuevamente al metodo
        //   setAnimation para reiniciar el timeline con los nuevos KeyValues
        KeyFrame kf1 = new KeyFrame(Duration.seconds(2), e -> setAnimation(),kvx,kvy);
        
        // restart timeline with new values
        timeline.stop();
        timeline.getKeyFrames().clear();
        timeline.getKeyFrames().add(kf1);
        //iniciamos la animacion nuevamente
        timeline.play();
    }
    
    //Event class that specific an action when the keyframe is reached
    //her we changes the properties of the node we want to changes
    private class AnimateCircleHandle implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            
        }
    }
} 
