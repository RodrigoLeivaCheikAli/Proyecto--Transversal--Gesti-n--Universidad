
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

        // TODO code application logic here
        Connection con = Conexion.getConexion();


        Alumno juan = new Alumno(12312345,"Luna","Pedro", Date.valueOf("1999-08-10"),true);
        AlumnoData alu = new AlumnoData(); 
        alu.guardarAlumno(juan); 


    }
    
}
