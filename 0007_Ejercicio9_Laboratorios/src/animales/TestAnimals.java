/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animales;

/**
 *
 * @author david
 */
public class TestAnimals {
    public static void main(String[] args) {
        Fish d = new Fish();
        Cat c = new Cat("Fluffy");
        Animal a = new Fish();
        Animal e = new Spider();
        Pet p = new Cat();
        
        Animal[] animals = new Animal[5];
        animals[0] = d;
        animals[1] = c;
        animals[2] = a;
        animals[3] = e;
        animals[4] = (Animal) p;
        
        for(Animal an:animals){
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Soy un " + an.getClass());
            an.eat();
            an.walk();
            
            if(an instanceof Pet)
            {
                Pet pet = (Pet) an;
                System.out.println("Soy una mascota");
                System.out.println("Mi nombre es "+pet.getName());
                pet.play();
                
                pet.setName("Nemo");
                System.out.println("Ahora me llamo "+pet.getName());
                
                //estático, hay que llamarlo de la clase
                Pet.dormir();
                //default, se le llama desde la instancia y usa la implementación de la clase 
                //que la ha sobreescrito (si lo ha hecho)
                pet.tirarCosas();
            }
        }
    }
    
}
