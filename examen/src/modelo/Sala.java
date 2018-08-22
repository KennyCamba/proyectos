/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import excepciones.BookingException;
import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public class Sala {
    private String nombreSala;
    private int capacidad;
    private ArrayList<Asiento> asientos;
    
    private Sala(){
    
    }
    public Sala(String nombreSala){
        this.nombreSala = nombreSala;
        asientos = new ArrayList<>();
        for(int i=0; i<12; i++){
            for(int j=0; j<15; j++){
                asientos.add(new Asiento(i, j, true));
            }
        }
    }

    public String getNombreSala() {
        return nombreSala;
    }

    public void setNombreSala(String nombreSala) {
        this.nombreSala = nombreSala;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public ArrayList<Asiento> getAsientos() {
        return asientos;
    }

    public void setAsientos(ArrayList<Asiento> asientos) {
        this.asientos = asientos;
    }
        
    public void resevarAsiento(int fila, int columna){
        for(Asiento asiento: asientos){
            if(asiento.getFila() == fila && asiento.getColumna() == columna){
                if(!asiento.isEstado())
                    asiento.setEstado(false);
            }
        }
    }
}
