package attendance.management.tracker.endpoint;

import attendance.management.tracker.presistance.domain.StudentSheet;
import attendance.management.tracker.service.StudentSheetService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/studentSheet")
public class StudentSheetEndpoint {

    private final StudentSheetService studentSheetService;

    public StudentSheetEndpoint(StudentSheetService studentSheetService) {
        this.studentSheetService = studentSheetService;
    }
    @PostMapping
    @Secured({"ROLE_EMPLOYEE", "ROLE_ADMIN"})
    public StudentSheet addStudent(@RequestBody StudentSheet studentSheet) {
        return studentSheetService.createStudentSheet(studentSheet);
    }

    @DeleteMapping
    @Secured({"ROLE_EMPLOYEE", "ROLE_ADMIN"})
    public void deleteStudentSheet(@RequestBody String username) {
        studentSheetService.deleteStudentSheet(username);
    }

    @GetMapping
    @Secured({"ROLE_EMPLOYEE", "ROLE_ADMIN"})
    public Optional<StudentSheet> findStudent(@RequestBody String firstName, @RequestBody String lastName) {
        return studentSheetService.findStudentSheet(firstName, lastName);
    }
}
