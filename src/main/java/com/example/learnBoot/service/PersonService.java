package com.example.learnBoot.service;

import com.example.learnBoot.dao.PersonDao;
import com.example.learnBoot.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonDao personDao;

    //We are autowiring into this interface
    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = personDao;
    }


    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPeople() {
        return personDao.selectAllPeople();
    }


    public Optional<Person> getPersonById(UUID id) {
        return personDao.selectPersonById(id);
    }


    public int deletePerson(UUID id) {
        return personDao.deletePersonById(id);
    }


    public int updatePerson(UUID id, Person updatedPerson) {
        return personDao.updatePersonById(id, updatedPerson);


    }
}