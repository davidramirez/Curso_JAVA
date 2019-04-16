/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2b.bancario.dominio;

/**
 *
 * @author david
 */
public class Cliente {
    
    private static int ultimoId = 0;
    private final static int NUM_MAX_CUENTAS = 2;
    
    private int id;
    private String nombre;
    private CuentaBancaria[] cuentas;
    private int numeroDeCuentas;
    
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
        this.cuentas = new CuentaBancaria[NUM_MAX_CUENTAS];
        this.cuentas[0] = cuenta;
        this.numeroDeCuentas++;
        this.id = ++ultimoId;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    
    public int getNumeroDeCuentas() {
        return this.numeroDeCuentas;
    }
    
    /**
     * Añade la cuenta dada si no supera el num max de cuentas
     * @param cuenta
     * @return false si no se puede añadir la cuenta. True si se ha podido
     */
    public boolean anadirCuenta(CuentaBancaria cuenta)
    {
        if(cuenta==null)
        {
            return false;
        }
        
        if(numeroDeCuentas < NUM_MAX_CUENTAS)
        {
            cuentas[numeroDeCuentas++] = cuenta;
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Devuelve un array con las cuentas del cliente. El array es del tamaño de numero de cuentas
     * que tiene actualmente el cliente
     * @return Un array con tantas posiciones como cuentas tiene el cliente. Null si no tiene ninguna
     */
    public CuentaBancaria[] getListaCuentasBancarias(){
        if(numeroDeCuentas == 0)
        {        
            return null;
        }
        else
        {
            CuentaBancaria[] cuentasCliente = new CuentaBancaria[numeroDeCuentas];
            for(int i = 0; i<numeroDeCuentas;i++)
            {
                cuentasCliente [i] = cuentas[i];
            } 
            
            return cuentasCliente;
        }
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", cuentas=" + cuentas + ", numeroDeCuentas=" + numeroDeCuentas + '}';
    }
    
    public void imprimirEstadoCliente(){
        System.out.println("Cliente{" + "id=" + id + ", nombre=" + nombre + ", numeroDeCuentas=" + numeroDeCuentas);
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
        for(int i=0;i<numeroDeCuentas;i++)
        {
            if(this.cuentas[i].getNumeroDeCuenta().equals(idCuenta))
            {
                return this.cuentas[i];
            }
        }
        //Si no se encuentra
        return null;
    }
    
}
