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
public class Animal {
    private int numPatas;

    //El constructor por dfecto que se genera al compilar
    /*public Animal(){
        super();
    }*/
    
    public Animal(int patas){
        //super();//aunque no se ponga, lo pone el compilador siempre
        this.numPatas = patas;
    }
    
    public int getNumPatas() {
        return numPatas;
    }
    
    
}
