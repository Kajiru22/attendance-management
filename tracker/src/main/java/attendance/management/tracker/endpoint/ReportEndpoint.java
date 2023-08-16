package attendance.management.tracker.endpoint;

import attendance.management.tracker.presistance.domain.Report;
import attendance.management.tracker.service.ReportService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
public class ReportEndpoint {

    private final ReportService reportService;

    public ReportEndpoint(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping
    @Secured("ROLE_EMPLOYEE")
    public Report createReport(@RequestBody String firstName,@RequestBody String lastName) {
        return reportService.createReport(firstName, lastName);
    }
}
