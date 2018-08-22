/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClockAnimation;

import java.util.Date;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 *
 * @author rociomera
 */
public class OrganizerClockAnimation {
    private VBox _root;
    private Label _label;

    public OrganizerClockAnimation(){
        _root = new VBox();
        _label = new Label();
        _root.getChildren().add(_label);
        setupTimeline();
    }

    public VBox getRoot() {
            return _root;
    }

    public void setupTimeline(){
        //creamos una nueva instancia del keyFrame
        //pasamos al constructor la duracion del keyframe Duration.seconds(1)
        //y el manejador que cambiará el contenido del label con la hora actual
        //cuando la duracion del KeyFrame se cumpla
        KeyFrame kf = new KeyFrame(Duration.seconds(1),
                                    new TimeHandler());
        
        //creamos una nueva instancia del timeline
        Timeline timeline = new Timeline(kf);
        //fijamos el número de ciclos,
        //en este caso Animation.INDEFINITE para que se repita infinitamente
        timeline.setCycleCount(Animation.INDEFINITE);
        //iniciamos la animacion
        timeline.play();
    }

    private class TimeHandler implements EventHandler<ActionEvent>{
        public void handle(ActionEvent event){
            Date now = new Date();
            _label.setText(now.toString());
        }
    } 

}
