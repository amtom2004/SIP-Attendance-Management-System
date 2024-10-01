package com.beehive.Attendance.System.TKM.controller;

import com.beehive.Attendance.System.TKM.Service.StudentService;
import com.beehive.Attendance.System.TKM.dto.AttendanceHistoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/attendance")
public class StudentController {
    @Autowired
    StudentService studentService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("student/{id}")
    public AttendanceHistoryDto getAttendanceHistoryByStudent(@PathVariable Long id){
        return studentService.getStudentHistory(id);
    }

}
