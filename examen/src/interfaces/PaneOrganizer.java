/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import app.ReservaApp;
import excepciones.BookingException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modelo.Asiento;
import modelo.Cliente;
import modelo.Pelicula;
import modelo.Proyeccion;

/**
 *
 * @author Administrador
 */
public class PaneOrganizer {
    private VBox root;
    private ComboBox<Pelicula> peliculas;
    private ComboBox<Proyeccion> proyecciones;
    private Pelicula pelicula;
    private ImageView img;
    private TextField clienteText;
    private TextField CedulaText;
    private Button button;
    private Proyeccion proyec;
    private ArrayList<Asiento> asientoSeleccionado;
    
    public PaneOrganizer(){
        root = new VBox();
        asientoSeleccionado = new ArrayList<>();
        peliculas = new ComboBox<>();
        proyecciones = new ComboBox<>();
        content1();
        content2();
        content3();
        content4();
        acctions();
    }
    
    public void content1(){
        
        peliculas.getItems().addAll(FXCollections.observableList(ReservaApp.peliculas));
        HBox hbox = new HBox();
        hbox.getChildren().addAll(new Label("Pelicula: "), peliculas);
//        img = new ImageView();
//        img.setFitHeight(100);
//        img.setFitWidth(100); 
//        hbox.getChildren().add(img);
        root.getChildren().add(hbox);
    }
    
    public void content2(){
        HBox hbox = new HBox();
        hbox.getChildren().addAll(new Label("Proyecciones: "), proyecciones);
        root.getChildren().add(hbox);
    }
    
    public void content3(){
        clienteText = new TextField();
        CedulaText = new TextField();
        HBox hbox = new HBox();
        hbox.getChildren().addAll(new Label("Cliente: "), clienteText,
        new Label("Cedula: "), CedulaText);
        root.getChildren().add(hbox);
    }
    
    public void content4(){
        button = new Button("Reservar");
        root.getChildren().add(button);
    }
    
    public void acctions(){
        peliculas.setOnAction(e ->{
            actionPeliculas();
        });
        
        button.setOnAction(e ->{
            button.setVisible(false);
            GridPane grid = new GridPane();
            grid.setHgap(5);
            grid.setVgap(5);
            for(Asiento a: proyec.getSala().getAsientos()){
                Button b;
                if(a.isEstado()){
                    b = new Button("R");
                    b.setDisable(true);
                }else{
                    b = new Button("D");
                    
                }
                b.setOnAction(evts->{
                    if(b.getText().equals("D")){
                        b.setText("X");
                        asientoSeleccionado.add(a);
                    }else{
                        b.setText("D");
                        asientoSeleccionado.remove(a);
                    }
                });
                
              
                grid.add(b, a.getColumna(), a.getFila());
                
            }
              Button reservar = new Button("Reservar");
              grid.add(reservar, 0, 12, 20, 1); 
            reservar.setOnAction(es->{
                try {
                    ReservaApp.hacerReservacion(new Cliente("", "", ""), proyec, asientoSeleccionado);
                } catch (BookingException ex) {
                    Logger.getLogger(PaneOrganizer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }); 
            root.getChildren().add(grid);
        }); 
    }
    
    
    public VBox getRoot(){
        return this.root;
    }
    public void actionPeliculas(){
        proyecciones.getItems().clear();
            pelicula = peliculas.getSelectionModel().getSelectedItem();
//            img.setImage(new Image("src/imagenes/img.jpg")); 
            proyecciones.getItems().addAll(FXCollections.observableList(
                    ReservaApp.buscarProyeccionesPorPeliculas(pelicula)));
            
            proyecciones.setOnAction(evt -> {
                actionProyec();
            }); 
    }
    
    public void actionProyec(){
        proyec = proyecciones.getSelectionModel().getSelectedItem();
    }
}
