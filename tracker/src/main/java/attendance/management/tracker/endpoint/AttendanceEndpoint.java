package attendance.management.tracker.endpoint;

import attendance.management.tracker.presistance.domain.Attendance;
import attendance.management.tracker.service.AttendanceService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.sql.Blob;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/attendance")
public class AttendanceEndpoint {

    private final AttendanceService attendanceService;

    public AttendanceEndpoint(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @PostMapping
    @Secured("ROLE_STUDENT")
    public Attendance createAttendance(@RequestBody LocalTime endTime) {
        return attendanceService.createAttendance(endTime);
    }

    @PutMapping
    @Secured("ROLE_EMPLOYEE")
    public Attendance confirmAttendance(@RequestBody String id) {
        return attendanceService.confirmAttendance(id);
    }

    @GetMapping
    @Secured("ROLE_EMPLOYEE")
    public List<Attendance> getUnconfirmed() {
        return attendanceService.findUnconfirmed();
    }

    @PutMapping("/absence")
    @Secured("ROLE_STUDENT")
    public List<Attendance> addAbsenceConfirmation(@RequestBody Blob absenceConfirmation, @RequestBody LocalDate date) {
        return attendanceService.uploadAbsenceConfirmation(absenceConfirmation, date);
    }
}
