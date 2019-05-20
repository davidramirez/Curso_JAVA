/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.fichajes.modelo;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalUnit;

/**
 *
 * @author david
 */
public class InformeFichajeItem implements Serializable {

    private LocalDateTime fechaHoraEntrada;
    private LocalDateTime fechaHoraSalida;
    private Duration duracion;
    private Empleado empleado;

    public InformeFichajeItem(LocalDateTime fechaHoraEntrada, LocalDateTime fechaHoraSalida, Empleado empleado) {
        this.fechaHoraEntrada = fechaHoraEntrada;
        this.fechaHoraSalida = fechaHoraSalida;
        this.empleado = empleado;

        if (fechaHoraSalida != null) {
            this.duracion = Duration.between(fechaHoraEntrada, fechaHoraSalida);
        }
    }

    public String getFechaHoraEntradaFormateado() {
        DateTimeFormatter d = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return d.format(fechaHoraEntrada);
    }

    public String getFechaHoraSalidaFormateado() {
        if (this.fechaHoraSalida != null) {
            DateTimeFormatter d = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            return d.format(fechaHoraSalida);
        }

        return "Sin cerrar";//TODO mejorar
    }

    public String getDuracionFormateado() {
        if (this.fechaHoraSalida != null) {
            long m = duracion.toMinutes();
            return String.format("%02d:%02d", m/60, m%60);
            //return durEnMin/60 + ":" + durEnMin%60 + " horas";//TODO mejorar
        }
        return "";
    }

    public Empleado getEmpleado() {
        return empleado;
    }

}
