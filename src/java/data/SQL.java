/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    public ResultSet consulta(String sql) {
        Connection cnx; //Objeto que ejecuta la conexion con la BD
        Statement buscar;   //Objeto que realiza una consulta sql
        ResultSet resultado = null;//Objeto con el resultado de la consulta sql
        String url = "jdbc:mysql://localhost:3306/superPc";   //Ruta de la BD
        String usr = "root";      //Usuario
        String pass = "1234";          //Contraseñ±a de acceso a la BD
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            System.out.print("Error 1: Problema con el Driver de conexion!");
        }
        try {
            cnx = DriverManager.getConnection(url, usr, pass);  //Conexion con la BD
            buscar = cnx.createStatement(resultado.TYPE_SCROLL_SENSITIVE,
                    resultado.CONCUR_READ_ONLY);
            resultado = buscar.executeQuery(sql);
        } catch (SQLException e2) {
            System.out.print("Error 2: Problema con la Base de Datos! " + e2.toString());
        }
        return resultado;
    }

   

    public void ModificarSQL(String sql) {
        Connection cnx; //Objeto que ejecuta la conexion con la BD
        Statement buscar;   //Objeto que realiza una consulta sql
        ResultSet resultado = null;//Objeto con el resultado de la consulta sql
        String url = "jdbc:mysql://localhost:3306/superPc";   //Ruta de la BD
        String usr = "root";      //Usuario
        String pass = "1234";          //Contraseñ±a de acceso a la BD
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            System.out.print("Error 1: Problema con el Driver de conexion!");
        }
        try {
            cnx = DriverManager.getConnection(url, usr, pass);  //Conexion con la BD
            buscar = cnx.createStatement();
            buscar.executeUpdate(sql);
        } catch (SQLException e2) {
            System.out.print("Error 2: Problema con la Base de Datos! " + e2.toString());
        }

    }

    
    
}
