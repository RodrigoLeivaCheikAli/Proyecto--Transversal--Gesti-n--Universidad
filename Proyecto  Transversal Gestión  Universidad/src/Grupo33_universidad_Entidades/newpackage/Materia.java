/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grupo33_universidad_Entidades.newpackage;

/**
 *
 * @author usuario
 */
public class Materia implements Comparable<Materia> {
    private int idMateria;
    private String nombre;
    private int anioMateria;
    private boolean activo; 
    
    public Materia(){} 

    public Materia(int idMateria, String nombre, int anioMateria, boolean activo) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.anioMateria = anioMateria;
        this.activo = activo;
    }

    public Materia(String nombre, int anioMateria, boolean activo) {
        this.nombre = nombre;
        this.anioMateria = anioMateria;
        this.activo = activo;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnioMateria() {
        return anioMateria;
    }

    public void setAnioMateria(int anioMateria) {
        this.anioMateria = anioMateria;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return idMateria+", " +nombre+", " + anioMateria;
    }

    @Override
    public int compareTo(Materia t) {
        if(idMateria==t.idMateria){
            return 0; 
        } else if(idMateria>t.idMateria){
            return 1;
        }else{
            return -1; 
        }
    }
    }

    
    

