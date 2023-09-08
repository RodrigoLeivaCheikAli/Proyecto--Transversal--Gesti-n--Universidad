/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grupo33_universidad_Entidades.newpackage;

import java.sql.Date;

/**
 *
 * @author User
 */
public class Alumno {
    
    public int IDAlumno;
    public int dni; 
    public String Apellido;
    public String Nombre;
    public LocalDate FechaNacimiento;
    public boolean estado;

    public Alumno() {
    }

    public Alumno(int dni, String Apellido, String Nombre, Date FechaNacimiento, boolean estado) {
        this.dni = dni;
        this.Apellido = Apellido;
        this.Nombre = Nombre;
        this.FechaNacimiento = FechaNacimiento;
        this.estado = estado;
    }

    public Alumno(int IDAlumno, int dni, String Apellido, String Nombre, Date FechaNacimiento, boolean estado) {
        this.IDAlumno = IDAlumno;
        this.dni = dni;
        this.Apellido = Apellido;
        this.Nombre = Nombre;
        this.FechaNacimiento = FechaNacimiento;
        this.estado = estado;
    }

    public int getIDAlumno() {
        return IDAlumno;
    }

    public void setIDAlumno(int IDAlumno) {
        this.IDAlumno = IDAlumno;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(Date FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Alumno{" + "IDAlumno=" + IDAlumno + ", dni=" + dni + ", Apellido=" + Apellido + ", Nombre=" + Nombre + ", FechaNacimiento=" + FechaNacimiento + ", estado=" + estado + '}';
    }
    

}


