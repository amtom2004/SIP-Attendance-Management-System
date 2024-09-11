package com.beehive.Attendance.System.TKM.Service;

import com.beehive.Attendance.System.TKM.dto.AttendanceHistoryDto;
import com.beehive.Attendance.System.TKM.entity.Attendance;
import com.beehive.Attendance.System.TKM.entity.Student;
import com.beehive.Attendance.System.TKM.mapper.AttendanceHistoryMapper;
import com.beehive.Attendance.System.TKM.repository.AttendanceRepository;
import com.beehive.Attendance.System.TKM.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service

public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;

    public AttendanceHistoryDto getStudentHistory(Long id){
        List<Attendance> attendances = attendanceRepository.findAllByStudentIdOrderByDate(id);
        return AttendanceHistoryMapper.mapAttendance(attendances);
    }

    public Student save(Student student){
        return studentRepository.save(student);
    }

    public Optional<Student> findById(Long id){
        return studentRepository.findById(id);
    }

    public List<Student> findAll(){
        return studentRepository.findAll();
    }
}
