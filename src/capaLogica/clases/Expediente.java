/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaLogica.clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author mean
 */
public class Expediente {
    private int cedulaPaciente;
    private LocalDate fechaNaciemiento;
    private String tipoSangre;
    private ArrayList<Padecimiento> listaPadecimientos;
    private ArrayList<Cita> listaCitas;

    public Expediente(int cedulaPaciente, LocalDate fechaNaciemiento, String tipoSangre) {
        this.cedulaPaciente = cedulaPaciente;
        this.fechaNaciemiento = fechaNaciemiento;
        this.tipoSangre = tipoSangre;
    }

    public int getCedulaPaciente() {
        return cedulaPaciente;
    }

    public void setCedulaPaciente(int cedulaPaciente) {
        this.cedulaPaciente = cedulaPaciente;
    }

    public LocalDate getFechaNaciemiento() {
        return fechaNaciemiento;
    }

    public void setFechaNaciemiento(LocalDate fechaNaciemiento) {
        this.fechaNaciemiento = fechaNaciemiento;
    }

    public ArrayList<Cita> getListaCitas() {
        return listaCitas;
    }

    public void setListaCitas(ArrayList<Cita> listaCitas) {
        this.listaCitas = listaCitas;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public ArrayList<Padecimiento> getListaPadecimientos() {
        return listaPadecimientos;
    }

    public void setListaPadecimientos(ArrayList<Padecimiento> listaPadecimientos) {
        this.listaPadecimientos = listaPadecimientos;
    }
    
    public void setPadecimiento(Padecimiento nuevoPade){
        listaPadecimientos.add(nuevoPade);
    }
    public void setCita(Cita nuevaCita){
        listaCitas.add(nuevaCita);
    }
    public String getCitas(){
        String sCita="";
        for (Cita cit : listaCitas) {
            sCita = "    * "+cit.toString()+"\n";
        }
        return sCita;
    }
        public String getPadecimientos(){
        String sPadecimientos="";
        for (Padecimiento pade : listaPadecimientos) {
            sPadecimientos = "    * "+pade.toString()+"\n";
        }
        return sPadecimientos;
    }
    @Override
    public String toString() {
        return "Expediente=" + "cedulaPaciente=" + cedulaPaciente + ", fechaNaciemiento=" + fechaNaciemiento + ", tipoSangre=" + tipoSangre + ", listaPadecimientos=" + getPadecimientos() + ", listaCitas=" + getCitas() + '}';
    }
    
    
    
}
