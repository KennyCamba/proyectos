/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import hilos.ExamenHilo;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Kenny Camba
 */
public class PaneOrganizer {
    private VBox root;
    private TextArea textA1;
    private TextArea textA2;
    private Button start;
    private Button stop;
    private ExamenHilo eh1;
    private ExamenHilo eh2;
    
    public PaneOrganizer(){
        root = new VBox();
        ponerTitulo();
        paneBotones();
        paneTextArea();
        addEventosBotones();
    }
    
    public void ponerTitulo(){
        Label label = new Label("Aplicacion Multihilo");
        root.getChildren().add(label);
    }
    
    public void paneBotones(){
        HBox hbox = new HBox();
        start = new Button("Empezar");
        stop = new Button("Detener");
        hbox.getChildren().addAll(start, stop);
        root.getChildren().add(hbox);
    }
    
    public void paneTextArea(){
        HBox content = new HBox();
        textA1 = new TextArea();
        textA2 = new TextArea(); 
        content.getChildren().addAll(textA1, textA2);
        root.getChildren().add(content);
    }
    
    public VBox getRoot(){
        return root;
    }

    private void addEventosBotones() {
        start.setOnAction(e -> {
            eh1 = new ExamenHilo(textA1, 3);
            eh2 = new ExamenHilo(textA2, 5);
            Thread t1 = new Thread(eh1);
            Thread t2 = new Thread(eh2);
            t1.start();
            t2.start();
        });
        
        stop.setOnAction(e -> {
            detenerHilos();
            Platform.exit();
        }); 
    }
    
    public void detenerHilos(){
        if(eh1 != null && eh2 != null){
                eh1.parar();
                eh2.parar();
            }
    }
}
