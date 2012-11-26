package data;

import java.sql.Connection;
import java.sql.DriverManager;
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

    public void ModificarSQL(String sql) {
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
    
    public ResultSet getClientes() {
        return this.consulta("SELECT * FROM clientes");
    }
    
}
