/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;

/**
 *
 * @author Administrador
 */
public class Proyeccion {
    private String horaInicio;
    private String horaFin;
    private Pelicula pelicula;
    private Sala sala;
    private LocalDate date;

    public Proyeccion(String horaInicio, String horaFin, Pelicula pelicula, Sala sala, LocalDate date) {
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.pelicula = pelicula;
        this.sala = sala;
        this.date = date;
    }

    
    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj != null){
            if(obj.getClass() == Proyeccion.class){
                Proyeccion p = (Proyeccion)obj;
                if(this.getDate().equals(p.date)&&
                       this.horaFin.equals(p.horaFin)&&
                        this.horaInicio.equals(p.horaInicio)&&
                        this.pelicula.equals(p.pelicula)){
                    return true;
                }
            }
        }
        return false;
    }
    
    @Override
    public String toString(){
        return date.toString() + " " + horaInicio;
    }
}
