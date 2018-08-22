/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import excepciones.BookingException;
import java.time.LocalDate;
import java.util.ArrayList;
import modelo.Asiento;
import modelo.Cliente;
import modelo.Pelicula;
import modelo.Proyeccion;
import modelo.Reserva;
import modelo.Sala;

/**
 *
 * @author Administrador
 */
public class ReservaApp {
    public static ArrayList<Proyeccion> proyecciones = new ArrayList<>();
    public static ArrayList<Pelicula> peliculas = new ArrayList<>();
    public static ArrayList<Reserva> reservas = new ArrayList<>();
    
    public static void inicializarApp(){
        Pelicula p1 = new Pelicula("Pelicula1", "img1.jpg");
        Pelicula p2 = new Pelicula("Batman", "img2.jpg");
        Pelicula p3 = new Pelicula("Monos", "img3.jpg");
        peliculas.add(p1);
        peliculas.add(p2);
        peliculas.add(p3);
        
        proyecciones.add(
                new Proyeccion("10:00", "12:00", 
                       p1, 
                        new Sala("Sala 1"), LocalDate.now()));
        proyecciones.add(
                new Proyeccion("10:00", "12:00", 
                        p2, 
                        new Sala("Sala 2"), LocalDate.now()));
        proyecciones.add(
                new Proyeccion("12:00", "14:00", 
                        p3, 
                        new Sala("Sala 2"), LocalDate.now()));
        //reservas.add(new Reserva);
    }
    
    public static ArrayList<Proyeccion> buscarProyeccionesPorPeliculas(Pelicula p){
        ArrayList<Proyeccion> result = new ArrayList<>();
        for(Proyeccion proyeccion: proyecciones){
            if(proyeccion.getPelicula().equals(p))
                result.add(proyeccion);
        }
        return result;
    }
    
    public static void hacerReservacion(Cliente cliente, Proyeccion proyeccion, ArrayList<Asiento> asientos) 
            throws BookingException {
        Sala sala = proyeccion.getSala();
        for(Asiento asiento: asientos){
            for(Asiento asiento2: sala.getAsientos()){
                if(asiento.getColumna() == asiento2.getColumna() && asiento.getFila() == asiento2.getFila()){
                    if(asiento2.isEstado()){
                        sala.resevarAsiento(asiento.getFila(), asiento.getColumna());
                        reservas.add(new Reserva(cliente, asientos));
                    }else{
                        throw new BookingException("Asiento " + asiento2 + " no disponible");
                    }
                }else{
                     throw new BookingException("No existe el asiento");
                }
            }
        }       
    }
}
