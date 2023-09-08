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

}

