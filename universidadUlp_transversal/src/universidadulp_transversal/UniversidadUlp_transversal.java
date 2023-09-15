/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UniversidadUlp_transversal;


import AccesoADatos.AlumnoData;
import AccesoADatos.Conexion;
import AccesoADatos.InscripcionData;
import AccesoADatos.MateriaData;
import Entidades.Alumno;
import Entidades.Inscripcion;
import Entidades.Materia;
import java.sql.Connection;




/**
 *
 * @author viper
 */
public class UniversidadUlp_transversal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
Connection con=Conexion.getConexion();
//
//Alumno Juan=new Alumno (15,456123852,"Torres","Pedro", LocalDate.of(1980, 4, 25),true);
//AlumnoData alu=new AlumnoData();
//alu.guardarAlumno(Juan);
//alu.modificarAlumno(Juan);
//alu.eliminarAlumno(8);
//Alumno alumnoEncontrado=alu.buscarAlumnoPorDni(987654321);
//    
//        System.out.println("apellido "+alumnoEncontrado.getApellido());
//        AlumnoDate alu = new AlumnoDate();
//        for (Alumno alumno : alu.listarAlumnos()) {
//
//            System.out.println(alumno.getDni());
//            System.out.println(alumno.getApellido());
//            System.out.println(alumno.getNombre());
//            System.out.println(alumno.getFechaNacimiento());
//        }
//
//      AlumnoData ad=new AlumnoData();
//      MateriaData md=new MateriaData ();
//      InscripcionData id=new InscripcionData ();
//      
//      Alumno funes = ad.buscarAlumno(5);
//      Materia lengua= md.buscarMateria (2);
//      Inscripcion insc=new Inscripcion (funes,lengua,8);
//
//    }
//  
        Materia literatura = new Materia ("literatura", 11 , true);
        MateriaData mat =new MateriaData();
        mat.guardarMateria(literatura);
        
        
    }
}
  