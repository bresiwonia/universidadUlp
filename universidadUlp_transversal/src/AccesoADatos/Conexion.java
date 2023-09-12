
package AccesoADatos;

import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {

    private static final String url = "jdbc:mariadb://localhost/";
    private static final String DB = "universidadulp";
    private static final String usuario = "root";
    private static final String pass = "";
    private static Connection connection;
    
    private Conexion() {
    }
    
    public static Connection getConexion() {
        if (connection == null) {   
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                connection = DriverManager.getConnection(url+DB, usuario, pass);
                
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "error al cargar los drivers");
            } 
        }
        return connection;
    }
}

/*public class conexion {

    private String url, bd, usuario, pass, driver;
    private Connection cx;
    private Object conexion;

    public conexion(String bd) {
        this.bd = bd;
        url = "jdbc:mariadb://localhost:3306/";
        usuario = "root";
        pass = "";
        driver = "org.mariadb.jdbc.Driver";
    }

    public Connection conectar() {
        try {
            Class.forName(driver);
            cx = DriverManager.getConnection(url + bd, usuario, pass);

            System.out.println("conexion exitosa" + bd);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("error conexion" + bd + ex);
        }
        return cx;

    }

    public void desconectar() {
        try {
            cx.close();
        } catch (SQLException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}*/