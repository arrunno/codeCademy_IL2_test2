package test2;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import test2.data.Person;
import test2.data.Persons;
import test2.service.DataService;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Persons persons = new Persons();
//                = new Persons(List.of(new Person(123456, "Jonas", "Jonaitis"),
//                new Person(234556, "Petras", "Petraitis")));

        DataService ds = new DataService();

        persons = ds.readPersonsFromFile();
        System.out.println("Persons from file: " + persons);

        persons.addPersonToPersons(new Person(333456, "Jane", "Jonyte"));

        boolean goOn = true;
        Scanner sc = new Scanner(System.in);

        System.out.println("Pasirinkite");
        System.out.println("1 - rodyti vartotojus");
        System.out.println("2 - ivesti vartotoja");
        System.out.println("0 - iseiti");
        while(goOn) {
            String choice = sc.nextLine();
            switch(choice){
                case "1" -> System.out.println(persons.toString());
                case "2" -> System.out.println("Nespejau, bet pridejimas, tikrinimas ir irasymas veikia");
                default-> { goOn = false; }
            }
        }
        ds.writePersonsToFile(persons);

    }



}
