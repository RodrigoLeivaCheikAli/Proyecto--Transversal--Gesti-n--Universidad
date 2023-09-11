/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grupo33_universidad_Entidades.newpackage;

/**
 *
 * @author User
 */
public class Inscripcion {
     int id_inscripto;
 int nota;
 int id_alumno;
 int id_materia;

    public Inscripcion() {
    }

    public Inscripcion(int id_inscripto, int nota, int id_alumno, int id_materia) {
        this.id_inscripto = id_inscripto;
        this.nota = nota;
        this.id_alumno = id_alumno;
        this.id_materia = id_materia;
    }

    public int getId_inscripto() {
        return id_inscripto;
    }

    public void setId_inscripto(int id_inscripto) {
        this.id_inscripto = id_inscripto;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public int getId_materia() {
        return id_materia;
    }

    public void setId_materia(int id_materia) {
        this.id_materia = id_materia;
    }

    @Override
    public String toString() {
        return "Inscripcion{" + "idInscripto=" + id_inscripto + ", nota=" + nota + ", idAlumno=" + id_alumno + ", idMateria=" + id_materia + '}';
    }
 
}


