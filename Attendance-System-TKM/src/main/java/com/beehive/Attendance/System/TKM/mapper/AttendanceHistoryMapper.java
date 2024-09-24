package com.beehive.Attendance.System.TKM.mapper;

import com.beehive.Attendance.System.TKM.dto.AttendanceHistoryDto;
import com.beehive.Attendance.System.TKM.dto.DailyAttendance;
import com.beehive.Attendance.System.TKM.entity.Attendance;

import java.util.List;
import java.util.stream.Collectors;

public class AttendanceHistoryMapper {
    public static AttendanceHistoryDto mapAttendance(List<Attendance> attendances){
        if(attendances.isEmpty()){
            return null;
        }

        AttendanceHistoryDto attendanceHistoryDto = new AttendanceHistoryDto();
        attendanceHistoryDto.setId(attendances.get(0).getStudent().getId());
        attendanceHistoryDto.setName(attendances.get(0).getStudent().getName());

        List<DailyAttendance> dailyAttendances = attendances.stream().map(attendance -> {
            DailyAttendance dailyAttendance = new DailyAttendance();
            dailyAttendance.setDate(attendance.getDate());
            if(attendance.getFnAttendance()!=null)
                dailyAttendance.setFnAttendance(attendance.getFnAttendance());
            if(attendance.getAnAttendance()!=null)
                dailyAttendance.setAnAttendance(attendance.getAnAttendance());
            return dailyAttendance;
        }).toList();

        attendanceHistoryDto.setAttendances(dailyAttendances);
        return attendanceHistoryDto;
    }
}
