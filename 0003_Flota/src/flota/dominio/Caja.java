
package flota.dominio;

import flota.dominio.Excepciones.CajaExcepcion;

public class Caja {
    
    private double peso;

    public Caja() {
        peso = 100;
    }
    public Caja(double peso) throws CajaExcepcion{
        if(peso < 0){
            //throw new IllegalArgumentException("La caja no puede tener un peso negativo");//Runtime exception, no hace falta declararla en el método
            throw new CajaExcepcion("No se puede crear una caja con un peso negativo");
        }
        else{
            this.peso = peso;
        }
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) throws CajaExcepcion{
        if(peso < 0){
            //throw new IllegalArgumentException("La caja no puede tener un peso negativo");//Runtime exception, no hace falta declararla en el método
            throw new CajaExcepcion("No se puede asignar un peso negativo a la caja");
        }
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Caja{" + "peso=" + peso + '}';
    }

    
    
    
    
  
}
