/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public class Reserva {
    private int nro_reserva;
    private Cliente cliente;
    private ArrayList<Asiento> asientos;
    public static int numero = 0;
    
    public Reserva(Cliente cliente,  ArrayList<Asiento> asientos){
        this.cliente = cliente;
        this.asientos = asientos;
        nro_reserva = numero++;
    }

    public int getNro_reserva() {
        return nro_reserva;
    }

    public void setNro_reserva(int nro_reserva) {
        this.nro_reserva = nro_reserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Asiento> getAsientos() {
        return asientos;
    }

    public void setAsientos(ArrayList<Asiento> asientos) {
        this.asientos = asientos;
    }
    
    
}
