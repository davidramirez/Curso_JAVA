/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecciones;

/**
 *
 * @author david
 */
public class Micoleccion<E> {
    //Mi coleccion generica
    private E elemento;

    public void setElemento(E elemento) {
        this.elemento = elemento;
    }

    public E getElemento() {
        return elemento;
    }
    
    
}
