
package proyecto.transversal.gestión.universidad;


import Grupo33_universidad_Entidades.newpackage.Materia;

import Grupo33_universidad_Entidades.newpackage.Alumno;

import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import proyecto.transversal.gestión.universidad.accesoADatos.AlumnoData;
import proyecto.transversal.gestión.universidad.accesoADatos.Conexion;
import proyecto.transversal.gestión.universidad.accesoADatos.MateriaData;


public class ProyectoTransversalGestiónUniversidad {

    public static void main(String[] args) {

        Connection con = Conexion.getConexion();

//     Alumno juan = new Alumno(7,634532345,"Leiva","Rodrigo", Date.valueOf("1999-08-10"),true);
//     AlumnoData alu = new AlumnoData(); 
//     alu.guardarAlumno(juan); 
//     alu.modificarAlumno(juan); 
//     alu.eliminarAlumno(6);
//     
//     Alumno alumnoEncontrado= alu.buscarAlumnoPorDni(34521234);
//     if(alumnoEncontrado!=null){
//        System.out.println("dni "+ alumnoEncontrado.getDni());
//        System.out.println("apellido "+ alumnoEncontrado.getApellido());
//        
//     }

    //Verificar con un mentor, al correr con esta secuencia dice que hay
    //un error de sintaxis, porque en AlumnoData en el id se pusoo = ?
    //y segun lo que dice el programa, deberia decir =5 
           

//    AlumnoData alu = new AlumnoData();
//    for(Alumno alumno:alu.listarAlumnos()){
//        
//        System.out.println(alumno.getDni());
//        System.out.println(alumno.getApellido());
//        System.out.println(alumno.getNombre());
//        System.out.println(alumno.getFecha_nacimiento());
//        
//      }
    //Pasa lo mismo aca 
    
    
    //Materia ma = new Materia(2,"Matematica", 1, true);
    MateriaData Mdat = new MateriaData();
    
      
   for(Materia materias:Mdat.listarMateria()){
        
        System.out.println(materias.getNombre());
        System.out.println(materias.getAnioMateria());
     
        
        
      }

    }
    
}
