package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Bryan
 */

/* aquí se crearan los métodos para extraer los datos de la base de datos*/
public class VendedorDAO {
    PreparedStatement ps;
    ResultSet rs;
    
    Conexion con = new Conexion();
    Connection acceso;
    
    
    public EntidadVendedor ValidarVendedor(String dni, String user){
       EntidadVendedor ev = new EntidadVendedor();
       String sql = "SELECT * FROM vendedor WHERE Dni=? AND User=?";
        try {
            acceso = con.getConnection();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, dni);
            ps.setString(2, user);
            rs = ps.executeQuery();
        } catch (Exception e) {
            System.out.println("Error en la consulta");
        }
       return ev;
    }
    
}
