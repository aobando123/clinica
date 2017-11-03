package capaLogica.clases;

import java.util.ArrayList;

public class Clinica {
    private String nombre;
    private int cedulaJuridica;
    private String direccion;
    private int telefono;
    private int codigoMedico=0;
    private ArrayList<Paciente> listaPacientes;
    private ArrayList<Medico> listaMedicos;

    public  Clinica(){

    }
    public Clinica(String nombre, int cedulaJuridica, String direccion, int telefono, int codigoMedico) {
        this.nombre = nombre;
        this.cedulaJuridica = cedulaJuridica;
        this.direccion = direccion;
        this.telefono = telefono;
        this.codigoMedico = codigoMedico;
        this.listaMedicos = new ArrayList<Medico>();
        this.listaPacientes = new ArrayList<Paciente>();
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCedulaJuridica() {
        return cedulaJuridica;
    }

    public void setCedulaJuridica(int cedulaJuridica) {
        this.cedulaJuridica = cedulaJuridica;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }




}
