package com.beehive.Attendance.System.TKM.controller;

import com.beehive.Attendance.System.TKM.Service.MentorService;
import com.beehive.Attendance.System.TKM.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/attendance")
public class MentorController {
    @Autowired
    private MentorService mentorService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("mentor/{id}")
    public List<Student> getAllStudentsByMentorId(@PathVariable Long id){
        return mentorService.getStudentsByMentorId(id);
    }
}
