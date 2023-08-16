package attendance.management.tracker.service;

import attendance.management.tracker.presistance.domain.Attendance;
import attendance.management.tracker.presistance.repository.AttendanceRepository;
import attendance.management.tracker.presistance.repository.StudentSheetRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipal;
import java.sql.Blob;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final StudentSheetRepository studentSheetRepository;

    public AttendanceService(AttendanceRepository attendanceRepository, StudentSheetRepository studentSheetRepository) {
        this.attendanceRepository = attendanceRepository;
        this.studentSheetRepository = studentSheetRepository;
    }

    public Attendance createAttendance(LocalTime endTime) {
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        var studentSheet = studentSheetRepository.findOneByUsername(username);
        var attendance = new Attendance();
        attendance.setDate(LocalDate.now());
        attendance.setStartTime(LocalTime.now());
        attendance.setEndTime(endTime);
        attendance.setConfirmed(false);
        studentSheet.get().getAttendances().add(attendance);
        return attendance;
    }

    public Attendance confirmAttendance(String id) {
        var attendance = attendanceRepository.findById(id).get();
        attendance.setConfirmed(true);
        return attendance;
    }

    public List<Attendance> findUnconfirmed() {
        return attendanceRepository.findByConfirmed(false);
    }

    public List<Attendance> uploadAbsenceConfirmation(Blob absenceConfirmation, LocalDate date) {
        var username = UserPrincipal.class.getName();
        var student = studentSheetRepository.findOneByUsername(username);
        var attendanceByDate =  student.get().getAttendances().stream()
                .filter(a -> a.getDate().equals(date)).collect(Collectors.toList());
        attendanceByDate.forEach(e -> e.setAbsenceConfirmation(absenceConfirmation));
        return attendanceByDate;
    }

}
