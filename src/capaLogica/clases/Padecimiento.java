/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaLogica.clases;

/**
 *
 * @author mean
 */
public class Padecimiento {
    private int idPadecimiento;
    private String nombre;
    private String descripcion;

    public Padecimiento() {
    }

    public Padecimiento(int idPadecimiento, String nombre, String descripcion) {
        this.idPadecimiento = idPadecimiento;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    

    public int getIdPadecimiento() {
        return idPadecimiento;
    }

    public void setIdPadecimiento(int idPadecimiento) {
        this.idPadecimiento = idPadecimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Padecimiento:" + "idPadecimiento=" + idPadecimiento + ", nombre=" + nombre + ", descripcion=" + descripcion + ' ';
    }
    
    
}
