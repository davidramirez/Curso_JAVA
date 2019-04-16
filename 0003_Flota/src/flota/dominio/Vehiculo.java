package flota.dominio;

import flota.dominio.Excepciones.VehiculoExcepcion;
import java.util.Arrays;

/**
 * Clase que modela un Vehiculo de una flota de transporte tiene la capacidad de
 * cargar cajas
 *
 * @author begonaolea
 * @version 1.0
 */
public abstract class Vehiculo {

    //atributo de clase
    private static final int TOTAL_CAJAS_PERM_POR_DEF = 10;

    //atributos
    private String matricula = "";
    private double cargaMaxima = 3000.0;
    private Caja[] cajas;
    /**
     * atributo que representa la carga en kg que tiene el vehículo. No puede
     * superar la carga máxima y no puede tener valores negativos
     */
    private double cargaActual = 0;
    private int numCajas = 0;
    private final short TOTAL_CAJAS_PERMITIDAS;

    //const
    public Vehiculo(String matricula) {
        this.matricula = matricula;
        this.TOTAL_CAJAS_PERMITIDAS = TOTAL_CAJAS_PERM_POR_DEF;
        this.cajas = new Caja[TOTAL_CAJAS_PERMITIDAS];
    }

    public Vehiculo(String matricula, short totalCajasPermitidas, double cargaMaxPermitida) throws VehiculoExcepcion{
        
        if(totalCajasPermitidas <= 1){
            throw new VehiculoExcepcion("No se ha podido crear un vehículo con menos de una caja permitida");
        }
        if(cargaMaxPermitida <= 0){
            throw new VehiculoExcepcion("No se ha podido crear un vehículo con carga máxima menor o igual a cero");
        }
        this.matricula = matricula;
        this.TOTAL_CAJAS_PERMITIDAS = totalCajasPermitidas;
        this.cargaMaxima = cargaMaxPermitida;
        this.cajas = new Caja[TOTAL_CAJAS_PERMITIDAS];
    }

    //metodos
    /**
     * método que recibe el peso de una caja a cargar y añade esta carga al
     * camión, incrementando el numero de cajas cargadas en uno
     *
     * @param caja - caja a cargar peso en kg de la caja
     * @throws flota.dominio.Excepciones.VehiculoExcepcion
     * Si no se puede cargar la caja
     */
    public void cargar(Caja caja) throws VehiculoExcepcion{
        //validar que solo entren
        if (numCajas >= this.TOTAL_CAJAS_PERMITIDAS) {
            throw new VehiculoExcepcion("No se puede cargar, no entran más cajas en el vehículo");
        }
        //validar que no super la carga //caja.getPeso() < 0 ||  comprobacion ya innecesaria
        if ( this.cargaMaxima < (this.cargaActual + caja.getPeso())) {
            VehiculoExcepcion ex = new VehiculoExcepcion("No se puede cargar, se supera la carga máxima del vehículo");
            ex.setExcesoDePeso(this.cargaActual+caja.getPeso()-this.cargaMaxima);
            throw ex;
        }
        this.cargaActual += caja.getPeso();
        this.cajas[numCajas] = caja;
        this.numCajas++;
    }

    /**
     * descarga la última caja cargada
     *
     * @return Caja descarga la caja . Si no hay caja devueve un null
     */
    public Caja descargar() {
        //validar que haya cajas
        if (this.numCajas == 0) {
            System.out.println(".. no quedan cajas");
            return null;
        }
        //devolvemos al última caja
        this.numCajas--;
        Caja cajaDescargar = cajas[this.numCajas];
        cajas[this.numCajas] = null;
        //otra opcion
        // Caja cajaDescargar = cajas[-- this.numCajas];
        
        this.cargaActual -= cajaDescargar.getPeso();
        return cajaDescargar;
    }
    
    
    public Caja descargar(int posicionCaja){
        return null;
    }

    public double getCargaActual() {
        return cargaActual;
    }

    public double getCargaMaxima() {
        return cargaMaxima;
    }

    public int getNumCajas() {
        return numCajas;
    }

    public String getMatricula() {
        return matricula;
    }

    /**
     * método que devuelve una array con las cajas
     * que hay en el camión. 
     * Si devuelve null es que no hay cajas
     * @return 
     */
    public Caja[]  getCajasCargadas(){
        
        if(this.numCajas == 0){
            return null;
        }
        
        Caja[] cajasCargadas = new Caja[this.numCajas];
        int indice =0;
        for(Caja c : this.cajas){
            if(c == null){
                break;
            }
            cajasCargadas[indice ++] = c;
        }
        return cajasCargadas;
    }

    @Override
    public String toString() {
        
//        System.out.println(" lista ");
//        for(Caja c : cajas){
//            System.out.println(". " + c);
//        }
        return "Vehiculo{" + "matricula=" 
                + matricula + ", cargaMaxima=" 
                + cargaMaxima + ", cargaActual=" 
                + cargaActual + ", numCajas=" + numCajas 
                + ", lista cajas :" + Arrays.toString(this.cajas) + '}';
    }

    public abstract double calcularConsumoFuel();

    public short getTOTAL_CAJAS_PERMITIDAS() {
        return TOTAL_CAJAS_PERMITIDAS;
    }
    

}
