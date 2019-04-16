/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constructores;

/**
 *
 * @author SISTEMAS
 */
public class Arana extends Animal {
    
    private boolean venenosa;
    //Casca por que animal ya no tiene un constructor por defecto sin argumentos
    //(hemos definido uno). Hay que usar el super con los argumentos adecuados
    
    public Arana(){
        this(false);
    }
    
    public Arana(boolean venenosa){
        super(8);
        this.venenosa = venenosa;
    }
    
}
