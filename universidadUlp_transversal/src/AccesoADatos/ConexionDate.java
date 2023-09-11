
package AccesoADatos;

    import java.sql.Connection;
    import java.sql.SQLException;
    import java.util.logging.Level;
    import java.util.logging.Logger;
    import java.sql.ResultSet;
    import java.sql.PreparedStatement;
    import java.sql.DriverManager;

public class ConexionDate {
    
    private String url, bd, usuario, pass, driver;
    private Connection cx;
    private Object ConexionDate;

    public ConexionDate(String bd) {
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
            Logger.getLogger(ConexionDate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

    
    
    
    
  
   