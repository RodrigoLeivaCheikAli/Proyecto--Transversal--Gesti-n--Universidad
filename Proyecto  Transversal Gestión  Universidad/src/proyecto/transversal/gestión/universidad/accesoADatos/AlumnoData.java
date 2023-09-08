
package proyecto.transversal.gestión.universidad.accesoADatos;
import java.sql.*; 
import Grupo33_universidad_Entidades.newpackage.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.Date; 

/**
 *
 * @author usuario
 */
public class AlumnoData {
    private Connection con= null;
    
    public AlumnoData(){
        
        con= Conexion.getConexion();
        
    }
    
    public void guardarAlumno(Alumno alumno){
        String sql="INSERT INTO alumno(dni,apellido,nombre,fechaNacimiento,estado)"
                + "VALUES(?,?,?,?,?)";
        
        try {
            PreparedStatement ps= con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,alumno.getDni());
            ps.setString(2,alumno.getApellido());
            ps.setString(3,alumno.getNombre());
            ps.setDate(4,Date.valueOf(alumno.getFechaNacimiento()));
            ps.setBoolean(5, alumno.isActivo());
            ps.executeUpdate();
            
            ResultSet rs= ps.getGeneratedKeys();
            if(rs.next()){
                alumno.setIDAlumno(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Alumno Guardado");
            }
            
            ps.close(); 
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno");
        }
        
    }
            
            
            
}
