package attendance.management.tracker.presistance.repository;

import attendance.management.tracker.presistance.domain.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    Optional<Attendance> findById(String id);

    Optional<Attendance> findByDate(LocalDate date);
    List<Attendance> findByConfirmed(boolean bool);
}
