/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.pruebas;

import demo.servicios.SaludadorSessionBeanLocal;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author david
 */
public class ClienteHolaMundo {

    public static void main(String[] args) {
        try {
            Hashtable<String, String> hashTable = new Hashtable<String, String>();
            hashTable.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
            hashTable.put(Context.URL_PKG_PREFIXES, "com.sun.enterprise.naming");
            hashTable.put(Context.PROVIDER_URL, "localhost:3700");

            Context ctx = new InitialContext(hashTable);
            SaludadorSessionBeanLocal servicio = (SaludadorSessionBeanLocal) ctx.lookup("java:global/0029_HolaMundoEJBs/0029_HolaMundoEJBs-ejb/SaludadorSessionBean");

            System.out.println("Saludo es " + servicio.saludar("David"));
        } catch (NamingException ex) {
            Logger.getLogger(ClienteHolaMundo.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }
}
