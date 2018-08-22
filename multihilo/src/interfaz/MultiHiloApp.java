/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Kenny Camba
 */
public class MultiHiloApp extends Application {
    
    PaneOrganizer pane;
    
    @Override
    public void start(Stage stage) {
        pane = new PaneOrganizer();
        Scene scene = new Scene(pane.getRoot(), 600, 230);
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void stop() {
        pane.detenerHilos();
    }
    
}
