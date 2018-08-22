
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Municipio de Gye
 */
interface Guerrero{
    abstract int getFuerza() throws Exception;
  }
  interface Saiyajin extends Guerrero{
    int nivel();
  }
  public class Jugador implements Saiyajin,Serializable{
    public static final boolean estaVivo = true;
    public int fuerza;
   @Override
   public int getFuerza() throws Exception {
     return fuerza;
   }
   public boolean equals(Saiyajin obj) {
     if(obj.nivel()== 3){
       return true;
     }
     return false;
   }

    @Override
    public int nivel() {
        return 0;
    }
 }

