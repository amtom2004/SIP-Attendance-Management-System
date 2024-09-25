package com.beehive.Attendance.System.TKM.mapper;

import com.beehive.Attendance.System.TKM.dto.AttendanceHistoryDto;
import com.beehive.Attendance.System.TKM.dto.DailyAttendance;
import com.beehive.Attendance.System.TKM.entity.Attendance;
import com.beehive.Attendance.System.TKM.entity.Student;

import java.util.List;

public class AttendanceHistoryMapper {
    public static AttendanceHistoryDto mapAttendance(Student student, List<Attendance> attendances){
        AttendanceHistoryDto attendanceHistoryDto = new AttendanceHistoryDto();
        attendanceHistoryDto.setId(student.getId());
        attendanceHistoryDto.setName(student.getName());
        attendanceHistoryDto.setAttendance(student.getAttendancePercentage());
        List<DailyAttendance> dailyAttendances = attendances.stream().map(attendance -> {
            DailyAttendance dailyAttendance = new DailyAttendance();
            dailyAttendance.setDate(attendance.getDate());
            if(attendance.getFnAttendance()!=null)
                dailyAttendance.setFnAttendance(attendance.getFnAttendance());
            if(attendance.getAnAttendance()!=null)
                dailyAttendance.setAnAttendance(attendance.getAnAttendance());
            return dailyAttendance;
        }).toList();

        attendanceHistoryDto.setAttendanceList(dailyAttendances);
        return attendanceHistoryDto;
    }
}
