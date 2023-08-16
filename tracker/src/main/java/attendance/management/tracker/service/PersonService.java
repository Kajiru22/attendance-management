package attendance.management.tracker.service;

import attendance.management.tracker.presistance.domain.Person;
import attendance.management.tracker.presistance.repository.PersonRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    private final PasswordEncoder passwordEncoder;

    public PersonService(PersonRepository personRepository, PasswordEncoder passwordEncoder) {
        this.personRepository = personRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Person addEmployee(Person person) {
        if(personRepository.existsByUsername(person.getUsername())) {
            System.out.println("Username is all ready in use");
            return person;
        }
        else {
            person.setAuthorities(Set.of("ROLE_EMPLOYEE"));
            person.setPassword(passwordEncoder.encode(person.getPassword()));
            return personRepository.save(person);
        }
    }

    public Person addStudent(Person person) {
        if(personRepository.existsByUsername(person.getUsername())) {
            System.out.println("Username is all ready in use");
            return person;
        }
        else {
            person.setAuthorities(Set.of("ROLE_STUDENT"));
            person.setPassword(passwordEncoder.encode(person.getPassword()));
            return personRepository.save(person);
        }
    }

    public void deletePerson(String username) {
        if(personRepository.existsByUsername(username)) {
            var person = personRepository.findOneByUsername(username);
            personRepository.delete(person.get());
        }
        else {
            System.out.println("There is no such username");
        }
    }

    public List<Person> getAllStudents() {
        return personRepository.findAllByAuthorities("ROLE_STUDENT");
    }

    public List<Person> getAllEmployees() {
        return personRepository.findAllByAuthorities("ROLE_EMPLOYEE");
    }

}
