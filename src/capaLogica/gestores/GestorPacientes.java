/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaLogica.gestores;

import capaLogica.clases.Paciente;
import capaLogica.estructuras.IGestor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 *
 * @author mean
 */
public class GestorPacientes implements IGestor {

    ArrayList<Paciente> listaPacientes = new ArrayList<>();

    public void agregarPaciente(String pNombre, String pEmail, String pDireccion, int pTelefono, int pCedula) {

        Paciente regPaciente = new Paciente(pCedula, pNombre, pDireccion, pEmail, pTelefono);
        getJsonObject();
        if(listaPacientes==null){
        listaPacientes = new ArrayList<>();
        }
        listaPacientes.add(regPaciente);
        setJsonObject();

    }

    public String[] listarPacient() {
        getJsonObject();
        int size = listaPacientes.size();
        int index = 0;
        String[] pacientes = new String[size];
        for (Paciente pacient
                : listaPacientes) {
            pacientes[index++] = pacient.toString();
        }
        return pacientes;

    }

    public String[] buscarPaciente(int cedula) {
        getJsonObject();
        String[] datosPaciente = new String[1];
        if(listaPacientes!=null){
        for (Paciente pacienteBuscado
                : listaPacientes) {
            if (pacienteBuscado.getCedula() == cedula) {
                datosPaciente[0] = pacienteBuscado.toString();
                return datosPaciente;
            }
        }
        }
        
        return null;

    }

    public Paciente busPaciente(int cedula) {
        getJsonObject();
        
        for (Paciente pacienteBuscado
                : listaPacientes) {
            if (pacienteBuscado.getCedula() == cedula) {
                return pacienteBuscado;
            }
        }
        return null;

    }

    /**
     * Si el paciente existe
     *
     * @param cedula
     * @return devuelve un booleano si el paciente existe o no
     */
    public boolean isPacientExist(int cedula) {
        getJsonObject();
        if (buscarPaciente(cedula) == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void getJsonObject() {

        File jsFile = getFile();
        try {

            JsonReader reader = new JsonReader(new FileReader(jsFile));
            Type listType = new TypeToken<ArrayList<Paciente>>() {
            }.getType();
            listaPacientes = new Gson().fromJson(reader, listType);

        } catch (FileNotFoundException e) {

            System.out.println("error");
        }
    }

    @Override
    public void setJsonObject() {
        File jsonFile = getFile();
        try (Writer writer = new FileWriter(jsonFile)) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(listaPacientes, writer);
        } catch (IOException e) {
        }
    }

    private File getFile() {
        File jsonFile = new File("src/resources/files/pacientes.json");
        if (!jsonFile.exists()) {
            try {
                jsonFile.createNewFile();
            } catch (IOException ex) {
                System.out.println("no se pudo crear el archivo");
            }
        }
        return jsonFile;
    }
}
