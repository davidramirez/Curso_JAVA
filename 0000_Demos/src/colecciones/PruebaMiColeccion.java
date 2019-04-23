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
public class PruebaMiColeccion {
    public static void main(String[] args) {
        //Especificado tipo Integer
        Micoleccion<Integer> mi = new Micoleccion<>();
        
        mi.setElemento(new Integer(2));
        
        //Especificado tipo Curso
        Micoleccion<Curso> mi2 = new Micoleccion();
        mi2.setElemento(new Curso(1, "PAPAPA"));
        
        //sin especificar, se usa Object
        Micoleccion mi3 = new Micoleccion();
        mi3.setElemento("hola");
        mi3.setElemento(7);
        mi3.setElemento(mi);
        
    }
}
