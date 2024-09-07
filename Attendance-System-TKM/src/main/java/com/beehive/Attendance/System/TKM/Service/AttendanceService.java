package com.beehive.Attendance.System.TKM.Service;

import com.beehive.Attendance.System.TKM.dto.AttendanceDto;
import com.beehive.Attendance.System.TKM.entity.Attendance;
import com.beehive.Attendance.System.TKM.entity.Student;
import com.beehive.Attendance.System.TKM.mapper.AttendanceMapper;
import com.beehive.Attendance.System.TKM.repository.AttendanceRepository;
import com.beehive.Attendance.System.TKM.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service

public class AttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private StudentRepository studentRepository;

    public boolean  save(AttendanceDto attendanceDto){
        Attendance attendance = AttendanceMapper.mapAttendance(attendanceDto,attendanceRepository,studentRepository);
        Student student = studentRepository.findById(attendance.getStudent().getId()).orElse(null);
        if(student==null)
            return false;
        updateAttendance(attendance.getStudent());
        attendanceRepository.save(attendance);
        return true;
    }

    public void updateAttendance(Student student){
        List<Attendance> attendanceList = attendanceRepository.findAllByStudent(student);
        int totalSessions = attendanceList.size() * 2; // Each day has 2 sessions (FN and AN)
        int attendedSessions = 0;

        for (Attendance attendance : attendanceList) {
            if (attendance.getFnAttendance()) {
                attendedSessions++;
            }
            if (attendance.getAnAttendance()) {
                attendedSessions++;
            }
        }

        double attendancePercentage = (double) attendedSessions / totalSessions * 100;
        student.setAttendancePercentage(attendancePercentage);
        studentRepository.save(student);
    }

    public Attendance findByStudentIdAndDate(Long StudentId, LocalDate date){
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
