package com.aman.service;

import com.aman.model.Person;
import com.aman.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person create(final Person user){
        log.info("saving person for name : {}", user.getName());
        return personRepository.save(user);
    }

    public Person fetch(final Integer id){
        log.info("Fetching person for id : {}", id);
        return personRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public Person delete(final Integer id){
        log.info("deleting person for id : {}", id);
        Person user = fetch(id);
        personRepository.delete(user);
        return user;
    }
}
