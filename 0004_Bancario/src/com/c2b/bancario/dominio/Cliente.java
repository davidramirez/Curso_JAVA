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
public class Cliente {
    
    private static int ultimoId = 0;
    
    private int id;
    private String nombre;
    private List<CuentaBancaria> cuentas;
    
    /**
     * Crea un cliente con el nombre indicado. Su id se genera automáticamente,
     * teniendo el id 1 el primer cliente creado.
     * Se le asigna por defecto una nueva Cuenta Corriente con el num de cuenta dado
     * @param nombre 
     * @param numeroDeCuenta 
     */
    public Cliente(String nombre, String numeroDeCuenta){
        this(nombre, new CuentaCorriente(numeroDeCuenta));
    }
    
    /**
     * Se crea un cliente con el nombre indicado y se le asigna la cuenta dada.
     * El primer cliente tenndrá el id 1
     * @param nombre
     * @param cuenta 
     */
    public Cliente(String nombre, CuentaBancaria cuenta){
        this.nombre = nombre;
        this.cuentas = new ArrayList<CuentaBancaria>();
        this.cuentas.add(cuenta);
        this.id = ++ultimoId;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    
    public int getNumeroDeCuentas() {
        return this.cuentas.size();
    }
    
    /**
     * Añade la cuenta dada si su id no coincide con ninguna de las que tenia el cliente
     * @param cuenta
     * @return false si no se puede añadir la cuenta. True si se ha podido
     */
    public boolean anadirCuenta(CuentaBancaria cuenta){
        if(cuenta==null){
            return false;
        }
        
        if(this.buscarCuenta(cuenta.getNumeroDeCuenta()) == null){
            cuentas.add(cuenta);
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
     * Devuelve un array con las cuentas del cliente. El array es del tamaño de numero de cuentas
     * que tiene actualmente el cliente
     * @return Un array con tantas posiciones como cuentas tiene el cliente. Null si no tiene ninguna
     */
    public CuentaBancaria[] getListaCuentasBancarias(){
        if(this.getNumeroDeCuentas() == 0)
        {        
            return null;
        }
        else
        {
            CuentaBancaria[] cuentasCliente = new CuentaBancaria[this.getNumeroDeCuentas()];
            for(int i = 0; i<this.getNumeroDeCuentas();i++)
            {
                cuentasCliente [i] = cuentas.get(i);
            } 
            
            return cuentasCliente;
        }
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", cuentas=" + cuentas + ", numeroDeCuentas=" + this.getNumeroDeCuentas() + '}';
    }
    
    public void imprimirEstadoCliente(){
        System.out.println("Cliente{" + "id=" + id + ", nombre=" + nombre + ", numeroDeCuentas=" + this.getNumeroDeCuentas());
        System.out.println("Cuentas: ");
        CuentaBancaria[] cuentas = this.getListaCuentasBancarias();
        if(cuentas != null)
        {
            for(CuentaBancaria c:cuentas){
                System.out.println(c);
            }
        }
    }
    
    
    public boolean retirarDinero(String idCuenta, double cantidad){
        CuentaBancaria c  = this.buscarCuenta(idCuenta);
        if(c != null)
        {
            return c.retirarDinero(cantidad);
        }
        else
        {
            System.out.println("No se ha encontrado la cuenta en el cliente");
            return false;
        }
    }
    
    public boolean ingresarDinero(String idCuenta, double cantidad){
        CuentaBancaria c = this.buscarCuenta(idCuenta);
        if(c != null){
            return c.ingresarDinero(cantidad);
        }
        //Fallo, no se ha encontrado el numero de cuenta
            System.out.println("No se ha encontrado la cuenta en el cliente");
            return false;
    }
    
    /**
     * Busca la cuenta con el id dado
     * @param idCuenta
     * @return la cuenta que se corresponde al id. Null en caso de que no se encuentre
     */
    private CuentaBancaria buscarCuenta(String idCuenta){
        for(int i=0;i<this.getNumeroDeCuentas();i++)
        {
            if(this.cuentas.get(i).getNumeroDeCuenta().equals(idCuenta))
            {
                return this.cuentas.get(i);
            }
        }
        //Si no se encuentra
        return null;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
}
