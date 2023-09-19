
package AccesoADatos;

import Entidades.Alumno;
import Entidades.Inscripcion;
import Entidades.Materia;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class InscripcionData {
  
    private Connection con=null;
    
    private MateriaData md = new MateriaData();
    private AlumnoData ad = new AlumnoData();
    
    
    public InscripcionData() {
        
    this.con=Conexion.getConexion();
    
    
    }
    
    public void guardarInscripcion (Inscripcion insc) {
    
        String sql="INSERT INTO Inscripcion (idAlumno, idMateria, nota) VALUES (?,?,?) ";
                
        try {
            PreparedStatement ps=con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, insc.getAlumno().getIdAlumno());
            ps.setInt(2, insc.getMateria().getIdMateria());
            ps.setDouble(3, insc.getNota());
            ps.executeUpdate();
            
            ResultSet rs=ps.getGeneratedKeys();
            
            if (rs.next()){
            
            
               insc.setIdInscripcion(rs.getInt(1));
               JOptionPane.showMessageDialog(null, "Inscripcion registrada");
        }
        
               ps.close();
        
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de inscripcion");
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
                Materia mat = md.buscarMateria(rs.getInt("idMateria"));
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

    public List<Inscripcion> obtenerInscripcionesPorAlumno(int idAlumno) {
        
        ArrayList<Inscripcion> cursadas = new ArrayList<>();
        
        String sql = "SELECT * FROM inscripcion WHERE idAlumno=? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                Inscripcion insc = new Inscripcion();
                insc.setIdInscripcion(rs.getInt("idInscripcion"));
                Alumno alu = ad.buscarAlumno(rs.getInt("idAlumno"));
                Materia mat = md.buscarMateria(rs.getInt("idMateria"));
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

    public List<Materia> obtenerMateriasCursadasPorAlumno (int idAlumno) {
    
    ArrayList<Materia> materias = new ArrayList <>() ;
    String sql = "SELECT inscripcion.idMateria, nombre, año FROM inscripcion," 
                 + "materia WHERE inscripcion.idMateria=materia.idMateria" + 
                 "AND inscripcion.idAlumno=?;";
    
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()) {
                
                Materia materia= new Materia ();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("año"));
                materias.add(materia);
            }
           ps.close();  
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Inscripcion");
        }
          return materias;
    
    
    

}

    public List<Materia> obtenerMateriasNoCursadas (int idAlumno) {
        
      ArrayList<Materia> materias = new ArrayList <>() ;
      String sql = "SELECT * FROM materia WHERE activo = 1 AND idMateria not in"
                   + "(SELECT idMateria FROM inscripcion WHERE idAlumno=?)";
    
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()) {
                
                Materia materia= new Materia ();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("anio"));
                materias.add(materia);
            }
           ps.close();  
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Inscripcion");
        }
          return materias;   
        
        
        
        
    }

    public List<Alumno> obtenerAlumnoPorMateria (int idMateria) {
    
      ArrayList<Alumno> alumnosMateria = new ArrayList <>() ;
      String sql = "SELECT a.idAlumno, dni, nombre, apellido, fechaNacimiento,estado"
                  + "FROM inscripcion i, alumno a WHERE i.idAlumno = a.idAlumno AND idMateria= ? AND a.estado=1 ";
    
        try {
            PreparedStatement ps=con.prepareCall(sql);
            ps.setInt(1, idMateria);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()) {
                
                Alumno alumno = new Alumno ();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(rs.getBoolean("estado"));
                alumnosMateria.add(alumno);
            }
           ps.close();  
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla");
        }
          return alumnosMateria;   
        
    
    }





}
   
    
    
    


