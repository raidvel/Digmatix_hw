package models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "person")
public class Person implements Serializable {
    /*
        TODO:
         Should LocalDate and name be nullable?
         Should add annotations for validations to check later with tests?
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private LocalDate dateOfBirth;

    @Column
    private String name;

    public Person() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "model.Person: [id = " + id + ", Name = " + name + ", Date of birth = " + dateOfBirth + "]";
    }
}
