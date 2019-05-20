/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fechas;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 *
 * @author david
 */
public class PruebaFechasJava8 {
    public static void main(String[] args) {
        
        //Enumeraciones 
        
        System.out.printf(" Mes es %s !!", Month.MAY);
        System.out.printf(" Día de la semana es %s !!", DayOfWeek.of(1));
        
        DayOfWeek dow = DayOfWeek.MONDAY;
        System.out.printf("%n %s", dow.getDisplayName(TextStyle.FULL, Locale.GERMAN));
        System.out.printf("%n %s", dow.getDisplayName(TextStyle.FULL, new Locale("es", "ES")));
        
        
        
        //De madrid a tokio
        System.out.println("Vuelo madrid Tokio");
        LocalDateTime fechaHoraSalidaVuelo = LocalDateTime.of(2017, Month.MAY, 20, 19, 30);
        ZoneId zonaSalidaVuelo = ZoneId.of("Europe/Paris");
        System.out.println("Fecha hora local de salida: " + fechaHoraSalidaVuelo);
        
        ZonedDateTime salida = ZonedDateTime.of(fechaHoraSalidaVuelo, zonaSalidaVuelo);
        
        ZoneId zonaLlegadaVuelo = ZoneId.of("Asia/Tokyo");
        
        ZonedDateTime llegada = salida.withZoneSameInstant(zonaLlegadaVuelo).plusMinutes(400);
        
        System.out.println("Fecha hora local de llegada: " + llegada);
        
        DateTimeFormatter dtf = DateTimeFormatter.RFC_1123_DATE_TIME;
        
        System.out.printf("El vuelo sale a las %s de Bilbao y llega a las %s a Tokyo",dtf.format(salida), dtf.format(llegada));
    
    
        //Period, periodo de tiempo
        Period diezDias = Period.ofDays(10);
        
        //Años que cumple una persona
        LocalDate diaHoy = LocalDate.now();
        LocalDate fechaNac = LocalDate.of(1993, Month.JUNE, 28);
        
        Period period = Period.between(fechaNac, diaHoy);
        System.out.println("");
        System.out.println("años " + period.getYears());
    }
}
