
package proyecto.transversal.gestión.universidad.accesoADatos;

import Grupo33_universidad_Entidades.newpackage.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import Grupo33_universidad_Entidades.newpackage.Inscripcion;


public class IncripcionData {
        private Connection con= null;
    
    public IncripcionData(){       
        this.con= Conexion.getConexion();       
    }
 
    public void guardarInscripcion(Inscripcion insc){
        String sql="INSERT INTO inscripcion(nota, id_alumno,id_materia) VALUES (?,?,?)";
        
        try {
            PreparedStatement ps= con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1,insc.getNota());
            ps.setInt(2,insc.getAlumno().getId_alumno());
            ps.setInt(3,insc.getMateria().getIdMateria());           
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
