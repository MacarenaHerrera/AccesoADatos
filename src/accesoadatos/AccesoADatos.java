/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoadatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author programador
 */
public class AccesoADatos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            String url="jdbc:mysql://localhost/prueba";
            String usuario="root";
            String contraseña="hola";
            
            Class.forName("org.mariadb.jdbc.Driver");
            
            try {
                Connection con= DriverManager.getConnection(url + "?useLegacyDatetimeCode=false&serverTimezone=UTC"
                        + "&user=" + usuario + "&contraseña=" + contraseña);
                
                PreparedStatement ps=con.preparedStatements("INSERT INTO Alumno (nombre,fecNac,activo) VALUES (?,?,?);");
                
                ps.setString(1, "Rosa Gutierrez");
                LocalDate nac=LocalDate.of(2019, Month.MARCH, 10);
                ps.setDate(2, Date.valueOf(nac));
                
                ps.setBoolean(3, true);
                int filas=ps.executeUpdate();
                
            } catch (SQLException ex) {
                Logger.getLogger(AccesoADatos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al cargar driver");
        }
            }
    
}
