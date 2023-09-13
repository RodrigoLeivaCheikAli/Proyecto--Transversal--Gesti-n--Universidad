
package proyecto.transversal.gestión.universidad;


import Grupo33_universidad_Entidades.newpackage.*;

import java.sql.*;
import proyecto.transversal.gestión.universidad.accesoADatos.*;

public class ProyectoTransversalGestiónUniversidad {

    public static void main(String[] args) {
 /* 
        Connection con = Conexion.getConexion();

     Alumno juan = new Alumno(7,634532345,"Leiva","Rodrigo", Date.valueOf("1999-08-10"),true);
     AlumnoData alu = new AlumnoData(); 
     alu.guardarAlumno(juan); 
     alu.modificarAlumno(juan); 
     alu.eliminarAlumno(6);
     
     Alumno alumnoEncontrado= alu.buscarAlumnoPorDni(34521234);
     if(alumnoEncontrado!=null){
        System.out.println("dni "+ alumnoEncontrado.getDni());
        System.out.println("apellido "+ alumnoEncontrado.getApellido());
        
     }

    AlumnoData alu = new AlumnoData();
    for(Alumno alumno:alu.listarAlumnos()){
        
        System.out.println(alumno.getDni());
        System.out.println(alumno.getApellido());
        System.out.println(alumno.getNombre());
        System.out.println(alumno.getFecha_nacimiento());
        
      }
    
    
    Materia ma = new Materia(3,"Tecnologia", 1, true);
    MateriaData Mdat = new MateriaData();
    Mdat.guardarMateria(ma);
   Materia materiaEncontrado= Mdat.buscarMateria(3);
     if(materiaEncontrado!=null){
        System.out.println("Nombre: "+ materiaEncontrado.getNombre());
        System.out.println("Año: "+ materiaEncontrado.getAnioMateria());
        
     }
    
   for(Materia materias:Mdat.listarMateria()){        
        System.out.println(materias.getNombre());
        System.out.println(materias.getAnioMateria());                   
      }
    }
     
*/ 
    AlumnoData ad= new AlumnoData();
    MateriaData md= new MateriaData();
    IncripcionData id= new IncripcionData(); 
    
//    Alumno ricardo =ad.buscarAlumno(1); 
//    Materia mate= md.buscarMateria(2);
//    Inscripcion insc=new Inscripcion(9,ricardo,mate);     
//     id.guardarInscripcion(insc); 
     //id.actualiarNota(5,1,7);
     //id.borrarInscripcionMateriaAlumno(5,1);
//        System.out.println(id.obtenerInscripciones().size()); 
        
//     for(Inscripcion inscripciones:id.obtenerInscripciones()){
//         
//      System.out.println("id: "+ inscripciones.getId_inscripto());
//      System.out.println("Apellido: "+ inscripciones.getAlumno().getApellido());
//      System.out.println("Materia: "+inscripciones.getMateria().getNombre());     
//
//     }

     for(Materia materia:id.obtenerMateriasNOCursadas(5)){        
         System.out.println("Nombre: "+materia.getNombre());        
     }

       for(Inscripcion insc:id.obtenerInscripcionesPorAlumno(1)){
           System.out.println("Materia: "+insc.getMateria());
       }
       
       for(Materia mater:id.obtenerMateriasCursadas(5)){
           System.out.println("Materia: "+mater.getIdMateria());
       }
       
  }}  