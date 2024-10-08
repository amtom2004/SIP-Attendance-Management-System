package com.beehive.Attendance.System.TKM.repository;

import com.beehive.Attendance.System.TKM.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> findAllByDepartment(String department);

    public List<Student> findAllByGroup(String group);
}
