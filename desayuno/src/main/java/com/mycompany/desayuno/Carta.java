/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;
/**
 *
 * @author DavidGonzalezMartíne
 */

public class Carta implements Serializable{    

        int id;
    int recogido;
    int precio;
    String Nombre;


    public Carta(int id, int recogido, int precio, String Nombre) {
        this.id = id;
        this.recogido = recogido;
        this.precio = precio;
        this.Nombre = Nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRecogido() {
        return recogido;
    }

    public void setRecogido(int recogido) {
        this.recogido = recogido;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    
}
