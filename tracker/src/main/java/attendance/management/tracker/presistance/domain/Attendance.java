package attendance.management.tracker.presistance.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Blob;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
@Entity
public class Attendance {

    @Id
    @GeneratedValue
    private Long id;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private boolean confirmed;
    private Blob absenceConfirmation;

    public Attendance() {
    }

    public Attendance(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public Blob getAbsenceConfirmation() {
        return absenceConfirmation;
    }

    public void setAbsenceConfirmation(Blob absenceConfirmation) {
        this.absenceConfirmation = absenceConfirmation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attendance that = (Attendance) o;
        return confirmed == that.confirmed && Objects.equals(id, that.id) && Objects.equals(date, that.date) && Objects.equals(startTime, that.startTime) && Objects.equals(endTime, that.endTime) && Objects.equals(absenceConfirmation, that.absenceConfirmation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, startTime, endTime, confirmed, absenceConfirmation);
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "id=" + id +
                ", date=" + date +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", confirmed=" + confirmed +
                ", absenceConfirmation=" + absenceConfirmation +
                '}';
    }
}
