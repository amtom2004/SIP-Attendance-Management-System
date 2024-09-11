package com.beehive.Attendance.System.TKM.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DailyAttendance {
    private LocalDate date;
    private boolean fnAttendance;
    private boolean anAttendance;
}
