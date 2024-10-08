package com.beehive.Attendance.System.TKM.controller;

import com.beehive.Attendance.System.TKM.Service.MentorService;
import com.beehive.Attendance.System.TKM.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/attendance")

public class MentorController {
    @Autowired
    private MentorService mentorService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("group/{groupId}")
    public List<Student> getAllStudentsByGroupId(@PathVariable String groupId){
        return mentorService.getStudentsByGroupId(groupId);
    }
}
