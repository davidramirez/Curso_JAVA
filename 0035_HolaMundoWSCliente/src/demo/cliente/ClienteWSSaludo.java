/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.cliente;

import demo.cliente.ws.ProductCode;
import demo.cliente.ws.ProductoException_Exception;
import demo.cliente.ws.SaludoWebService;
import demo.cliente.ws.SaludoWebService_Service;

/**
 *
 * @author david
 */
public class ClienteWSSaludo {
    public static void main(String[] args) {
        SaludoWebService_Service s = new SaludoWebService_Service();
        SaludoWebService saludoWS = s.getSaludoWebServicePort();
        
        String saludo = saludoWS.saludar("Patata");
        
        System.out.println("Saludo......  " + saludo );
        
        try {
            ProductCode p = saludoWS.getProductCodeById("SW");
            
            System.out.println("....Codigo producto .... :  " + p.getDescription() + " " + p.getDiscountCode());
            
            saludoWS.getProductCodeById("s");
        } catch (ProductoException_Exception ex) {
            System.out.println("No existe el código de producto");
        }
    }
}
