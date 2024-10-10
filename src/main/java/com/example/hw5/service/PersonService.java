package com.example.hw5.service;

import com.example.hw5.model.Person;
import com.example.hw5.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    public Optional<Person> getPersonById(Long id) {
        return personRepository.findById(id);
    }

    @Transactional
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    @Transactional
    public Person updatePerson(Long id, Person personDetails) {
        Person person = personRepository.findById(id).orElseThrow();
        person.setLogin(personDetails.getLogin());
        person.setPassword(personDetails.getPassword());
        return personRepository.save(person);
    }

    @Transactional
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
}
