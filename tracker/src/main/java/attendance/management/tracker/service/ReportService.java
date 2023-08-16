package attendance.management.tracker.service;

import attendance.management.tracker.presistance.domain.Attendance;
import attendance.management.tracker.presistance.domain.Report;
import attendance.management.tracker.presistance.repository.StudentSheetRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class ReportService {

    private final StudentSheetRepository studentSheetRepository;

    public ReportService(StudentSheetRepository studentSheetRepository) {
        this.studentSheetRepository = studentSheetRepository;
    }

    public Report createReport(String firstname, String lastname) {
        Report report = new Report();
        var studentSheet = studentSheetRepository.findByFirstnameAndLastname(firstname, lastname);
        report.setFirstname(studentSheet.get().getFirstname());
        report.setLastname(studentSheet.get().getLastname());
        report.setSvnr(studentSheet.get().getSvnr());
        report.setAttendances(filterAttendancesByDate(studentSheet.get().getAttendances()));
        return report;
    }

    private List<Attendance> filterAttendancesByDate(List<Attendance> attendances) {
        return attendances.stream()
                .filter(attendance -> isDateInRange(attendance.getDate(), LocalDate.now().minusDays(4),
                        LocalDate.now()))
                .collect(Collectors.toList());
    }

    private boolean isDateInRange(LocalDate date, LocalDate startDate, LocalDate endDate) {
        return !date.isBefore(startDate) && !date.isAfter(endDate);
    }
}
