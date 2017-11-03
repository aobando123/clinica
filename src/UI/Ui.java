/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import capaLogica.clases.Clinica;
import capaLogica.gestores.GestorMedico;
import capaLogica.gestores.GestorPacientes;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 *
 * @author mean
 */
public class Ui {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
   
    static GestorMedico gMedic = new GestorMedico();
    static GestorPacientes gPaci = new GestorPacientes();

    /**
     *
     * @param args
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws java.io.IOException {
        menuPrincipal();

    }

    /**
     * imprime el menu principal
     *
     * @throws java.io.IOException
     */
    public static void menuPrincipal() throws java.io.IOException {
        int opcion;
        do {
            out.println("*****************************************************");
            out.println("*                      MENU                         *");
            out.println("*****************************************************");
            out.println("Que desea ir?");
            out.println("1. listar Medicos");
            out.println("2. Registrar Medico");
            out.println("3. Listar Paciente");
            out.println("4. Registrar Paciente");
            out.println("5. Ingresar al sistema");
            out.println("6. Salir");
            opcion = Integer.parseInt(in.readLine());
            realizarAccion(opcion);
        } while (opcion != 6);

    }

    /**
     *
     * @param pOpcion
     * @throws java.io.IOException
     */
    public static void realizarAccion(int pOpcion) throws java.io.IOException {
        switch (pOpcion) {
            case 1:
                listarMedicos();
                break;
            case 2:
                registrarMedicos();
                break;
            case 3:
                listarPacientes();
                break;
            case 4:
                registrarPaciente();
                break;
            case 5:
                out.println("Adios");
                break;
            case 6:
                break;

        }

    }

    /**
     * Lista los medicos en el sistema
     *
     * @throws java.io.IOException
     */
    public static void listarMedicos() throws java.io.IOException {

        String[] lim = gMedic.mostrarMedicos();
        for (String string : lim) {
            out.println(string);
        }

    }

    /**
     * solicita la informacion del medico al usuario
     *
     * @throws java.io.IOException
     */
    public static void registrarMedicos() throws java.io.IOException {
        String nombreCompleto, email, especialidad, resultado;
        int telefono, cedula;
        out.println("Digite la cedula del paciente sin guiones");
        cedula = Integer.parseInt(in.readLine());
        out.println("Digite el nombre completo del medico");
        nombreCompleto = in.readLine();
        out.println("Digite el email del medico");
        email = in.readLine();
        out.println("Digite la especialidad del medico");
        especialidad = in.readLine();
        out.println("Digite el telefono del medico sin guiones");
        telefono = Integer.parseInt(in.readLine());
        gMedic.agregarMedico(nombreCompleto, email, especialidad, telefono, cedula);
        String[] lim = gMedic.mostrarMedicos();
        for (String string : lim) {
            out.println(string);
        }

    }

    /**
     * Lista los paciente en el sistema
     *
     * @throws java.io.IOException
     */
    public static void listarPacientes() throws java.io.IOException {
        String[] lip = gPaci.listarPacient();
        for (String string : lip) {
            out.println(string);
        }
    }

    /**
     * solicita la informacion del paciente al usuario
     *
     * @throws java.io.IOException
     */
    public static void registrarPaciente() throws java.io.IOException {
        String nombreCompleto, direccion, email, resultado;
        int cedula, telefono;
        boolean pacienteExist;
        do {
            out.println("Digite la cedula del paciente sin guiones");
            cedula = Integer.parseInt(in.readLine());
            pacienteExist = gPaci.isPacientExist(cedula);
            if (pacienteExist) {
                out.println("Ya existe el medico");
            }
        } while (pacienteExist);
        out.println("Digite el nombre completo del paciente");
        nombreCompleto = in.readLine();
        out.println("Digite el email del paciente");
        email = in.readLine();
        out.println("Digite la direccion del paciente");
        direccion = in.readLine();
        out.println("Digite el telefono del paciente sin guiones");
        telefono = Integer.parseInt(in.readLine());

        gPaci.agregarPaciente(nombreCompleto, email, direccion, telefono, cedula);
        

    }
}
