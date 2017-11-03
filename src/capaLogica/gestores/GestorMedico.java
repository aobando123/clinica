/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaLogica.gestores;

import capaLogica.clases.Medico;
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
public class GestorMedico implements IGestor {

    static Medico bu;

    ArrayList<Medico> listaMedicos = new ArrayList<>();

    public void agregarMedico(String nombreCompleto, String email, String especialidad, int telefono, int cedula) throws IOException {
        getJsonObject();
        Medico nuevoMedico = new Medico(listaMedicos.size() + 1, nombreCompleto, email, especialidad, telefono, cedula);
        if(listaMedicos==null){
        listaMedicos = new ArrayList<>();
        }
        listaMedicos.add(nuevoMedico);
        setJsonObject();

    }

    public String[] mostrarMedicos() throws IOException {
        getJsonObject();
        String[] arrMedicos = new String[listaMedicos.size()];
        int i = 0;
        for (Medico med : listaMedicos) {
            arrMedicos[i++] = med.toString();
        }
        return arrMedicos;

    }

    public String buscarMedico(int cedula) {
        String datosMedico;
        getJsonObject();
        for (Medico medicoBuscado
                : listaMedicos) {
            if (medicoBuscado.getCedula() == cedula) {
                datosMedico = medicoBuscado.toString();
                return datosMedico;
            }
        }
        return null;

    }

    public Medico busMedico(int cedula) {
        getJsonObject();
        for (Medico medicoBuscado
                : listaMedicos) {
            if (medicoBuscado.getCedula() == cedula) {
                return medicoBuscado;
            }
        }
        return null;
    }

    public boolean isMedicoExist(int cedula) {
        if (buscarMedico(cedula) == null) {
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
            Type listType = new TypeToken<ArrayList<Medico>>() {
            }.getType();
            listaMedicos = new Gson().fromJson(reader, listType);

        } catch (FileNotFoundException e) {

            System.out.println("error");
        }
    }

    @Override
    public void setJsonObject() {
        File jsonFile = getFile();
        try (Writer writer = new FileWriter(jsonFile)) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(listaMedicos, writer);
        } catch (IOException e) {
        }
    }

    private File getFile() {
        File jsonFile = new File("src/resources/files/medicos.json");
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
