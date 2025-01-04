package com.karan.prctice.Service;

import java.util.List;

import com.karan.prctice.Objects.Person;

public interface PersonService {

    public List<Person> addPerson(Person person);
    public List<Person> addPersons(List<Person> persons);
    public List<Person> removePerson(int id);
    public List<Person> getAllPersons();
    public Person getPersonById(int id);
    public Person updatePerson(int id, Person person);
    public Person getPersonByName(Person person);
    public Person updatePerson(Person person);
    public List<Person> updatePersons(List<Person> persons);
    public List<Person> removePersons(List<Person> persons);
}
