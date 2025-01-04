package com.karan.prctice.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.karan.prctice.DataRepository.PersonRepository;
import com.karan.prctice.Objects.Person;
import com.karan.prctice.Service.PersonService;

public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonRepository personRepository;

    @Override
    public List<Person> addPerson(Person person) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addPerson'");
    }

    @Override
    public List<Person> addPersons(List<Person> persons) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addPersons'");
    }

    @Override
    public List<Person> removePerson(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removePerson'");
    }

    @Override
    public List<Person> getAllPersons() {
        return personRepository.getPersons();
    }

    @Override
    public Person getPersonById(int id) {
        return personRepository.getPersonById(id); 
    }

    @Override
    public Person updatePerson(int id, Person person) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePerson'");
    }

    @Override
    public Person getPersonByName(Person person) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPersonByName'");
    }

    @Override
    public Person updatePerson(Person person) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePerson'");
    }

    @Override
    public List<Person> updatePersons(List<Person> persons) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePersons'");
    }

    @Override
    public List<Person> removePersons(List<Person> persons) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removePersons'");
    }
    
}
