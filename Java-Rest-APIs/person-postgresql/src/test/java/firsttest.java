import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import entity.Person;
import io.quarkus.logging.Log;
import io.quarkus.test.junit.QuarkusTest;
import repo.repository;
import rest.rest;

@QuarkusTest
public class firsttest {

    @Inject
    repository repo;

    @Inject 
    rest rest;

    @Test
    public void test(){
        Person person= new Person();

        person.setName("karan");
        person.setBirth(LocalDate.now());
        rest.create(person);
        Log.info("---"+rest.list());
        List<Person> list = new ArrayList<>();
        list.add(person);
        //assertEquals("[Person [name=karan, birth=2023-12-05, status=null]]",rest.list());
        assertEquals(list.get(0).getName(),rest.list().get(0).getName());
    }
}
