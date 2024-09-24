package com.beehive.Attendance.System.TKM.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceHistoryDto {
    private Long id;
    private String name;
    private List<DailyAttendance> attendances;
}

