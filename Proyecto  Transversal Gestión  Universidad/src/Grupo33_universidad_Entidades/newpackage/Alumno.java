package Grupo33_universidad_Entidades.newpackage;


import java.time.LocalDate;

/**
 *
 * @author User
 */
public class Alumno {
    
    public int id_alumno;
    public int dni; 
    public String apellido;
    public String nombre;
    public LocalDate fecha_nacimiento;
    public boolean estado;

    public Alumno() {
    }
    
    public Alumno(int dni, String apellido, String nombre, LocalDate fecha_nacimiento, boolean estado) {
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
        this.estado = estado;
    }

    public Alumno(int id_alumno, int dni, String apellido, String nombre, LocalDate fecha_nacimiento, boolean estado) {
        this.id_alumno = id_alumno;
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
        this.estado = estado;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Alumno{" + "id_alumno=" + id_alumno + ", dni=" + dni + ", apellido=" + apellido + ", nombre=" + nombre + ", fecha_Nacimiento=" + fecha_nacimiento + ", estado=" + estado + '}';
    }
    
    

    
    
}


