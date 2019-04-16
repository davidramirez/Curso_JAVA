/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego.pruebas;

import juego.modelo.PalosBaraja;

/**
 *
 * @author SISTEMAS
 */
public class PruebasEnum {
    public static void main(String[] args) {
        //Probar enum
        
        PalosBaraja palo = PalosBaraja.BASTOS;
        
        PalosBaraja palo2 = PalosBaraja.BASTOS;
        
        if(palo == palo2){//Los posibles valores del enum son siempre los mismos objetos
            System.out.println("son iguales");
        }
        
        System.out.println(PalosBaraja.COPAS);
        
        System.out.println("enumeracion: "+ PalosBaraja.values());
        for(PalosBaraja p:PalosBaraja.values())
        {
            System.out.println(p + " ");
        }
        
        
        switch(palo){
            case OROS:
                System.out.println("Vale 10");
                break;
            case COPAS:
                System.out.println("Vale 20");
                break;
            case ESPADAS:
                System.out.println("Vale 30");
                break;
            case BASTOS:
                System.out.println("Vale 40");
                break;
        }
        
    }
}
