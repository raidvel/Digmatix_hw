package controller;

import model.Person;
import org.springframework.stereotype.Repository;
import repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/")
public class PersonController {


    private PersonRepository personRepository;

    public PersonRepository getRepository(){
        return personRepository;
    }

    public void setRepository(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @GetMapping("/persons")
    public String getAllPersons() {
        String message = "Welcome to Hell!";
        System.out.println(personRepository.findAll());
        return message + personRepository.findAll();
    }

    @PostMapping("/persons")
    Person createPerson(@RequestBody Person person){
        System.out.println(person.toString());
        return personRepository.save(person);
    }

    @GetMapping("/persons/{id}")
    Person getEmployee(@PathVariable Long id){
        System.out.println(personRepository.findById(id).get());
        return personRepository.findById(id).get();
    }
    @DeleteMapping("/persons/{id}")
    void deletePerson(@PathVariable Long id){
        System.out.println("Before: " + personRepository.findById(id).get());
        personRepository.deleteById(id);
        System.out.println("After: " + personRepository.findById(id).get());
    }

}
