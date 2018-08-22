package CircleAnimation;


import ClockAnimation.OrganizerClockAnimation;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rociomera
 */
public class CircleBoundAnimation extends Application{
    @Override
    public void start(Stage stage) {
        OrganizerCircleBounds organizer = new OrganizerCircleBounds();
        Scene scene = new Scene(organizer.getRoot(), 500, 500);

        stage.setScene(scene);
        stage.setTitle("CIRCLE ANIMATION");	
        stage.show();
    }
    
    public static void main(String[] args) { 
        Application.launch(args);
    }

}
