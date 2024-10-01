package com.beehive.Attendance.System.TKM.mapper;

import com.beehive.Attendance.System.TKM.dto.AttendanceRequestDto;
import com.beehive.Attendance.System.TKM.entity.Attendance;
import com.beehive.Attendance.System.TKM.entity.Student;
import com.beehive.Attendance.System.TKM.repository.AttendanceRepository;
import com.beehive.Attendance.System.TKM.repository.StudentRepository;

public class AttendanceMapper {

    public static Attendance mapAttendance(AttendanceRequestDto attendanceRequestDto, AttendanceRepository attendanceRepository,
                                           StudentRepository studentRepository){
        Attendance attendance = attendanceRepository.findByStudentIdAndDate(attendanceRequestDto.getStudentId(), attendanceRequestDto.getDate());
        if(attendance == null) {
            attendance = new Attendance();
        }
        Student student = studentRepository.findById(attendanceRequestDto.getStudentId()).orElseThrow(() -> new RuntimeException("Student not found"));
        attendance.setDate(attendanceRequestDto.getDate());
        if(attendanceRequestDto.getFnAttendance() != null)
            attendance.setFnAttendance(attendanceRequestDto.getFnAttendance());
        if(attendanceRequestDto.getAnAttendance() != null)
            attendance.setAnAttendance(attendanceRequestDto.getAnAttendance());
        attendance.setStudent(student);
        return attendanceRepository.save(attendance);
    }
}
