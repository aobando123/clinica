/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaLogica.gestores;

import capaLogica.clases.Expediente;
import capaLogica.clases.Medico;
import capaLogica.clases.Padecimiento;
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
public class GestorExpediente implements IGestor {

    ArrayList<Expediente> listaExpediente = new ArrayList<Expediente>();
    static DateFormat df;
    
    public void agregarExpediente(int cedulaPaci, String fecha,String tipoSangre, ArrayList<Integer> idPads) throws ParseException{
     getJsonObject();
     LocalDate fNaci = LocalDate.parse(fecha);
     Expediente nuevoExpe = new Expediente(cedulaPaci, fNaci, tipoSangre);
     nuevoExpe.setListaPadecimientos(agregarPadecimientos(idPads));
     if(listaExpediente==null){
         listaExpediente = new ArrayList<>();
     }
     listaExpediente.add(nuevoExpe);
     
    }
    public ArrayList<Padecimiento>  agregarPadecimientos(ArrayList<Integer> idPads){
        ArrayList<Padecimiento> pads = new ArrayList<>();
        
        GestorPadecimientos gp = new GestorPadecimientos();
        for (Integer idPad : idPads) {
          
            pads.add(gp.buscarPadecimiento(idPad));
        }
        return pads;
    }
    
    public void agregarCita(int cedulaPaci){
    getJsonObject();
    GestorCitas gc = new GestorCitas();
    
        for (Expediente expediente : listaExpediente) {
            if(expediente.getCedulaPaciente() == cedulaPaci){
                expediente.setListaCitas(gc.citasPaciente(cedulaPaci));
            }
        }
    }
    

    @Override
    public void getJsonObject() {

        File jsFile = getFile();
        try {

            JsonReader reader = new JsonReader(new FileReader(jsFile));
            Type listType = new TypeToken<ArrayList<Medico>>() {
            }.getType();
            listaExpediente = new Gson().fromJson(reader, listType);

        } catch (FileNotFoundException e) {

            System.out.println("error");
        }
    }

    @Override
    public void setJsonObject() {
        File jsonFile = getFile();
        try (Writer writer = new FileWriter(jsonFile)) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(listaExpediente, writer);
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
