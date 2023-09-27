package AccesoADatos;

import AccesoADatos.AlumnoData;
import AccesoADatos.Conexion;
import Entidades.Alumno;
import Entidades.Inscripcion;
import Entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class InscripcionData {

    private Connection con = null;
    private MateriaData md = new MateriaData();
    private AlumnoData ad = new AlumnoData();

    public InscripcionData() {

        con = Conexion.getConexion();
    }

    public void guardarInscripcion(Inscripcion insc) {
        String sql = "INSERT INTO inscripcion(idAlumno, idMateria,nota) VALUES (?,?,?)";

        try {

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, insc.getAlumno().getIdAlumno());
            ps.setInt(2, insc.getMateria().getIdMateria());
            ps.setDouble(3, insc.getNota());
            
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                insc.setIdInscripcion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Inscripcion Registrada");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de incripcion");
        }

    }

    public void actualizarNota(int idAlumno, int idMateria, double nota) {
        try {
            String sql = "UPDATE inscripcion SET nota=? WHERE idAlumno=? and idMateria=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Nota actualizada");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
        }

    }

    public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria) {
        try {
            String sql = "DELETE FROM inscripcion WHERE idAlumno=? and idMateria=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);

            int filas = ps.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Inscripcion borrada");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");

        }
    }

    public List<Inscripcion> obtenerInscripciones() {
        ArrayList<Inscripcion> cursadas = new ArrayList<>();
        String sql = "SELECT * FROM inscripcion";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Inscripcion insc = new Inscripcion();
                insc.setIdInscripcion(rs.getInt("idInscripcion"));
                Alumno alu = ad.buscarAlumno(rs.getInt("idAlumno"));
                Materia mat = md.obtenerMateriaPorId(rs.getInt("idMateria"));
                insc.setAlumno(alu);
                insc.setMateria(mat);
                insc.setNota(rs.getDouble("nota"));
                cursadas.add(insc);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla INSCRIPCIONES");
        }
        return cursadas;
    }

    public List<Materia> obtenerMateriaCursadas(int idAlumno) {

        ArrayList<Materia> materias = new ArrayList<>();
        String sql = "SELECT inscripcion.idMateria, nombre, anioMateria FROM inscripcion,"
                + " materia WHERE inscripcion.idMateria = materia.idMateria"
                + " AND inscripcion.idAlumno = ?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("anioMateria"));
                materias.add(materia);

            }
ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
        }
return materias;
    }
    
    public List<Materia> obtenerMateriaNoCursada(int idAlumno){
        
        ArrayList<Materia> materias =new ArrayList<>();
        
        String sql = "SELECT * FROM materia WHERE activo = 1 AND idMateria not in "
                + "(SELECT idMateria FROM inscripcion WHERE idAlumno =?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Materia materia = new Materia();  
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("anioMateria"));
                materias.add(materia);
                
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
        }
        
        return materias;
        
    }
    
    public ArrayList<Inscripcion> obtenerInscripcionesPorAlumno(int idAlumno) {
            ArrayList<Inscripcion> cursadas=new ArrayList<>();
            
            String sql= "SELECT idInscripcion, m.idMateria, i.idAlumno, nota FROM inscripcion AS i"
                    + " JOIN materia AS m"
                    + " ON m.idMateria = i.idMateria"
                    + " WHERE idAlumno = ?";
             
         try {
             PreparedStatement ps = con.prepareStatement(sql);
             ps.setInt(1, idAlumno);
             ResultSet rs=ps.executeQuery();
             
             while (rs.next()) {
                 Inscripcion insc=new Inscripcion();
                 insc.setIdInscripcion(rs.getInt("idInscripcion"));
                 System.out.println("1");
                 System.out.println(rs.getInt("i.idAlumno"));
                 Alumno alu=ad.buscarAlumno(rs.getInt("i.idAlumno"));
                 System.out.println("2");
                 System.out.println("IDMateria: " + rs.getInt("m.idMateria"));
                 //System.out.println(md.buscarMateria(rs.getInt("m.idMateria")));
                 Materia mate=md.obtenerMateriaPorId(rs.getInt("m.idMateria"));
                 System.out.println("3");
                 System.out.println(alu.getApellido());
                 System.out.println("4");
                 insc.setAlumno(alu);
                 insc.setMateria(mate);
                 System.out.println(mate.getNombre());
                 System.out.println("5");
                 insc.setNota(rs.getInt("nota"));
                 System.out.println("6");
                 cursadas.add(insc);
                 System.out.println("7");
              }
             
             ps.close();
         } catch (SQLException ex) {
             Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
         }          
          return cursadas;
    }
    
}
