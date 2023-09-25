/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.transversal.gestión.universidad.accesoADatos;

import Grupo33_universidad_Entidades.newpackage.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class MateriaData {
      private Connection con=null;

    public MateriaData() {
        con = Conexion.getConexion();
    }
       public Materia CrearMateria() {
        int anio = Integer.parseInt(JOptionPane.showInputDialog("Ingresar el Año"));
        String nombre = JOptionPane.showInputDialog("Ingresar Nombre");
        Materia materia = new Materia(nombre, anio, true);
        return materia;
    }
public void guardarMateria(Materia materia) {
        try {
            String sql = ("INSERT INTO materia (Nombre,Año, Estado) VALUES (?,?,?)");
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnioMateria());
            ps.setBoolean(3, materia.isActivo());
            ps.executeUpdate();
            ResultSet r = ps.getGeneratedKeys();
            if(r.next()){
                materia.setIdMateria(r.getInt(1));
               JOptionPane.showMessageDialog(null, "Materia guardada");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar");
        }
    }
public void modificarMateria(Materia materia){
    
    String sql = "UPDATE materia SET Nombre = ?, Año=?, Estado=? WHERE id_Materia = ?";
    PreparedStatement ps = null;
    
    try {
         ps = con.prepareStatement(sql);
         ps.setString(1, materia.getNombre());
        ps.setInt(2, materia.getAnioMateria());
         ps.setBoolean(3, materia.isActivo());
         ps.setInt(4, materia.getIdMateria());
        int exito = ps.executeUpdate();

     if (exito == 1) {
         JOptionPane.showMessageDialog(null, "Modificado Exitosamente.");
         } else {
         JOptionPane.showMessageDialog(null, "La Materia no existe");
        }
     } catch (SQLException ex) {
     JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia "+ex.getMessage());
    }

 
    
}

public void eliminarAlumno(int id) {

     try {
         String sql = "UPDATE materia SET Estado = 0 WHERE id_Materia = ? ";
         PreparedStatement ps = con.prepareStatement(sql);
          ps.setInt(1, id);
         int fila=ps.executeUpdate();

         if(fila==1){
             JOptionPane.showMessageDialog(null, " Se eliminó la materia.");
     }
     ps.close();
     } catch (SQLException e) {
     JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Materia");
     }
 }

public Materia buscarMateria(int id) {
    Materia materia = null;
    String sql = "SELECT Nombre,Año, Estado  FROM materia WHERE id_Materia = ? AND Estado = 1";
    PreparedStatement ps = null;
    try {
        ps = con.prepareStatement(sql);
        ps.setInt(1,id );
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
        materia=new Materia();
       materia.setIdMateria(id);
        materia.setNombre(rs.getString("nombre"));
        materia.setAnioMateria(rs.getInt("Año"));
        materia.setActivo(true);
         
        } else {
        JOptionPane.showMessageDialog(null, "No existe la materia");

        ps.close();}
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia "+ex.getMessage()); 

   }

    return materia;
   }

    public List<Materia> listarMateria() {
        List<Materia> materias = new ArrayList<>();
        try {
         String sql = "SELECT * FROM materia WHERE estado = 1 ";
         PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
         while (rs.next()) {
         Materia materia = new Materia();

         materia.setIdMateria(rs.getInt("id_materia"));
         materia.setNombre(rs.getString("nombre"));
        materia.setAnioMateria(rs.getInt("año"));
        materia.setActivo(rs.getBoolean("estado"));
        materias.add(materia);
     }
     ps.close();

     } catch (SQLException ex) {
     JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Alumno "+ex.getMessage());
     }
     return materias;
     }
    }

