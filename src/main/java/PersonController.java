import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/management", produces = {MediaType.APPLICATION_JSON_VALUE})
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    public PersonRepository getRepository(){
        return personRepository;
    }

    public void setRepository(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @GetMapping("/persons")
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @PostMapping
    Person createPerson(@RequestBody Person person){
        return personRepository.save(person);
    }

    @GetMapping("/persons/{id}")
   Person getEmployee(@PathVariable Long id){
        return personRepository.findById(id).get();
    }
    @DeleteMapping("/persons/{id}")
    void deletePerson(@PathVariable Long id){
        personRepository.deleteById(id);
    }

}
