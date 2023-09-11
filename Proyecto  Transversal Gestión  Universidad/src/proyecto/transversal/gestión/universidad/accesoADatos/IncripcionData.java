/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.transversal.gestión.universidad.accesoADatos;

import Grupo33_universidad_Entidades.newpackage.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import Grupo33_universidad_Entidades.newpackage.Inscripcion;

/**
 *
 * @author usuario
 */
public class IncripcionData {
        private Connection con= null;
    
    public IncripcionData(){       
        con= Conexion.getConexion();       
    }
    
    private MateriaData matData; 
    private AlumnoData aluData; 
    
    public void GuardarInscripcion(Inscripcion inscripcion){
        String sql="INSERT INTO inscripcion(nota, id_alumno,id_materia) VALUES (?,?,?)";
        
        try {
            PreparedStatement ps= con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,inscripcion.getNota());
            ps.setInt(2,inscripcion.getId_alumno());
            ps.setInt(3,inscripcion.getId_materia());
           
            ps.executeUpdate();
            
            ResultSet rs= ps.getGeneratedKeys();
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Inscripcion guardada");
            }
            
            ps.close(); 
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
        }
                   
    }
}
