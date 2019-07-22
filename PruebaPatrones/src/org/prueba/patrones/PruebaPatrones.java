/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.prueba.patrones;

/**
 *
 * @author david
 */
public class PruebaPatrones {

    public static void main(String[] args) {
        String url1 = "/0031_AppAcciones_JSF_EJB-war/faces/flags/4x3/gb.svg";
        String url2 = "/0031_AppAcciones_JSF_EJB-war/faces/user/misAcciones.xhtml";

        System.out.println("url 1" + url1.matches(".user."));
        System.out.println("url 2" + url2.matches(".*user/.*"));

        for (int i = 0; i < 50; i++) {
            System.out.println(Math.random() / 2 + 0.75);
        }
    }
}
