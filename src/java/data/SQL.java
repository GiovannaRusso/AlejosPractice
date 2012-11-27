package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author gio
 */
public class SQL {

    Connection cnx;                                         //Objeto que ejecuta la conexion con la BD
    String url = "jdbc:mysql://localhost:3306/clientes";    //Ruta de la BD
    String usr = "alejos";                                  //Usuario
    String pass = "2012";                                   //Contraseñ±a de acceso a la BD

    public SQL() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            System.out.print("Error 1: Problema con el Driver de conexion!");
        }
        try {
            cnx = DriverManager.getConnection(url, usr, pass);  //Conexion con la BD
        } catch (SQLException e2) {
            System.out.print("Error 2: Problema con la Base de Datos! " + e2.toString());
        }
    }

    public ResultSet consulta(String sql) {
        Statement buscar;   //Objeto que realiza una consulta sql
        ResultSet resultado = null;//Objeto con el resultado de la consulta sql
        try {
            buscar = cnx.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultado = buscar.executeQuery(sql);
        } catch (SQLException e2) {
            System.out.print("Error 2: Problema con la Base de Datos! " + e2.toString());
        }
        return resultado;
    }

    public int ModificarSQL(int idCliente, String nombre, String apellido, String estadoCivil, String rif) {
        PreparedStatement ps = null;
        int resultado = 0;
        try {
            
            ps = cnx.prepareStatement("UPDATE clientes SET nombre = ?, apellido = ?, estadoCivil = ?,  rif = ? WHERE idCliente = ?");
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, estadoCivil);
            ps.setString(4, rif);
            ps.setInt(5, idCliente);
            
            return ps.executeUpdate();
                
        } catch (SQLException e2) {
            System.out.print("Error 2: Problema con la Base de Datos! " + e2.toString());
            return resultado;
        }
    }
    
    public ResultSet getClientes() {
        return this.consulta("SELECT * FROM clientes");
    }
    
}
