package attendance.management.tracker.presistance.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class StudentSheet {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String firstname;
    private String lastname;
    private int svnr;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Attendance> attendances;

    public StudentSheet(Long id, String username, String firstname, String lastname, int svnr, List<Attendance> attendances) {
        this.id = id;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.svnr = svnr;
        this.attendances = attendances;
    }

    public StudentSheet() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        StudentSheet that = (StudentSheet) o;
        return svnr == that.svnr && Objects.equals(id, that.id) && Objects.equals(username, that.username) && Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname) && Objects.equals(attendances, that.attendances);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, firstname, lastname, svnr, attendances);
    }

    @Override
    public String toString() {
        return "StudentSheet{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", svnr=" + svnr +
                ", attendances=" + attendances +
                '}';
    }
}
