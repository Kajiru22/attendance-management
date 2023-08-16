package attendance.management.tracker.presistance.repository;

import attendance.management.tracker.presistance.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findOneByUsername(String username);
    List<Person> findAllByAuthorities(String authorities);
    boolean existsByUsername(String username);
}
