
package AccesoADatos;

import Entidades.Alumno;
import Entidades.Materia;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class MateriaData {

      private Connection con = null;
      

    public MateriaData() {

        con = Conexion.getConexion();

    }
     public void guardarMateria (Materia materia) {

        String sql = "INSERT INTO materia (nombre, anio, activo) VALUES (?, ?, ?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnioMateria());
            ps.setBoolean(3, materia.isActivo());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            
            if (rs.next()) {
                
                materia.setIdMateria (rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Materia añadida con exito.");

            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de materia" + ex.getMessage());

        }
    }

//    public void modificarMateria(Materia materia) {
//
//        String sql = "UPDATE alumno SET dni = ? , apellido = ?, nombre = ?, fechaNacimiento = ? WHERE idAlumno = ?";
//        PreparedStatement ps = null;
//
//        try {
//            ps = con.prepareStatement(sql);
//            ps.setInt(1, alumno.getDni());
//            ps.setString(2, alumno.getApellido());
//            ps.setString(3, alumno.getNombre());
//            ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
//            ps.setInt(5, alumno.getIdAlumno());
//            int exito = ps.executeUpdate();
//
//            if (exito == 1) {
//                JOptionPane.showMessageDialog(null, "Modificado Exitosamente.");
//            } else {
//                JOptionPane.showMessageDialog(null, "El alumno no existe");
//            }
//
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno " + ex.getMessage());
//        }
//
//    }
//// 
//
//    public void eliminarAlumno(int id) {
//        String sql = "UPDATE alumno SET estado = 0 WHERE idAlumno = ? ";
//        try {
//
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setInt(1, id);
//            int exito = ps.executeUpdate();
//
//            if (exito == 1) {
//                JOptionPane.showMessageDialog(null, " Se eliminó el alumno.");
//            }
//            ps.close();
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Alumno");
//        }
//    }
//
//    public Alumno buscarAlumno(int id) {
//        Alumno alumno = null;
//        String sql = "SELECT dni, apellido, nombre, fechaNacimiento FROM alumno WHERE idAlumno = ? AND estado = 1";
//        PreparedStatement ps = null;
//        try {
//            ps = con.prepareStatement(sql);
//            ps.setInt(1, id);
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next()) {
//                alumno = new Alumno();
//                alumno.setIdAlumno(id);
//                alumno.setDni(rs.getInt("dni"));
//                alumno.setApellido(rs.getString("apellido"));
//                alumno.setNombre(rs.getString("nombre"));
//                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
//                alumno.setEstado(true);
//
//            } else {
//                JOptionPane.showMessageDialog(null, "No existe el alumno");
//
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno " + ex.getMessage());
//
//        }
//
//        return alumno;
//    }
//
//    public Alumno buscarAlumnoPorDni(int dni) {
//        Alumno alumno = null;
//        String sql = "SELECT idAlumno, dni, apellido, nombre, fechaNacimiento FROM alumno WHERE dni=? AND estado = 1";
//        PreparedStatement ps = null;
//        try {
//            ps = con.prepareStatement(sql);
//            ps.setInt(1, dni);
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next()) {
//                alumno = new Alumno();
//                alumno.setIdAlumno(rs.getInt("idAlumno"));
//                alumno.setDni(rs.getInt("dni"));
//                alumno.setApellido(rs.getString("apellido"));
//                alumno.setNombre(rs.getString("nombre"));
//                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
//                alumno.setEstado(true);
//
//            } else {
//                JOptionPane.showMessageDialog(null, "No existe el alumno");
//
//            }
//            ps.close();
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno " + ex.getMessage());
//        }
//
//        return alumno;
//    }
//
// public List<Alumno> listarAlumnos() {
//String sql = "SELECT * FROM alumno WHERE estado = 1 ";
// ArrayList<Alumno> alumnos = new ArrayList<>();
// try {
// 
// PreparedStatement ps = con.prepareStatement(sql);
// ResultSet rs = ps.executeQuery();
// while (rs.next()) {
// Alumno alumno = new Alumno();
//
// alumno.setIdAlumno(rs.getInt("idAlumno"));
// alumno.setDni(rs.getInt("dni"));
// alumno.setApellido(rs.getString("apellido"));
// alumno.setNombre(rs.getString("nombre"));
// alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
// alumno.setEstado(rs.getBoolean("estado"));
// alumnos.add(alumno);
// }
// ps.close();
//
//
// } catch (SQLException ex) {
// JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Alumno "+ex.getMessage());
// }
// return alumnos;
// }


    
}
