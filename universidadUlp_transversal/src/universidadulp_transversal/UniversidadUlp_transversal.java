/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadulp_transversal;

import AccesoADatos.AlumnoDate;
import AccesoADatos.Conexion;
import Entidades.Alumno;
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
//Connection con=Conexion.getConexion();
//
//Alumno Juan=new Alumno (15,456123852,"Torres","Pedro", LocalDate.of(1980, 4, 25),true);
//AlumnoData alu=new AlumnoData();
//alu.guardarAlumno(Juan);
//alu.modificarAlumno(Juan);
//alu.eliminarAlumno(8);
//Alumno alumnoEncontrado=alu.buscarAlumnoPorDni(987654321);
//    
//        System.out.println("apellido "+alumnoEncontrado.getApellido());
        AlumnoDate alu = new AlumnoDate();
        for (Alumno alumno : alu.listarAlumnos()) {

            System.out.println(alumno.getDni());
            System.out.println(alumno.getApellido());
            System.out.println(alumno.getNombre());
            System.out.println(alumno.getFechaNacimiento());
        }

    }

}