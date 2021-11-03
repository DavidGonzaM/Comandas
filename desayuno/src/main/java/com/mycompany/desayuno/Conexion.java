/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.desayuno;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.sql.Statement.RETURN_GENERATED_KEYS;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DavidGonzalezMartíne
 */
public class Conexion{
     private static Connection con;
         static{
        String url = "jdbc:mysql://localhost:3306/acceso?zeroDateTimeBehavior=CONVERT_TO_NULL";
        String user = "root";
        String password = "";
        try {
        con = DriverManager.getConnection(url, user, password);
        System.out.println("Conexion establecida con la base de datos");
        } catch (SQLException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    static final String LIST_QUERY = "SELECT * FROM pedidos";
    static final String INSERT_QUERY = "INSERT INTO pedidos(NombreP,idP,fecha) VALUES (?,?,?)";
    static final String GET_QUERY = "SELECT * FROM pedidos WHERE id=?";
    static final String REMOVE_QUERY = "DELETE FROM pedidos WHERE id=?";
    static final String COUNT_QUERY = "select count(id) as total from pedidos";         
         
    /**
     *
     * @return
     */
    public ArrayList<Pedidos> list() {

        var salida = new ArrayList<Pedidos>();

        try ( Statement st = con.createStatement()) {

            ResultSet resultado = st.executeQuery(LIST_QUERY);

            while (resultado.next()) {
                Pedidos p = new Pedidos();
                p.setNombreP(resultado.getString("NombreP"));
                p.setIdP(resultado.getInt("Id de producto"));
                p.setFecha(resultado.getDate("Fecha"));

                salida.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }
 
         public Integer crear (Pedidos p){
             
                    try ( PreparedStatement ps = con.prepareStatement(INSERT_QUERY, RETURN_GENERATED_KEYS)) {
            ps.setString(1, p.getNombreP());
            ps.setInt(2, p.getIdP());
            ps.setDate(3, p.getFecha());
            ps.executeUpdate();

            ResultSet keys = ps.getGeneratedKeys();
            if (keys.next()) {
                return keys.getInt(1);
            } else {
                return null;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
            
    }
         
    public Pedidos get(Integer id) {

        try ( PreparedStatement ps = con.prepareStatement(GET_QUERY)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Pedidos p = new Pedidos();
                p.setNombreP(rs.getString("NombreP"));
                p.setIdP(rs.getInt("Id de producto"));
                p.setFecha(rs.getDate("Fecha"));

                return p;
            } else {
                return null;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }     
         
	public boolean actualizar(Pedidos pedido) {
		Connection connect= null;
		Statement stm= null;
		
		boolean actualizar=false;
				
		String sql="UPDATE ENTREGA SET cedula='"+pedido.getEntrega()
                        +"', nombre='"+pedido.getNombreP()
                        +"', Id='"+pedido.getIdP()
                        +"', Fecha='"+pedido.getFecha();
                        
		try {
			connect=Conexion.con;
			stm=connect.createStatement();
			stm.execute(sql);
			actualizar=true;
		} catch (SQLException e) {
			System.out.println("Error: Clase ClienteDaoImple, método actualizar");
			e.printStackTrace();
		}		
		return actualizar;
        }
    
    
    
    
        public boolean eliminar (Integer id) {
            
            try ( PreparedStatement ps = con.prepareStatement(REMOVE_QUERY)) {
                ps.setInt(1, id);
                    return (ps.executeUpdate()==1);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }


        
         
}