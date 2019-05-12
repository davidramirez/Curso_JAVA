/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego.web.conversores;

import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import juego.dominio.DNI;

/**
 *
 * @author david
 */
//@FacesConverter("dniconversor")
@FacesConverter(forClass = juego.dominio.DNI.class)//Se aplica a todas las propiedades de clase DNI
public class DNIConversor implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        if(value == null || !Pattern.matches("[0-9]{8}[a-z]", value)){//value.trim().length()<9 || value.trim().length()>10){
            throw new ConverterException(new FacesMessage("El dni dado no es valido"));
        }
        String num = value.substring(0,8);
        String letra = value.substring(8, 9);
        DNI dni = new DNI(num, letra);
        return dni;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        System.out.println("getasstring");
        DNI d = (DNI) value;
        return d.getNumeros()+d.getLetra();
    }
    
}
