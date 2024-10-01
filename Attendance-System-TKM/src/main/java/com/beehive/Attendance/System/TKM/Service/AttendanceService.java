package com.beehive.Attendance.System.TKM.Service;

import com.beehive.Attendance.System.TKM.dto.AttendanceHistoryDto;
import com.beehive.Attendance.System.TKM.dto.AttendanceRequestDto;
import com.beehive.Attendance.System.TKM.entity.Attendance;
import com.beehive.Attendance.System.TKM.entity.Student;
import com.beehive.Attendance.System.TKM.mapper.AttendanceMapper;
import com.beehive.Attendance.System.TKM.repository.AttendanceRepository;
import com.beehive.Attendance.System.TKM.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service

public class AttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private StudentRepository studentRepository;

    public boolean addAllAttendance(List<AttendanceRequestDto> attendanceRequestDtos){
        for(AttendanceRequestDto attendance : attendanceRequestDtos){
            addAttendance(attendance);
        }
        return true;
    }

    public void addAttendance(AttendanceRequestDto attendanceRequestDto){
        Attendance attendance = AttendanceMapper.mapAttendance(attendanceRequestDto,attendanceRepository,studentRepository);
        Student student = studentRepository.findById(attendance.getStudent().getId()).orElse(null);
        if(student==null)
            return ;
        updateAttendance(attendance.getStudent());
        attendanceRepository.save(attendance);
    }

    public void updateAttendance(Student student){
        List<Attendance> attendanceList = attendanceRepository.findAllByStudent(student);
        int totalSessions = attendanceList.size() * 2; // Each day has 2 sessions (FN and AN)
        int attendedSessions = 0;

        for (Attendance attendance : attendanceList) {
            if(attendance.getFnAttendance() == null){
                totalSessions--;
            }
            else if (attendance.getFnAttendance()) {
                attendedSessions++;
            }
            if( attendance.getAnAttendance()==null ){
                totalSessions--;
            }
            else if (attendance.getAnAttendance()) {
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

    public List<Attendance> findByAdvisorIdAndDate(String department, LocalDate date){
        return attendanceRepository.findByDepartmentAndDate(department, date);
    }

    public List<Attendance> findByMentorIdAndDate(String group, LocalDate date){
        return attendanceRepository.findByGroupAndDate(group, date);
    }

    public List<Attendance> updateAttendanceByAdvisor(String department, LocalDate date, Boolean fnAttendance, Boolean anAttendance){
        List<Attendance> attendances = attendanceRepository.findByDepartmentAndDate(department, date);

        attendances.forEach(attendance -> {
            attendance.setFnAttendance(fnAttendance);
            attendance.setAnAttendance(anAttendance);
        });

        return attendanceRepository.saveAll(attendances);
    }

    public List<Attendance> updateAttendanceByMentor(String  group, LocalDate date, Boolean fnAttendance, Boolean anAttendance){
        List<Attendance> attendances = attendanceRepository.findByGroupAndDate(group, date);

        attendances.forEach(attendance -> {
            attendance.setFnAttendance(fnAttendance);
            attendance.setAnAttendance(anAttendance);
        });

        return attendanceRepository.saveAll(attendances);
    }
}
