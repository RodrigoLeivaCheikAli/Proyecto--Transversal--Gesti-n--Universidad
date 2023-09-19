
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
    
    
      public List<Inscripcion> obtenerInscripcionesPorAlumno(int id_alumno){
        
        ArrayList<Inscripcion> cursadas=new ArrayList<>();
        String sql="SELECT * FROM inscripcion WHERE id_alumno=?";    
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1,id_alumno); 
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
      
    public List<Materia> obtenerMateriasCursadas(int id_alumno){
        List<Materia> materias= new ArrayList<Materia>();
        String sql="SELECT m.id_materia,m.nombre,m.año FROM inscripcion i JOIN materia m ON(i.id_materia=m.id_materia) WHERE i.id_alumno=? AND m.estado=1";
            try {
                PreparedStatement ps= con.prepareStatement(sql);
                ps.setInt(1,id_alumno); 
                ResultSet rs= ps.executeQuery();
                Materia mat;
                while(rs.next()){
                    mat= new Materia(); 
                    mat.setIdMateria(rs.getInt("id_materia"));
                    mat.setNombre(rs.getString("nombre"));
                    mat.setAnioMateria(rs.getInt("año"));
                    materias.add(mat);                    
                }                
                ps.close(); 
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
            }
        
        return materias; 
    }
    
    public List<Materia> obtenerMateriasNOCursadas(int id_alumno){
        ArrayList<Materia> materias= new ArrayList<>();   
        String sql="SELECT * FROM materia WHERE estado=1 AND id_materia not in (SELECT id_materia FROM inscripcion WHERE id_alumno=?)";
         try {
                PreparedStatement ps= con.prepareStatement(sql);
                ps.setInt(1,id_alumno); 
                ResultSet rs= ps.executeQuery();
                while(rs.next()){
                    Materia materia=new Materia(); 
                    materia.setIdMateria(rs.getInt("id_materia"));
                    materia.setNombre(rs.getString("nombre"));
                    materia.setAnioMateria(rs.getInt("año"));
                    materias.add(materia);
                    
                }
                
                ps.close(); 
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
            }
        
        return materias; 
       }
        
    public List<Alumno> obtenerAlumnosXMateria(int id_materia){
        
        ArrayList<Alumno> alumnosMateria=new ArrayList<>(); //Tanto "a" como "i" son alias 
        String sql="SELECT a.id_alumno, dni, nombre, apellido, fecha_naciiento, estado FROM inscripcion i,alumno a WHERE i.id_alumno = a.id_alumno AND id_materia=? AND a.estado=1";
        
            try {
                PreparedStatement ps=con.prepareCall(sql);
                ps.setInt(1, id_materia);
                ResultSet rs= ps.executeQuery();
                while(rs.next()){
                    Alumno alumno = new Alumno();
                    alumno.setId_alumno(rs.getInt("id_alumno"));
                    alumno.setDni(rs.getInt("dni"));
                    alumno.setApellido(rs.getString("apellido"));
                    alumno.setNombre(rs.getString("nombre"));
                    alumno.setFecha_nacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
                    alumno.setEstado(rs.getBoolean("estado"));
                    alumnosMateria.add(alumno);
                }
                ps.close();
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
            }
        
        return alumnosMateria; 
        
        
    }
    
    
}
