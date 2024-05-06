package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import conexion.Conexion;
import java.sql.Statement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import modelo.Usuario;

/**
 *
 * @author Natanihel
 */
public class Ctrl_Usuario {

    //metodo para Iniciar Sesion 
    public boolean loginUser(Usuario objeto) {

        boolean respuesta = false;

        Connection cn = Conexion.conectar();
        String sql = "select usuario, password from tb_usuario where usuario = '" + objeto.getUsuario() + "'  and password = '" + objeto.getPassword() + "'";
        Statement st;
        try {

            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al Iniciar Sesion");
            JOptionPane.showMessageDialog(null, "Error al Iniciar Sesion");

        }

        return respuesta;

    }

}
