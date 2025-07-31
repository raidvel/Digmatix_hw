package services;

import models.Person;
import repositories.PersonRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Objects;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Transactional
    public Person create(Person person){
        return personRepository.save(person);
    }

    public Person findById(Long id){
        return personRepository.findById(id).orElse(new Person());
    }

    public List<Person> findAll(){
        return personRepository.findAll();
    }
    @Transactional
    public Person update(Person person, Long id){
        var personExists = findById(id);
        if(!Objects.equals(personExists.getId(),id)){
            return personExists;
        }
        BeanUtils.copyProperties(person,personExists, "id");
        return personRepository.save(personExists);
    }

    @Transactional
    public void delete(Long id){
        personRepository.deleteById(id);
    }

}
