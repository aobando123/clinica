/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaLogica.clases;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author mean
 */
public class Cita {
    private int idCita;
    private LocalDate fechaCita;
    private Medico citaMed ;
    private Paciente citaPac;
    private String descripcion;
    private String resultado;

    public Cita(int idCita, LocalDate fechaCita, Medico citaMed, Paciente citaPac, String descripcion, String resultado) {
        this.idCita = idCita;
        this.fechaCita = fechaCita;
        this.citaMed = citaMed;
        this.citaPac = citaPac;
        this.descripcion = descripcion;
        this.resultado = resultado;
    }

    public int getIdCita() {
        return idCita;
        
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public LocalDate getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(LocalDate fechaCita) {
        this.fechaCita = fechaCita;
    }

    public Medico getCitaMed() {
        return citaMed;
    }

    public void setCitaMed(Medico citaMed) {
        this.citaMed = citaMed;
    }

    public Paciente getCitaPac() {
        return citaPac;
    }

    public void setCitaPac(Paciente citaPac) {
        this.citaPac = citaPac;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "Cita{" + "idCita=" + idCita + ", fechaCita=" + fechaCita + ", citaMed=" + citaMed.toString() + ", citaPac=" + citaPac.toString() + ", descripcion=" + descripcion + ", resultado=" + resultado + '}';
    }
    
    
}
