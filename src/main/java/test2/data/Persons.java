package test2.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Persons implements Serializable {

    private List<Person> persons = new ArrayList<>();

    public Persons(){}

    public Persons(List<Person> persons) {
        this.persons = persons;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public void addPersonToPersons(Person person){
        int id = person.getId();
        for(Person p : this.persons){
            if(p.getId() == id){
                System.out.println("Toks vartotojas jau egzistuoja");
                return;
            }
        }
        this.persons.add(person);
    }

    @Override
    public String toString() {
        return "Persons{" +
                "persons=" + persons +
                '}';
    }
}
