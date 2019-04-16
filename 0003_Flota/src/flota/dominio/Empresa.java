/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flota.dominio;

/**
 *
 * @author begonaolea
 */
public class Empresa {
    
    //atributo de clase
    public static final int NUM_MAX_VEHICULOS = 4;
    
    private String nombre;
    //lista = array de  NUM_MAX_VEHICULOS vehiculos
    private static Vehiculo[] vehiculos;
    private static int indiceVehiculo = 0;
    
    static{
        vehiculos = new Vehiculo[NUM_MAX_VEHICULOS];
        vehiculos[indiceVehiculo++] = new Camion("0000A");
    }

    //constructores
    
    public Empresa(){
        this("TRANSPORTES YYY");
    }
    
    public Empresa(String nombre) {
        //llama al constructor Empesa(nombre y vehiculoinicial)

        this.nombre = nombre;
            //*******************************************************
          //Al hacer el array de vehiculos unico para todas las instancias, ya no es necesario 
          //crear el primer vehiculo de la empresa, lo creamos en el bloque de inicialización de
          //variables estáticas
//        this(nombre, new Vehiculo("0000A"));
        //******************************************************************
//        this.nombre = nombre;
//        this.vehiculos = new Vehiculo[NUM_MAX_VEHICULOS];
//        this.vehiculos[indiceVehiculo] = new Vehiculo("0000A"); 
//        indiceVehiculo ++;
    }
    
    public Empresa(String nombre, Vehiculo vehiculoInicial) {
        this.nombre = nombre;
        
        //Añadir el vehiculo si queda hueco
        if(indiceVehiculo < NUM_MAX_VEHICULOS)
        {
            vehiculos[indiceVehiculo] = vehiculoInicial;
            indiceVehiculo ++;
        }
    }
     
    public String getNombre() {
        return " ** " + nombre.toUpperCase();
    }
    
    //Devuelve un array del tamaño adecuado
    public static Vehiculo[] getFlotaVehiculos(){
        Vehiculo[] v = new Vehiculo[indiceVehiculo];
        for(int i=0;i<indiceVehiculo;i++){
            v[i] = vehiculos[i];
        }
        return v;
    }
    
    public static int getNumVehiculosDisponibles(){
        return indiceVehiculo;
    }
    
    public static void addVehiculo(Vehiculo v){
        //validar que no me paso
        if(indiceVehiculo == NUM_MAX_VEHICULOS){
            System.out.println("no puedo cargar el vehiculo");
            return;
        }
        vehiculos[indiceVehiculo] = v;
        indiceVehiculo ++; 
    }

    @Override
    public String toString() {
        return "Empresa{" + "nombre=" + nombre + ", vehiculos=" + vehiculos + ", numeroVehiculos=" + indiceVehiculo + '}';
    }
}
