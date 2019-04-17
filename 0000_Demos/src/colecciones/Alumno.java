/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecciones;

import java.util.Objects;

/**
 *
 * @author david
 */
public class Alumno implements Comparable<Alumno>{
    private static int idActual = 1;
    private String nombre;
    private int curso;
    private int id;

    public Alumno(String nombre, int curso) {
        this.nombre = nombre;
        this.curso = curso;
        this.id = idActual++;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    @Override
    public String toString() {
        return "Alumno{" + "id= " + id + ", nombre=" + nombre + ", curso=" + curso + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.nombre);
        hash = 71 * hash + this.curso;
        System.out.println("El hash code es " + hash);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("...Estoy comparando con equals");
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Alumno other = (Alumno) obj;
        if (this.curso != other.curso) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Alumno o) {
        //Comparo por curso y luego por nombre
        //Devuelve 0 si iguales
        //devuelve 1 si this > el que comparo
        //Devuelve -1 si soy menor que el que comparo
        if(this.curso < o.getCurso()){
            return -1;
        }else if(this.curso > o.getCurso()){
            return 1;
        }else{
            return this.nombre.compareTo(o.getNombre());
        }
    }

    

    
    
}
