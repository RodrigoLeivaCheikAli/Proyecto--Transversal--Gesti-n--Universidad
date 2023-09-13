
package proyecto.transversal.gestión.universidad.accesoADatos;
import java.sql.*; 
import Grupo33_universidad_Entidades.newpackage.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.Date; 
import java.util.ArrayList;
import java.util.List;

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
        String sql="INSERT INTO alumno(dni,apellido,nombre,fecha_nacimiento,estado) VALUES(?,?,?,?,?)";
        
        try {
            PreparedStatement ps= con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,alumno.getDni());
            ps.setString(2,alumno.getApellido());
            ps.setString(3,alumno.getNombre());
            ps.setDate(4, alumno.getFecha_nacimiento());
            ps.setBoolean(5, alumno.isEstado());
            ps.executeUpdate();
            
            ResultSet rs= ps.getGeneratedKeys();
            if(rs.next()){
                alumno.setId_alumno(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Alumno Guardado");
            }
            
            ps.close(); 
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno");
        }
                   
    }
      public void modificarAlumno(Alumno alumno){
            
            String sql="UPDATE alumno SET dni=?,apellido=?,nombre=?,fecha_nacimiento=?"
                    + "WHERE id_alumno=?";
            
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, alumno.getFecha_nacimiento());
            ps.setInt(5, alumno.getId_alumno()); 
            int exito= ps.executeUpdate();
            
            if(exito==1){
                JOptionPane.showMessageDialog(null, "Alumno modificado");
            }
            
                    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla alumno");
        }
            
      }      
            
          
      public void eliminarAlumno(int id){
          
          String sql="UPDATE alumno SET estado=0 WHERE id_alumno=?";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1,id);
            int exito = ps.executeUpdate(); 
            
            if(exito==1){
                JOptionPane.showMessageDialog(null, "Alumno Eliminado");
            }
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno");
        }
                                   
      }
      public Alumno buscarAlumno(int id){
            
            String sql="SELECT dni,apellido,nombre,fecha_nacimiento FROM alumno WHERE id_alumno=? AND estado=1";
            Alumno alumno=null; 
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
                alumno=new Alumno();
                alumno.setId_alumno(id);
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre")); 
                alumno.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                alumno.setEstado(true); 
                                    
             }else {                 
                JOptionPane.showMessageDialog(null,"No existe ese alumno");                
            }             
             ps.close();
                                                   
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno");
        }
        
        return alumno;             
    }
      
      public Alumno buscarAlumnoPorDni(int dni){
            
            String sql="SELECT id_alumno,dni,apellido,nombre,fecha_nacimiento FROM alumno WHERE dni=? AND estado=1";
                    
            Alumno alumno=null; 
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1,dni);
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
                alumno=new Alumno();
                alumno.setId_alumno(rs.getInt("id_alumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre")); 
                alumno.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                alumno.setEstado(true); 
                                    
             }else { 
                
                JOptionPane.showMessageDialog(null,"No existe ese alumno");               
            }             
             ps.close();
                                                   
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno");
        }
        
        return alumno;             
    }
      
         public List<Alumno> listarAlumnos(){
            
            String sql="SELECT id_alumno,dni,apellido,nombre,fecha_nacimiento FROM alumno WHERE estado = 1";
            ArrayList<Alumno> alumnos= new ArrayList<>();
            
        try {
            PreparedStatement ps= con.prepareStatement(sql);
           
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                
                Alumno alumno=new Alumno();
                alumno.setId_alumno(rs.getInt("id_alumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre")); 
                alumno.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                alumno.setEstado(true); 
                
                alumnos.add(alumno); 
                                    
             }           
             ps.close();
                                                   
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno");
        }
        
        return alumnos; 
            
    }
      
}
