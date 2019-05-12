/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego.web.validadores;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author david
 */
@FacesValidator("miValidador")
public class NumeroAleatorioValidador implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        
        System.out.println("valor " + value);
        System.out.println(value.getClass());
        
        Integer valor = (Integer) value;
        
        if(valor <=0 || valor >= 21){
            throw new ValidatorException(new FacesMessage("El número debe estar comprendido entre 1 y 20"));
        }
        
    }
    
}
