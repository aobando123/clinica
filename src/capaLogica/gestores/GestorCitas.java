/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaLogica.gestores;

import capaLogica.clases.Cita;
import capaLogica.clases.Medico;
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
import java.text.DateFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author mean
 */
public class GestorCitas implements IGestor {

    ArrayList<Cita> listaCitas = new ArrayList<>();
    GestorMedico gm = new GestorMedico();
    GestorPacientes gp = new GestorPacientes();
    

    public void agregarCita(int idMedico, int idPaciente, String fecha, String descripcion, String resultado) throws ParseException {
        getJsonObject();
        Medico md = gm.busMedico(idMedico);
        Paciente pc = gp.busPaciente(idPaciente);
        LocalDate fcita = LocalDate.parse(fecha);

        Cita nuevaCita = new Cita(listaCitas.size(), fcita, md, pc, descripcion, resultado);
        listaCitas.add(nuevaCita);
        setJsonObject();
    }

    public String[] mostrarCitas() {

        getJsonObject();
        String[] arrCits = new String[listaCitas.size()];
        int i = 0;
        for (Cita cit : listaCitas) {
            arrCits[i++] = cit.toString();
        }
        return arrCits;

    }
    
    public ArrayList<Cita> citasPaciente(int cedulaPaciente){
        getJsonObject();
       ArrayList<Cita> citasPaciente = new ArrayList<>();
        for (Cita listaCita : listaCitas) {
            if(listaCita.getCitaPac().getCedula()==cedulaPaciente){
            citasPaciente= listaCitas;
            }
        }
        return citasPaciente;
       
    }
    public ArrayList<String> citasMedico(int medico){
       getJsonObject();
       ArrayList<String> citaMedic = new ArrayList<>();
        for (Cita medCita : listaCitas) {
           LocalDate now = LocalDate.now();
            if(medCita.getCitaMed().getCedula()==medico && medCita.getFechaCita().isAfter(LocalDate.now())){
                citaMedic.add(medCita.toString());
            }
        }
        return citaMedic;
    }

    @Override
    public void getJsonObject() {

        File jsFile = getFile();
        try {

            JsonReader reader = new JsonReader(new FileReader(jsFile));
            Type listType = new TypeToken<ArrayList<Medico>>() {
            }.getType();
            listaCitas = new Gson().fromJson(reader, listType);

        } catch (FileNotFoundException e) {

            System.out.println("error");
        }
    }

    @Override
    public void setJsonObject() {
        File jsonFile = getFile();
        try (Writer writer = new FileWriter(jsonFile)) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(listaCitas, writer);
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
