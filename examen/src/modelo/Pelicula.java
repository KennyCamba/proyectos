/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Objects;

/**
 *
 * @author Administrador
 */
public class Pelicula {
    private String titulo;
    private String pathImage;

    public Pelicula(String titulo, String pathImage) {
        this.titulo = titulo;
        this.pathImage = pathImage;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj != null){
            if(obj.getClass() == Pelicula.class){
                Pelicula p = (Pelicula)obj;
                if(this.getPathImage().equals(p.pathImage) && this.titulo.equals(p.titulo)){
                    return true;
                }
            }
        }
        return false;
    }
    
    @Override
    public String toString(){
        return titulo;
    }
    
    
}
