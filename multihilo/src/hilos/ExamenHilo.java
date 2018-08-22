/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.control.TextArea;

/**
 *
 * @author Kenny Camba
 */
public class ExamenHilo implements Runnable {
    
    private TextArea textArea;
    private int conteo;
    private boolean estado;
    private int i;
    
    public ExamenHilo(TextArea textArea, int conteo){
        this.textArea = textArea;
        this.conteo = conteo;
        i = 0;
    }
    
    @Override
    public void run(){
        while(!estado){
            Platform.runLater(new Runnable(){
                @Override
                public void run() {
                    textArea.setText(textArea.getText()+String.format("%d\n", i));
                    i += conteo;
                }
            });
            esperar();
        }
    }
    
    private void esperar(){
        try { 
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(ExamenHilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void parar() {
        estado = true;
    }
}
