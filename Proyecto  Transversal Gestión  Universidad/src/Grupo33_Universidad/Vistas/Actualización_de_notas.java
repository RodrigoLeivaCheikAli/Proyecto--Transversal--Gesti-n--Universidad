/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grupo33_Universidad.Vistas;

import Grupo33_universidad_Entidades.newpackage.Alumno;
import Grupo33_universidad_Entidades.newpackage.Inscripcion;
import Grupo33_universidad_Entidades.newpackage.Materia;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import proyecto.transversal.gestión.universidad.accesoADatos.*;

/**
 *
 * @author User
 */
public class Actualización_de_notas extends javax.swing.JInternalFrame {
private DefaultTableModel modelo = new DefaultTableModel();
private Connection con= null;
public Alumno alum;
public Materia materia;
public Inscripcion inscripcion;
IncripcionData nota = new IncripcionData();

    /**
     * Creates new form Actualización_de_notas
     */
    public Actualización_de_notas() {
        
        con= Conexion.getConexion();
        initComponents();
        ArmarCabecera();
        obtenerAlumno();
        obtenerMateria();
        obtenerInscripcion();
     
         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSalir = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cboAlumnos = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        TNotas = new javax.swing.JTable();

        setBackground(new java.awt.Color(0, 153, 102));
        setClosable(true);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel1.setText("Carga de Notas");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Seleccione el Alumno");

        cboAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboAlumnosActionPerformed(evt);
            }
        });

        TNotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TNotas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cboAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addGap(96, 96, 96))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnSalir))
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void cboAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboAlumnosActionPerformed
        // TODO add your handling code here:
         modelo.setRowCount(0);
        alum = (Alumno) cboAlumnos.getSelectedItem();
        for (Inscripcion in : nota.obtenerInscripcionesPorAlumno(alum.getId_alumno()) ) {
            for (Materia obtenerMateriasCursada : nota.obtenerMateriasCursadas(alum.getId_alumno())) {
                
                modelo.addRow(new Object []{obtenerMateriasCursada.getIdMateria(), obtenerMateriasCursada.getNombre(), in.getNota()});
               
            }
 
            
        }
    }//GEN-LAST:event_cboAlumnosActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
         this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        alum = (Alumno) cboAlumnos.getSelectedItem();
        
        nota.actualizarNota(alum.getId_alumno(), WIDTH, WIDTH);
    }//GEN-LAST:event_btnGuardarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TNotas;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<Alumno> cboAlumnos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
private void ArmarCabecera(){
    modelo.addColumn("Codigo");
    modelo.addColumn("Nombre");
    modelo.addColumn("Notas");
    TNotas.setModel(modelo);
    TNotas.setDefaultEditor(Object.class, null);

// Ahora, para permitir que ciertas celdas sean editables, puedes utilizar un TableCellEditor personalizado:
JTextField txt = new JTextField();
txt.setBorder(null);
DefaultCellEditor editor = new DefaultCellEditor(txt); 

// Luego, asigna el editor a las celdas que deseas que sean editables. Por ejemplo, si deseas que la segunda columna sea editable:
TNotas.getColumnModel().getColumn(2).setCellEditor(editor);
    
}
private void obtenerAlumno(){
 
    
    
    try {
            String sql = "SELECT * FROM alumno where estado = true";
            PreparedStatement ps= con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id_Alumno");
                int DNI = resultSet.getInt("dni");
                String apellido = resultSet.getString("apellido");
                String nombre = resultSet.getString("nombre");
                Date fechaNacimientoSQL = resultSet.getDate("fecha_nacimiento");
                LocalDate fechaNacimiento = fechaNacimientoSQL.toLocalDate();
                boolean activo = resultSet.getBoolean("estado");

                 alum = new Alumno(id, DNI, nombre, apellido, fechaNacimiento, activo);
                cboAlumnos.addItem(alum);
            }


            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno");
        }

}    
private void obtenerMateria(){
     try {
            String sql = "SELECT * FROM materia ";
            PreparedStatement ps= con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
              int id = resultSet.getInt("id_materia");
              String nombre = resultSet.getString("nombre");
              int año = resultSet.getInt("año");
              boolean activo = resultSet.getBoolean("estado");
                materia = new Materia(id, nombre, SOMEBITS, activo);
            }
             


            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno");
        }
}
private void obtenerInscripcion(){
     try {
            String sql = "SELECT * FROM inscripcion ";
            PreparedStatement ps= con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int id_Insc = resultSet.getInt("id_inscripto");
                int nota = resultSet.getInt("nota");
                int id_Alum = resultSet.getInt("id_alumno");
                int id_Mat = resultSet.getInt("id_materia");
                inscripcion = new Inscripcion(id_Insc, nota, alum, materia);
            }
             


            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno");
        }
}

       

}



