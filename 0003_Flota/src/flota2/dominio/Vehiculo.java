package flota2.dominio;

/**
 * Clase que modela un Vehiculo de una flota de transporte tiene la capacidad de
 * cargar cajas
 *
 * @author begonaolea
 * @version 1.0
 */
public class Vehiculo {

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

    public Vehiculo(String matricula,
            short totalCajasPermitidas,
            double cargaMaxPermitida) {
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
     * @param Caja - caja a cargar peso en kg de la caja
     */
    public void cargar(Caja caja) {
        //validar que solo entren
        if (numCajas >= this.TOTAL_CAJAS_PERMITIDAS) {
            System.out.println("..No se cargó la caja.  Ya no caben mas cajas");
            return;
        }
        //validar que no super la carga
        if (caja.getPeso() < 0
                || this.cargaMaxima < (this.cargaActual + caja.getPeso())) {
            System.out.println("..No se cargó la caja.  Ha superado la carga máxima permitida");
            return;
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
        //otra opcion
        // Caja cajaDescargar = cajas[-- this.numCajas];
        cajas[this.numCajas] = null;
        
        this.cargaActual -= cajaDescargar.getPeso();
        return cajaDescargar;
    }
    
    
    public Caja descargar(int posicionCaja){
        return null;
    }

    public double getCargaActual() {
        return cargaActual;
    }

    public int getNumCajas() {
        return numCajas;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "matricula=" + matricula + ", cargaMaxima=" + cargaMaxima + ", cargaActual=" + cargaActual + ", numCajas=" + numCajas + '}';
    }

    public String getMatricula() {
        return this.matricula;
    }

    public String listarCajasEnString() {
        String cajasEnTexto="";
        for(int i = 0;i<this.numCajas;i++){
            cajasEnTexto += ""+ (i+1) + " "+ this.cajas[i].toString()+"\n";
        }
        return cajasEnTexto;
    }
    
    /**
     * Devuelve las cajas que transporta el vehiculo. El array es del tamaño del num de cajas
     * @return null si el num de cajas es 0
     */
    public Caja[] getCajas(){
        if(this.numCajas==0)
        {
            return null;
        }
        Caja[] listaCajas = new Caja[this.numCajas];
        
        for(int i=0;i<this.numCajas;i++)
        {
            listaCajas[i] = this.cajas[i]; 
        }
        return listaCajas;
    }

}
