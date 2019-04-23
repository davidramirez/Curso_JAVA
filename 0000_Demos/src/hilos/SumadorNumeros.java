/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

/**
 *
 * @author david
 */
public class SumadorNumeros implements Runnable {

    @Override
    public void run() {
        int acum = 0;
        for(int i = 0;i<20;i++){
            acum += i;
            System.out.println(". total " + acum);
        }
        System.out.println(".... fin SumadorNumeros");
    }
    
}
