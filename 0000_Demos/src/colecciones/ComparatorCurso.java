/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecciones;

import java.util.Comparator;

/**
 *
 * @author david
 */
public class ComparatorCurso implements Comparator<Curso> {

    @Override
    public int compare(Curso o1, Curso o2) {
        if(o1.getId() == o2.getId()){
            return 0;
        }
        return o1.getDescripcion().compareTo(o2.getDescripcion());
        
    }
    //TODO probar mirar si son iguales para busquedas al comparar primero si el id es igual y luego el string
}
