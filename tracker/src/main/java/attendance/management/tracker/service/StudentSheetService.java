package attendance.management.tracker.service;

import attendance.management.tracker.presistance.domain.StudentSheet;
import attendance.management.tracker.presistance.repository.StudentSheetRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class StudentSheetService {

    private final StudentSheetRepository studentSheetRepository;

    public StudentSheetService(StudentSheetRepository studentSheetRepository) {
        this.studentSheetRepository = studentSheetRepository;
    }

    public StudentSheet createStudentSheet(StudentSheet studentSheet) {
        if(studentSheetRepository.existsByUsername(studentSheet.getUsername())) {
            System.out.println("Student sheet all ready exists!");
        }
        return studentSheetRepository.save(studentSheet);
    }

    public void deleteStudentSheet(String name) {
        if (studentSheetRepository.existsByUsername(name)) {
            var studentSheet = studentSheetRepository.findOneByUsername(name);
            studentSheetRepository.delete(studentSheet.get());
        }
        else {
            System.out.println("Student sheet not found");
        }
    }

    public Optional<StudentSheet> findStudentSheet(String firstName, String lastName) {
        return studentSheetRepository.findByFirstnameAndLastname(firstName, lastName);
    }
}