/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2b.bancario.dominio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author david
 */
public class Banco {
    
    private static Banco miBanco = null;
    
    private List<Cliente> clientes = new ArrayList<Cliente>();
    
    private Banco(){
    }
    
    public static Banco getBanco(){
        if(miBanco == null){
            miBanco = new Banco();
        }
        return miBanco;
    }
    
    /**
     * Añade el cliente dado al banco si no existe
     * @param cliente El cliente a añadir
     * @return true si se añade el cliente. False si no se ha podido añadir
     */
    public boolean anadirCliente(Cliente cliente)
    {
        if(cliente == null){
            return false;
        }
        
        if(!clientes.contains(cliente)){
            clientes.add(cliente);
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
     * Devuelve un array con los clientes del banco. El array es del tamaño de numero de clientes
     * que hay actualmente en el banco
     * @return Un array con tantas posiciones como clientes tiene el banco. Null si no hay ninguno
     */
    public Cliente[] getListaClientes(){
        if(this.getNumeroDeClientes() == 0){        
            return null;
        }
        else{
            Cliente[] clientesBanco = new Cliente[this.getNumeroDeClientes()];
            for(int i = 0; i<this.getNumeroDeClientes();i++){
                clientesBanco [i] = clientes.get(i);
            } 
            return clientesBanco;
        }
    }

    public int getNumeroDeClientes() {
        return clientes.size();
    }
    
    public void imprimirEstado(){
        System.out.println("Numero de clientes: " + this.getNumeroDeClientes());
        System.out.println("Clientes: ");
        Cliente[] clientes = this.getListaClientes();
        if(clientes != null){
            for(Cliente c:clientes){
            c.imprimirEstadoCliente();
            }
        }
    }
    
    /**
     * Buscar el cliente por el id y añadirle la cuenta bancaria dada
     * @param idCliente
     * @param cuenta
     * @return true si la operación se ejecuta correctamente. False si no se encuentra al cliente o no se puede añadir la cuenta al cliente
     */
    public boolean anadirCuentaACliente(int idCliente, CuentaBancaria cuenta){
        Cliente c = this.buscarCliente(idCliente);
        if(c != null){
            if(c.anadirCuenta(cuenta)){
                return true;//La cuenta se ha añadido correctamente
            }
            else{
                System.out.println("No se ha podido asignar la cuenta al cliente");
                return false;
            }
        }
        else{
            System.out.println("No se ha encntrado el cliente");
            return false;
        }
    }
    
    /**
     * Busca el cliente en la lista mediante su id
     * @param idCliente
     * @return el cliente si lo encuentra. Null en caso de que no se encuentre.
     */
    private Cliente buscarCliente(int idCliente){
        for(int i=0;i<this.getNumeroDeClientes();i++){
            if(this.clientes.get(i).getId() == idCliente){
                return this.clientes.get(i);
            }
        }
        return null;
    }
    
}
