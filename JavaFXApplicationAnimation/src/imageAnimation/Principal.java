/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageAnimation;

import ClockAnimation.OrganizerClockAnimation;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author rociomera
 */
public class Principal extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        PaneOrganizer p = new PaneOrganizer();
        Scene scene = new Scene(p.getRoot(), 600, 600);

        primaryStage.setScene(scene);
        primaryStage.setTitle("animar personaje");	
        primaryStage.show();

    }
    
    public static void main( String[] args )
    {
        launch( args );
    }
}
