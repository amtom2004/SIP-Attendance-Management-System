package com.beehive.Attendance.System.TKM.dto;

import com.beehive.Attendance.System.TKM.entity.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceDto {
    private Long studentId;
    private LocalDate date;
    private Boolean fnAttendance;
    private Boolean anAttendance;
}
