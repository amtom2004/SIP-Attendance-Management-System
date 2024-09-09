package com.beehive.Attendance.System.TKM.repository;

import com.beehive.Attendance.System.TKM.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
