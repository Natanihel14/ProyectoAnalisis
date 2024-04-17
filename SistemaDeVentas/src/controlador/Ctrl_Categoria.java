/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import modelo.Categoria; //Revisar si dice "package does no exist"
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author William
 */
public class Ctrl_Categoria {
    //Metodo para registrar categoria
    public boolean guardar(Categoria objeto){
        boolean respuesta = false;
        Connection cn = conexion.Conexion.conectar(); //Falta la clase conexion
        try{
            PreparedStatement consulta = cn.prepareStatement("insert into tb_categoria(?, ?, ?)");
            consulta.setInt(1, 0);
            consulta.setString(2, objeto);
            consulta.setInt(3, objeto.setEstado);
            
            if(consulta.executeUpdate() > 0 ){
                respuesta = true;
            }
            
            cn.close();
            
        }catch(SQLException e){
            System.out.println("Error al guardar categoria" + e);
        }
        
        return respuesta;
    }
    
    //Metodo para consultar que existe la categoria
    public boolean existeCategoria(String categoria){
        boolean respuesta = false;
        String sql = "select descripcion from tb_categoria where descripcion = '" + categoria+"';";
        Statement st;
        
        try{
            Connection cn = Conexion.conectar(); //Falta la clase conexion
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                respuesta = true;
            }
            
        }catch(SQLException e){
            System.out.println("Error al consultar categoria" + e);
        }
        
        return respuesta;
    }
}
