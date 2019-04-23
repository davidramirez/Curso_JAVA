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
public class PruebaHilos {
    public static void main(String[] args) {
        System.out.println("Inicio main........");
        Runnable sn = new SumadorNumeros();
        
        //sn.run();
        
        //Crear el runnable 2
        Saludador s = new Saludador("Hoooooolaaaaaa", 40);

        //Lanzar dos hilos
        Thread hilo1 = new Thread(sn);
        Thread hilo2 = new Thread(sn);
        Thread hilo3 = new Thread(s);
        System.out.println(hilo1.isAlive());
        hilo1.start();
        //hilo1.start();//Provoca un IllegalThreadState Exception. un hilo solo se puede lanzar una vez
        hilo2.start();
        hilo3.start();
        
        System.out.println(hilo1.isAlive());//Dice si el hilo está en funcionamiento (estado runnable o running)
        
        System.out.println("..... Fin del main");
    }
}
