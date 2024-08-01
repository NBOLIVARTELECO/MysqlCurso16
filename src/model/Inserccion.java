/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lenovo
 */
public class Inserccion {
    
    private final String tabla = "pregrado";

    public void guardar(Connection conexion, String Nombre,String Creditos,String Grupos){
        try {
            PreparedStatement consulta;

            consulta = conexion.prepareStatement("INSERT INTO " + this.tabla + "(nombre, creditos, grupo) VALUES(?, ?, ?)");
            consulta.setString(1, Nombre);
            consulta.setString(2, Creditos);
            consulta.setString(3, Grupos);
            //asas
            
            consulta.executeUpdate();
            System.out.println("Se efectuo la operacion de escritura");

        } catch (SQLException ex) {
            
            
        }

    }
    
    public  void recuperarPorId(Connection conexion, int id_tarea) {
        
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT titulo, descripcion, nivel_de_prioridad FROM " + this.tabla + " WHERE id_tarea = ?");
            consulta.setInt(1, id_tarea);
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
              
                System.out.println(id_tarea);
                System.out.println(resultado.getString("titulo"));
                System.out.println(resultado.getInt("nivel_de_prioridad"));
            }
        } catch (SQLException ex) {
            
        }
        
    }
    
}
