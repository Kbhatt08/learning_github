package com.karan.prctice.DataRepository;

import java.util.ArrayList;
import java.util.List;

import com.karan.prctice.Objects.Person;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class PersonRepository {
    private List<Person> persons;

    public PersonRepository() {
        persons= new ArrayList<>();
        persons.add(new Person(1,"Karan", 24, "Pune", 1, 1, 1, 1, 1, "9876543210"));
        persons.add(new Person(2,"John", 25, "Mumbai", 2, 2, 2, 2, 2, "9876543211"));
    }

    public Person getPersonById(int id){
        return persons.get(persons.indexOf(persons.stream().filter(person -> person.getId() == id).findFirst().get()));
    }

    public List<Person> addPerson(Person person) {
        persons.add(person);
        return persons;
    }

    public List<Person> addPersons(List<Person> persons) {
        persons.addAll(persons);
        return persons;
    }

    public List<Person> removePerson(int id) {
        persons.removeIf(person -> person.getId() == id);
        return persons;
    }
    
}
