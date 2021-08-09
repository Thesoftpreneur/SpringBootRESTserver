package com.example.springbootdemo.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPeople() {
        return personRepository.findAll();
//        return List.of(
//                new Student(
//                        1L,
//                        "Mariam",
//                        "mariam.jamal@gmail.com",
//                        LocalDate.of(2000, Month.JANUARY, 5),
//                        21
//                )
//        );
    }

    public void addNewPerson(Person person) {
        Optional<Person> personOptional = personRepository.findPersonByEmail(person.getEmail());
        if (personOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        System.out.println(person);
        personRepository.save(person);
    }

    public void deletePerson(Long personId) {
        boolean exists = personRepository.existsById(personId);
        if (!exists) {
            throw new IllegalStateException("student with id " + personId + "does not exists");
        }
        personRepository.deleteById(personId);
    }

    @Transactional
    public void updatePerson(Long personId, String name, String email) {
        Person person = personRepository.findById(personId)
                .orElseThrow(()->new IllegalStateException(
                        "student with id " + personId + " does not exist"
                ));
        if (name != null && name.length() > 0 && !Objects.equals(person.getName(), name)) {
            person.setName(name);
        }
        if (email != null && email.length() > 0 && !Objects.equals(person.getName(), email)) {
            Optional<Person> personOptional = personRepository.findPersonByEmail(email);
            if (personOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            person.setEmail(email);

        }
    }


}
