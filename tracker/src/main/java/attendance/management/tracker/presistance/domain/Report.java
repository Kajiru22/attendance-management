package attendance.management.tracker.presistance.domain;

import java.util.List;
import java.util.Objects;

public class Report {

    private String firstname;

    private String lastname;

    private int svnr;

    private List<Attendance> attendances;

    public Report(String firstname, String lastname, int svnr, List<Attendance> attendances) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.svnr = svnr;
        this.attendances = attendances;
    }

    public Report() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getSvnr() {
        return svnr;
    }

    public void setSvnr(int svnr) {
        this.svnr = svnr;
    }

    public List<Attendance> getAttendances() {
        return attendances;
    }

    public void setAttendances(List<Attendance> attendances) {
        this.attendances = attendances;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Report report = (Report) o;
        return Objects.equals(firstname, report.firstname) && Objects.equals(lastname, report.lastname) && Objects.equals(svnr, report.svnr) && Objects.equals(attendances, report.attendances);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, svnr, attendances);
    }

    @Override
    public String toString() {
        return "Report{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", svnr='" + svnr + '\'' +
                ", attendances=" + attendances +
                '}';
    }
}
