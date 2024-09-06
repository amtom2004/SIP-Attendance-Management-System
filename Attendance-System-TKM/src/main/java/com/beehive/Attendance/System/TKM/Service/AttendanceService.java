package com.beehive.Attendance.System.TKM.Service;

import com.beehive.Attendance.System.TKM.entity.Attendance;
import com.beehive.Attendance.System.TKM.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service

public class AttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepository;

    public Attendance save(Attendance attendance){
        return attendanceRepository.save(attendance);
    }

    public List<Attendance> findByStudentIdAndDate(Long StudentId, LocalDate date){
        return attendanceRepository.findByStudentIdAndDate(StudentId, date);
    }

    public List<Attendance> findByAdvisorIdAndDate(Long advisorId, LocalDate date){
        return attendanceRepository.findByAdvisorIdAndDate(advisorId, date);
    }

    public List<Attendance> findByMentorIdAndDate(Long mentorId, LocalDate date){
        return attendanceRepository.findByMentorIdAndDate(mentorId, date);
    }

    public List<Attendance> updateAttendanceByAdvisor(Long advisorId, LocalDate date, Boolean fnAttendance, Boolean anAttendance){
        List<Attendance> attendances = attendanceRepository.findByAdvisorIdAndDate(advisorId, date);

        attendances.forEach(attendance -> {
            attendance.setFnAttendance(fnAttendance);
            attendance.setAnAttendance(anAttendance);
        });

        return attendanceRepository.saveAll(attendances);
    }

    public List<Attendance> updateAttendanceByMentor(Long mentorId, LocalDate date, Boolean fnAttendance, Boolean anAttendance){
        List<Attendance> attendances = attendanceRepository.findByMentorIdAndDate(mentorId, date);

        attendances.forEach(attendance -> {
            attendance.setFnAttendance(fnAttendance);
            attendance.setAnAttendance(anAttendance);
        });

        return attendanceRepository.saveAll(attendances);
    }
}
