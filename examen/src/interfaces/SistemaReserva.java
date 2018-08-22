/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import app.ReservaApp;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Administrador
 */
public class SistemaReserva extends Application {
    
    @Override
    public void start(Stage stage) {
        ReservaApp.inicializarApp();
        Scene scene = new Scene(new PaneOrganizer().getRoot(), 800, 600);
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
