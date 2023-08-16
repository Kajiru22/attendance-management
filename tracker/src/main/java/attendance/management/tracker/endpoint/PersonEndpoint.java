package attendance.management.tracker.endpoint;

import attendance.management.tracker.presistance.domain.Person;
import attendance.management.tracker.service.PersonService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonEndpoint {

    private final PersonService personService;

    public PersonEndpoint(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/employees")
    @Secured("ROLE_ADMIN")
    public Person addEmployee(@RequestBody Person person) {
        return personService.addEmployee(person);
    }

    @PostMapping("/students")
    @Secured({"ROLE_EMPLOYEE", "ROLE_EMPLOYEE"})
    public Person addStudent(@RequestBody Person person) {
        return personService.addStudent(person);
    }

    @DeleteMapping("/employees/{userName}")
    @Secured("ROLE_ADMIN")
    public void deleteEmployee(@PathVariable String userName) {
        personService.deletePerson(userName);
    }

    @DeleteMapping("/students/{userName}")
    @Secured({"ROLE_EMPLOYEE", "ROLE_EMPLOYEE"})
    public void deleteStudent(@PathVariable String userName) {
        personService.deletePerson(userName);
    }

    @GetMapping("/employees")
    @Secured("ROLE_ADMIN")
    public List<Person> getAllEmployees() {
        return personService.getAllEmployees();
    }

    @GetMapping("/students")
    @Secured({"ROLE_EMPLOYEE", "ROLE_EMPLOYEE"})
    public List<Person> getAllStudents() {
        return personService.getAllStudents();
    }
}