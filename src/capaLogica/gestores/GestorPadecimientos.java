/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaLogica.gestores;

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
import java.util.ArrayList;

/**
 *
 * @author mean
 */
public class GestorPadecimientos implements IGestor{
    
    ArrayList<Padecimiento> listaPadecimientos = new ArrayList<>();
    
    public void agregarPadecimiento(String nombre, String descripcion){
        getJsonObject();
        Padecimiento nuevoPad = new Padecimiento(listaPadecimientos.size()+1,nombre,descripcion);
        if(listaPadecimientos == null){
            listaPadecimientos = new ArrayList<>();
        }
        listaPadecimientos.add(nuevoPad);
        setJsonObject();
    }
    
    public String[] mostrarPadecimientos() throws IOException {
        getJsonObject();
        String[] arrPads = new String[listaPadecimientos.size()];
        int i = 0;
        for (Padecimiento pad : listaPadecimientos) {
            arrPads[i++] = pad.toString();
        }
        return arrPads;

    }
     public Padecimiento buscarPadecimiento(int id) {
        
        getJsonObject();
        for (Padecimiento pBuscado
                : listaPadecimientos) {
            if (pBuscado.getIdPadecimiento()== id) {
                return pBuscado;
            }
        }
        return null;

    }


    
    
    @Override
    public void getJsonObject() {

        File jsFile = getFile();
        try {

            JsonReader reader = new JsonReader(new FileReader(jsFile));
            Type listType = new TypeToken<ArrayList<Medico>>() {
            }.getType();
            listaPadecimientos = new Gson().fromJson(reader, listType);

        } catch (FileNotFoundException e) {

            System.out.println("error");
        }
    }

    @Override
    public void setJsonObject() {
        File jsonFile = getFile();
        try (Writer writer = new FileWriter(jsonFile)) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(listaPadecimientos, writer);
        } catch (IOException e) {
        }
    }

    private File getFile() {
        File jsonFile = new File("src/resources/files/padecimientos.json");
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
