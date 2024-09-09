package com.beehive.Attendance.System.TKM.repository;

import com.beehive.Attendance.System.TKM.entity.Attendance;
import com.beehive.Attendance.System.TKM.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    Attendance findByStudentIdAndDate(Long studentId, LocalDate date);

    @Query("SELECT a FROM Attendance a WHERE a.student.advisor.id = :advisorId AND a.date = :date")
    List<Attendance> findByAdvisorIdAndDate(Long advisorId, LocalDate date);

    @Query("SELECT a FROM Attendance a WHERE a.student.mentor.id = :mentorId AND a.date = :date")
    List<Attendance> findByMentorIdAndDate(Long mentorId, LocalDate date);

    List<Attendance> findAllByStudent(Student student);
}
