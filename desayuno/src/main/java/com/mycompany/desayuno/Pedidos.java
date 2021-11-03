package com.mycompany.desayuno;

/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author DavidGonzalezMartíne
 */
public class Pedidos implements Serializable {
    
    String NombreP;
    int idP;
    Date fecha;
    int entrega;
    public Pedidos() {
    }


    public int getEntrega() {
        return entrega;
    }

    public void setEntrega(int entrega) {
        this.entrega = entrega;
    }

    public Pedidos(String Nombre, int idP, Date fecha, int entrega) {
        this.NombreP = NombreP;
        this.idP = idP;
        this.fecha = fecha;
        this.entrega = entrega;
    }

    public String getNombreP() {
        return NombreP;
    }

    public void setNombreP(String NombreP) {
        this.NombreP = NombreP;
    }

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Pedidos{" + "NombreP=" + NombreP + ", idP=" + idP + ", fecha=" + fecha + ", entrega=" + entrega + '}';
    }

    
    

    
}