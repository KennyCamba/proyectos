/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClockAnimation;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author rociomera
 */
public class ClockAnimation extends Application{
    @Override
    public void start(Stage stage) {
        OrganizerClockAnimation organizer = new OrganizerClockAnimation();
        Scene scene = new Scene(organizer.getRoot(), 200, 200);

        stage.setScene(scene);
        stage.setTitle("Clock");	
        stage.show();
    }
    
    public static void main(String[] args) { 
        Application.launch(args);
    }
}
