
package proyecto.transversal.gestión.universidad.accesoADatos;

import Grupo33_universidad_Entidades.newpackage.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import Grupo33_universidad_Entidades.newpackage.Inscripcion;
import Grupo33_universidad_Entidades.newpackage.Materia;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class IncripcionData {
        private Connection con= null;
        private MateriaData md= new MateriaData(); 
        private AlumnoData ad=new AlumnoData();
        
    
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
    
    public void actualiarNota(int id_alumno,int id_materia,double nota){
        String sql="UPDATE inscripcion SET nota=? WHERE id_alumno=? and id_materia=?";
            try { 
                PreparedStatement ps= con.prepareStatement(sql);
                ps.setDouble(1,nota);
                ps.setInt(2,id_alumno);
                ps.setInt(3,id_materia);
                ps.executeUpdate();
                
                int filas=ps.executeUpdate();
                if(filas>0){
                    JOptionPane.showMessageDialog(null, "Nota actualizada");
                }
                
        ps.close();    
                
                
            } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
            }
        
    }
    
    
    public void borrarInscripcionMateriaAlumno(int id_alumno,int id_materia){
        
        String sql="DELETE from inscripcion WHERE id_alumno=? and id_materia=?";
            try { 
                PreparedStatement ps= con.prepareStatement(sql);
                ps.setInt(1,id_alumno);
                ps.setInt(2,id_materia);
                int filas = ps.executeUpdate();
                if(filas>0){
                    JOptionPane.showMessageDialog(null, "Inscripcion borrada");
                }
                
                ps.close(); 
                
            } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
            }                
    }
    
    public List<Inscripcion> obtenerInscripciones(){
        
        ArrayList<Inscripcion> cursadas=new ArrayList<>();
        String sql="SELECT * FROM inscripcion";    
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs= ps.executeQuery();
                while(rs.next()){
                    Inscripcion insc=new Inscripcion();
                    insc.setId_inscripto(rs.getInt("id_inscripto"));
                    Alumno alu= ad.buscarAlumno(rs.getInt("id_alumno"));
                    Materia mat= md.buscarMateria(rs.getInt("id_materia"));
                    insc.setAlumno(alu);
                    insc.setMateria(mat); 
                    insc.setNota(rs.getDouble("nota"));
                    cursadas.add(insc);                                        
                }
                ps.close(); 
                                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
         }      
       return cursadas;                
    }
    
    
    
}
