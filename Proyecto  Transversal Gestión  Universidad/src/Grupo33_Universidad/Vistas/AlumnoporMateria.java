package Grupo33_Universidad.Vistas;

import Grupo33_universidad_Entidades.newpackage.*;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyecto.transversal.gestión.universidad.accesoADatos.*;
import Grupo33_universidad_Entidades.*;
import java.util.List;

/**
 *
 * @author usuario
 */
public class AlumnoporMateria extends javax.swing.JInternalFrame {

     private DefaultTableModel modelo= new DefaultTableModel();
     
     Inscripcion insc=new Inscripcion();
     IncripcionData id= new IncripcionData(); 
     Alumno alu= new Alumno(); 
     MateriaData md= new MateriaData();
     
     private Connection con= null;
    /**
     * Creates new form AlumnoporMateria
     */
    public AlumnoporMateria() {
        initComponents();
        con= Conexion.getConexion();
        armarCabecera();        
        cargarCombo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label2 = new java.awt.Label();
        jcMaterias = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtAlumnos = new javax.swing.JTable();
        jbSalir = new java.awt.Button();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 153, 102));

        label2.setName(""); // NOI18N
        label2.setText("Seleccione una materia:");

        jcMaterias.setToolTipText("");
        jcMaterias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcMateriasActionPerformed(evt);
            }
        });

        jtAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtAlumnos);

        jbSalir.setLabel("Salir");
        jbSalir.setName(""); // NOI18N
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Listado de Alumnos por Materia");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jcMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );

        getAccessibleContext().setAccessibleName("Alumnos por Materia");
        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        // TODO add your handling code here
        
        int resp = JOptionPane.showConfirmDialog(this, "Estás seguro que quieres salir?", "Cerrar Ventana", JOptionPane.YES_NO_OPTION);
        if (resp == JOptionPane.YES_OPTION){
            this.dispose();
        }
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jcMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcMateriasActionPerformed
        // TODO add your handling code here:
        borrarFilas();
        cargaTabla();
        //hay un error con el cargaTabla por el metodo de Alumnos por materia
    }//GEN-LAST:event_jcMateriasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Button jbSalir;
    private javax.swing.JComboBox<Materia> jcMaterias;
    private javax.swing.JTable jtAlumnos;
    private java.awt.Label label2;
    // End of variables declaration//GEN-END:variables

    private void armarCabecera(){
        modelo.addColumn("ID");
        modelo.addColumn("DNI");
        modelo.addColumn("Apellido");
        modelo.addColumn("Nombre");
        jtAlumnos.setModel(modelo);
        
        
    }
    public void cargaTabla(){
        
    IncripcionData id = new IncripcionData();
        Materia MatSel = (Materia)jcMaterias.getSelectedItem(); 
        if (MatSel!=null){            
            //List<Alumno> inscripciones = id.obtenerAlumnosXMateria(MatSel.getIdMateria());
            for (Alumno alum : id.obtenerAlumnosXMateria(MatSel.getIdMateria())){
                modelo.addRow(new Object[]{alum.getId_alumno(),alum.getDni(),alum.getApellido(),alum.getNombre()});
            }
    }
}
    
    public void cargarCombo(){
        MateriaData md= new MateriaData();
        ArrayList<Materia> materias = new ArrayList<>();

        for (Materia mat : md.listarMateria()) {
            materias.add(mat);
            jcMaterias.addItem(mat);
        }
                
    }
    
    public void borrarFilas() {
        int f = modelo.getRowCount()-1;
        for (; f >= 0; f--){
            modelo.removeRow(f);
        }
    }
}
