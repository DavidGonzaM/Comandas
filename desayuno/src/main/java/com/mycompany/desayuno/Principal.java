/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.desayuno;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author David
 */
        public class Principal{
            
    public static void main(String args[]) throws InterruptedException {
     
        Pedidos pedido = new Pedidos();
        
        Conexion cx = new Conexion();
        
        Scanner entrada = new Scanner(System.in);
        
        boolean salir = false;
        
        while(!salir){
            System.out.println("1 - Crear pedido");
            
            System.out.println("2 - Eliminar pedido");
            
            System.out.println("3 - Marcar como recogido");
            
            System.out.println("4 - Listar carta");
            
            System.out.println("5 - Cerrar");
        
        int opcion = Integer.parseInt(entrada.nextLine());
        
        
        switch(opcion){
            case 1:
                System.out.println("Ingrese id del producto");
                pedido.setIdP(opcion);
                System.out.println("Ingrese nombre del producto");
                pedido.setNombreP(pedido.NombreP);
                System.out.println("Ingrese fecha");
                pedido.setFecha(Date.valueOf(LocalDate.MAX));
                break;
            case 2:
                cx.eliminar(opcion);
                
                
                break;
            
            case 4:
                System.out.println(pedido.getIdP());
                System.out.println(pedido.getFecha());
                System.out.println(pedido.getNombreP());
                System.out.println(pedido.getIdP());
                
                break;
                
            case 5:
                salir = true;
                break;
        }
        
        
        }
        
        
        
        
        
        
        
        
        
        
        
        //creating instances of java.util.Date which represents today's date and time
        java.util.Date now = new java.util.Date();
        System.out.println("Value of java.util.Date : " + now);
     
        //converting java.util.Date to java.sql.Date in Java
        java.sql.Date sqlDate = new java.sql.Date(now.getTime());
        System.out.println("Converted value of java.sql.Date : " + sqlDate);
     
        //converting java.sql.Date to java.util.Date back
        java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
        System.out.println("Converted value of java.util.Date : " + utilDate);
    }
 
}

