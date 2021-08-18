package test2.service;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import test2.data.Person;
import test2.data.Persons;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DataService {

    private ObjectMapper mapper;
    private File file;

    public DataService() {
        this.mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        this.file = new File("Persons.json");
    }

    public void writePersonsToFile(Persons persons){
        if (!this.file.exists()){
            try {
                this.file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            System.out.println("Write Persons to file");
            mapper.writeValue(file, persons);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Persons readPersonsFromFile() {

        Persons persons = new Persons();

        if (!this.file.exists()){
            System.out.println("Nepavyko nuskaityto failo");
            return null;
        }

        try {
            System.out.println("Read Persons from file");
            persons = mapper.readValue(file, Persons.class);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return persons;
    }

}
