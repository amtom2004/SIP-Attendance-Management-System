package com.beehive.Attendance.System.TKM.controller;

import com.beehive.Attendance.System.TKM.Service.AdvisorService;
import com.beehive.Attendance.System.TKM.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/attendance")
public class AdvisorController {

    @Autowired
    AdvisorService advisorService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("advisor/{id}")
    public List<Student> getStudentsByAdvisor(@PathVariable Long id){
        return advisorService.getStudentByAdvisor(id);
    }
}
