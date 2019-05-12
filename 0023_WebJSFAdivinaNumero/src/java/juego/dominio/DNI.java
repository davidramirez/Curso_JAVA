/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego.dominio;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author david
 */
public class DNI implements Serializable{
    private String numeros;
    private String letra;

    public DNI(String numeros, String letra) {
        this.numeros = numeros;
        this.letra = letra;
    }

    public String getNumeros() {
        return numeros;
    }

    public void setNumeros(String numeros) {
        this.numeros = numeros;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.numeros);
        hash = 31 * hash + Objects.hashCode(this.letra);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DNI other = (DNI) obj;
        if (!Objects.equals(this.numeros, other.numeros)) {
            return false;
        }
        if (!Objects.equals(this.letra, other.letra)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DNI{" + "numeros=" + numeros + ", letra=" + letra + '}';
    }
    
    
}
