package com.beehive.Attendance.System.TKM.mapper;

import com.beehive.Attendance.System.TKM.dto.AttendanceDto;
import com.beehive.Attendance.System.TKM.entity.Attendance;
import com.beehive.Attendance.System.TKM.entity.Student;
import com.beehive.Attendance.System.TKM.repository.AttendanceRepository;
import com.beehive.Attendance.System.TKM.repository.StudentRepository;

import java.util.Objects;

public class AttendanceMapper {

    public static Attendance mapAttendance(AttendanceDto attendanceDto, AttendanceRepository attendanceRepository,
                                           StudentRepository studentRepository){
        Attendance attendance = attendanceRepository.findByStudentIdAndDate(attendanceDto.getStudentId(), attendanceDto.getDate());
        if(attendance == null) {
            attendance = new Attendance();
        }
        Student student = studentRepository.findById(attendanceDto.getStudentId()).orElseThrow(() -> new RuntimeException("Student not found"));
        attendance.setDate(attendanceDto.getDate());
        if(attendanceDto.getFnAttendance() != null)
            attendance.setFnAttendance(attendanceDto.getFnAttendance());
        if(attendanceDto.getAnAttendance() != null)
            attendance.setAnAttendance(attendanceDto.getAnAttendance());
        attendance.setStudent(student);
        return attendanceRepository.save(attendance);
    }
}
