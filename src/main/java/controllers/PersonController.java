package controllers;

import models.Person;
import models.dto.PersonDto;
import services.PersonService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/api/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person createPerson(@RequestBody PersonDto createPerson) {
        Person person = new Person();
        BeanUtils.copyProperties(createPerson, person);
        return service.create(person);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll(){
        return service.findAll();
    }
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findPersonById(@PathVariable(value = "id") Long id) {
        return service.findById(id);
    }
    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person updatePerson(@PathVariable(value = "id") Long id, @RequestBody PersonDto updatePerson) {
        Person person = new Person();
        BeanUtils.copyProperties(updatePerson, person);
        return service.update(person, id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id){
        service.delete(id);

    }
}
