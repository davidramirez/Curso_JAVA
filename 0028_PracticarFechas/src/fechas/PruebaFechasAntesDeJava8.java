/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fechas;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author david
 */
public class PruebaFechasAntesDeJava8 {
    public static void main(String[] args) throws ParseException {
        
        Date fecha = new Date();//fecha actual
        
        Date fecha2 = new Date(100, 1, 25);
        
        System.out.println("fecha1 "+fecha);
        System.out.println("fecha2 "+fecha2);
        
        Calendar fecha3 = Calendar.getInstance();
        System.out.println("Fecha 3 " + fecha3);
        System.out.println("Fecha 3 " + fecha3.getTime());
        
        Locale loc = Locale.FRANCE;
        Locale loc2 = new Locale("es", "MX");//ISO 639
        
        Calendar fecha4 = Calendar.getInstance(loc2);
        System.out.println("Primer día de la semana " +  fecha4.getFirstDayOfWeek());
        System.out.println("fecha 4 " + fecha4.getTime());
        fecha4.add(Calendar.DATE, 4);
        System.out.println("fecha 4 + 4 dias" + fecha4.getTime());
        
        DateFormat df1 = DateFormat.getDateInstance(DateFormat.MEDIUM);
        DateFormat df2 = DateFormat.getDateInstance(DateFormat.SHORT);
        DateFormat df3 = DateFormat.getDateInstance(DateFormat.FULL);
        
        System.out.println("fecha 4 medium " + df1.format(fecha4.getTime()));
        System.out.println("fecha 4 short " + df2.format(fecha4.getTime()));
        System.out.println("fecha 4 full " + df3.format(fecha4.getTime()));
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("fecha 4 personal " + sdf.format(fecha4.getTime()));
        
        
        String sFecha = "2-06-2001";
        Date fechaNueva = sdf.parse(sFecha);
        
        System.out.println("... fecha es " + fechaNueva +" " + sdf.format(fechaNueva));
    }
}
