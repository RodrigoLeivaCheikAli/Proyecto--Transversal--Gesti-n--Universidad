/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.transversal.gestión.universidad;

import Grupo33_universidad_Entidades.newpackage.Materia;
import java.sql.Connection;
import proyecto.transversal.gestión.universidad.accesoADatos.Conexion;
import proyecto.transversal.gestión.universidad.accesoADatos.MateriaData;

/**
 *
 * @author User
 */
public class ProyectoTransversalGestiónUniversidad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connection con = Conexion.getConexion();
        Materia fisica = new Materia("fisica", 3, true);
        MateriaData mat = new MateriaData();
        mat.guardarMateria(fisica);
    }
    
}
