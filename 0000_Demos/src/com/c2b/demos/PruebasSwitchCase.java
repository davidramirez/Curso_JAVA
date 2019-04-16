/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2b.demos;

/**
 *
 * @author SISTEMAS
 */
public class PruebasSwitchCase {
    
    public static void main(String[] args) {
        int diaSemana = 4;
    
        switch (diaSemana){//~~son los puntos de entrada (sin break)
            case 1:
                System.out.println("Lunes");
            case 2:
                System.out.println("Martes");
            case 3:
                System.out.println("Miercoles");
            case 4:
                System.out.println("Jueves");
            default:
                System.out.println("algo");
        }
        
        switch (diaSemana){
            case 1:
                System.out.println("Lunes");
                break;
            case 2:
                System.out.println("Martes");
                break;
            case 3:
                System.out.println("Miercoles");
                break;
            case 4:
                System.out.println("Jueves");
                break;
            default:
                System.out.println("algo");
                break;
        }
        
    }
    
    
}
