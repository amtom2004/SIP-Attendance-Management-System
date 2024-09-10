package com.beehive.Attendance.System.TKM.controller;

import com.beehive.Attendance.System.TKM.Service.AdvisorService;
import com.beehive.Attendance.System.TKM.Service.AttendanceService;
import com.beehive.Attendance.System.TKM.Service.MentorService;
import com.beehive.Attendance.System.TKM.dto.AttendanceDto;
import com.beehive.Attendance.System.TKM.entity.Advisor;
import com.beehive.Attendance.System.TKM.entity.Attendance;
import com.beehive.Attendance.System.TKM.entity.Mentor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("api/attendance")
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private MentorService mentorService;

    @Autowired
    private AdvisorService advisorService;

    @PatchMapping
    public ResponseEntity<Void> addOrUpdateAttendance(@RequestBody AttendanceDto attendanceDto){
        if(attendanceService.save(attendanceDto)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("{studentId}/{date}")
    public Attendance getAttendanceByStudentIdAndDate(@PathVariable Long studentId, @PathVariable String date){
        LocalDate attendanceDate = LocalDate.parse(date);
        return attendanceService.findByStudentIdAndDate(studentId, attendanceDate);
    }

    @GetMapping("department/{departmentId}/{date}")
    public List<Attendance> getAttendanceByAdvisorIdAndDate(@PathVariable String departmentId, @PathVariable String date){
        LocalDate attendanceDate = LocalDate.parse(date);
        return attendanceService.findByAdvisorIdAndDate(departmentId, attendanceDate);
    }

    @GetMapping("group/{groupId}/{date}")
    public List<Attendance> getAttendanceByMentorIdAndDate(@PathVariable String groupId, @PathVariable String date){
        LocalDate attendanceDate = LocalDate.parse(date);
        return attendanceService.findByMentorIdAndDate(groupId, attendanceDate);
    }

    @GetMapping("mentors")
    public List<Mentor> getAllMentors(){
        return mentorService.findAll();
    }

    @GetMapping("advisors")
    public List<Advisor> getAllAdvisors(){
        return advisorService.findAll();
    }

    @PutMapping("/department/{departmentId}/{date}")
    public ResponseEntity<List<Attendance>> updateAttendanceByAdvisor(
            @PathVariable String departmentId,
            @PathVariable String date,
            @RequestParam Boolean fnAttendance,
            @RequestParam Boolean anAttendance) {

        LocalDate attendanceDate = LocalDate.parse(date);
        List<Attendance> updatedAttendances = attendanceService.updateAttendanceByAdvisor(departmentId, attendanceDate, fnAttendance, anAttendance);

        return ResponseEntity.ok(updatedAttendances);
    }

    // Endpoint for Mentor to update attendance for all students in their group
    @PutMapping("/group/{groupId}/{date}")
    public ResponseEntity<List<Attendance>> updateAttendanceByMentor(
            @PathVariable String groupId,
            @PathVariable String date,
            @RequestParam Boolean fnAttendance,
            @RequestParam Boolean anAttendance) {

        LocalDate attendanceDate = LocalDate.parse(date);
        List<Attendance> updatedAttendances = attendanceService.updateAttendanceByMentor(groupId, attendanceDate, fnAttendance, anAttendance);

        return ResponseEntity.ok(updatedAttendances);
    }
}
