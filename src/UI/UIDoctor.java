/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import capaLogica.gestores.GestorMedico;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 *
 * @author mean
 */
public class UIDoctor {
    private GestorMedico gm = new GestorMedico();
    private int medCedula;
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    public void ingresoUiProfesor(int cedula){
        String Medico = gm.buscarMedico(cedula);
        if(Medico != null){
            menuDoctor();
            medCedula = cedula;
        }else{
            out.println("");
        }
    }
    
    public void menuDoctor(){
         out.println("*****************************************************");
         out.println("*                  Estas son sus citas              *");
         out.println("*****************************************************");
         out.println("Que desea ir?");
         out.println("1. listar Medicos");
         out.println("2. Registrar Medico");
         out.println("3. Listar Paciente");
         out.println("4. Registrar Paciente");
         out.println("5. Ingresar al sistema");
    }
}
