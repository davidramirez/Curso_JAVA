/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 *
 * @author david
 */
public class Sumador {
    public static void main(String[] args) {
        //Recorrer y sumar si son enteros. Si no, avisar por consola
        int suma = 0;
        int divisionSuma = 0;
        for(String a:args)
        {
            try{
                //System.out.println(a);
                int n = Integer.parseInt(a);
                suma = (suma + n);
                divisionSuma = suma / n;
            }catch(NumberFormatException e1){
                System.err.println("El argumento "+a+" no es un entero y no se sumará");
            }catch(ArithmeticException e2){
                System.err.println("No puedo continuar. No se puede dividir por 0");
                return;
            }
        }
        System.out.println("La suma de los argumentos numéricos es " + suma + ", división "+ divisionSuma);
    }
}
