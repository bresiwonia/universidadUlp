/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoADatos;

import AccesoADatos.Conexion;
import Entidades.Alumno;
import Entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author viper
 */
public class MateriaData {

    private Connection con = null;
    private Materia MateriaData;

    public MateriaData() {

        con = Conexion.getConexion();

    }

    public void guardarMateria(Materia materia) {

        String sql = "INSERT INTO materia (nombre, anioMateria, activo) VALUES (?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnioMateria());
            ps.setBoolean(3, materia.isActivo());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {

                materia.setIdMateria(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Materia añadida con exito.");

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de materia" + ex.getMessage());

        }
    }

//    public Materia buscarMateria(int id) {
//        Materia materia = null;
//        try (PreparedStatement ps = con.prepareStatement("SELECT idMateria, nombre, anioMateria, activo FROM materia WHERE idMateria = ?", Statement.RETURN_GENERATED_KEYS)){
//            //PreparedStatement ps = con.prepareStatement(sql);
//            ps.setInt(1, id);
//            ResultSet rs = ps.executeQuery();
//            System.out.println(rs.next());
//            if (rs.next()) {
//                materia = new Materia();
//                System.out.println("Estoy dentro del if");
//                materia.setIdMateria(id);
//                System.out.println(rs.getInt("idMateria"));
//                System.out.println(rs.getInt("nombre"));
//                System.out.println(rs.getInt("anioMateria"));
//                System.out.println(rs.getInt("activo"));
//                materia.setNombre(rs.getString("nombre"));
//                materia.setAnioMateria(rs.getInt("anioMateria"));
//                materia.setActivo(true);
//                System.out.println("2.5");
//                System.out.println(materia.getNombre());
//            } else {
//                JOptionPane.showMessageDialog(null, "No existe la materia");
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia" + ex.getMessage());
//
//        }
//
//        return materia;
//
//    }
    
    public Materia obtenerMateriaPorId(int idMateria) {
        Materia materia = null;
        try (PreparedStatement ps = con.prepareStatement("SELECT idMateria, nombre, anioMateria, activo FROM materia WHERE idMateria = ?", Statement.RETURN_GENERATED_KEYS)){
            ps.setInt(1, idMateria);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                materia = new Materia(rs.getInt("idMateria"), rs.getString("nombre"), rs.getInt("anioMateria"), rs.getBoolean("activo"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Ha ocurrido un error al intentar obtener al alumno con id: " + idMateria + ". Error: " + ex.getMessage());
        }
        return materia;
    }

    public void modificarMateria(Materia materia) {

        String sql = "UPDATE materia SET nombre=?,anioMateria=?,activo=? WHERE idMateria=?";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
      
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnioMateria());
            ps.setBoolean(3, materia.isActivo());
            ps.setInt(4, materia.getIdMateria());
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificado Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "la materia no existe");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia" + ex.getMessage());
        }

    }
  public void eliminarMateria(int id) {
        String sql = "UPDATE materia SET activo = 0 WHERE idMateria = ? ";
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, " Se eliminó la materia.");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla materia");
        }
    }
  
   public List<Materia> listarMaterias() {
String sql = "SELECT * FROM materia WHERE activo = 1 ";
 ArrayList<Materia> materias = new ArrayList<>();
 try {
 
 PreparedStatement ps = con.prepareStatement(sql);
 ResultSet rs = ps.executeQuery();
 while (rs.next()) {
 Materia materia = new  Materia();

materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("anioMateria"));
                materia.setActivo(rs.getBoolean("activo"));
 materias.add(materia);
 }
 ps.close();


 } catch (SQLException ex) {
 JOptionPane.showMessageDialog(null, " Error al acceder a la tabla materias "+ex.getMessage());
 }
 return materias;
 }

}
