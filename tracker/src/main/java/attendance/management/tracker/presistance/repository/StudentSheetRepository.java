package attendance.management.tracker.presistance.repository;

import attendance.management.tracker.presistance.domain.StudentSheet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentSheetRepository extends JpaRepository<StudentSheet, Long> {

    Optional<StudentSheet> findOneByUsername(String username);

    Optional<StudentSheet> findByFirstnameAndLastname(String firstname, String lastname);

    boolean existsByUsername(String username);
}
