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
////alu.guardarAlumno(Juan);|
//alu.modificarAlumno(Juan);
//alu.eliminarAlumno(8);
//Alumno alumnoEncontrado=alu.buscarAlumnoPorDni(987654321);
// System.out.println(alumnoEncontrado.getDni());
// if(alumnoEncontrado.isEstado())
//            System.out.println(alumnoEncontrado.getApellido());
//            System.ou.t.println(alumnoEncontrado.getNombre());
//            System.out.println(alumnoEncontrado.getFechaNacimiento());   
//        System.out.println("apellido "+alumnoEncontrado.getApellido());
//        AlumnoData alu = new AlumnoData();
//        for (Alumno alumno : alu.listarAlumnos()) {
//
//            System.out.println(alumno.getDni());
//            System.out.println(alumno.getApellido());
//            System.out.println(alumno.getNombre());
//            System.out.println(alumno.getFechaNacimiento());
//        }
//
 
//        MateriaData c = new MateriaData();
//  c.guardarMateria(m);
//        Materia materiaencontrada=c.buscarMateria(9);
//        if (materiaencontrada != null) 
//            System.out.println("Nombre" +materiaencontrada.toString());

//Materia m=new Materia(9, "Literatura", 3, true);
//c.modificarMateria(m); 
//c.eliminarMateria(9);

//  System.out.println("apellido "+alumnoEncontrado.getApellido());
//        AlumnoData alu = new AlumnoData();
//        for (Materia materias : c.listarMaterias()) {
//
//            System.out.println(materias.toString());
//        }

AlumnoData ad=new AlumnoData();
MateriaData md=new MateriaData();
InscripcionData id=new InscripcionData();


//Alumno mara=ad.buscarAlumno(5);
//Materia Literatura=md.buscarMateria(9);
////
//Inscripcion insc=new Inscripcion(mara, Literatura, 9);
//c.guardarInscripcion(insc);
//c.actualizarNota(8, 8, 10);
//c.borrarInscripcionMateriaAlumno(8, 8);
//for(Inscripcion inscripcion:id.obtenerInscripciones()){
//    
//    System.out.println("id: "+inscripcion.getIdInscripcion());
//    System.out.println("Apellido: " +inscripcion.getAlumno().getApellido());
//    System.out.println("Materia: "+inscripcion.getMateria().getNombre());
//}
//        }
    
for(Materia materia:id.obtenerMateriasNoCursadas(5)){
    
    System.out.println("nombre "+materia.getNombre());
}   

    } 
}
