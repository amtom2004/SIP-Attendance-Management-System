package com.beehive.Attendance.System.TKM.controller;

import com.beehive.Attendance.System.TKM.Service.AdvisorService;
import com.beehive.Attendance.System.TKM.Service.AttendanceService;
import com.beehive.Attendance.System.TKM.Service.MentorService;
import com.beehive.Attendance.System.TKM.dto.AttendanceDto;
import com.beehive.Attendance.System.TKM.entity.Advisor;
import com.beehive.Attendance.System.TKM.entity.Attendance;
import com.beehive.Attendance.System.TKM.entity.Mentor;
import jakarta.servlet.annotation.HttpConstraint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin
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

    @GetMapping("advisor/{advisorId}/{date}")
    public List<Attendance> getAttendanceByAdvisorIdAndDate(@PathVariable Long advisorId, @PathVariable String date){
        LocalDate attendanceDate = LocalDate.parse(date);
        return attendanceService.findByAdvisorIdAndDate(advisorId, attendanceDate);
    }

    @GetMapping("mentor/{mentorId}/{date}")
    public List<Attendance> getAttendanceByMentorIdAndDate(@PathVariable Long mentorId, @PathVariable String date){
        LocalDate attendanceDate = LocalDate.parse(date);
        return attendanceService.findByMentorIdAndDate(mentorId, attendanceDate);
    }

    @GetMapping("mentors")
    public List<Mentor> getAllMentors(){
        return mentorService.findAll();
    }

    @GetMapping("advisors")
    public List<Advisor> getAllAdvisors(){
        return advisorService.findAll();
    }

    @PutMapping("/advisor/{advisorId}/{date}")
    public ResponseEntity<List<Attendance>> updateAttendanceByAdvisor(
            @PathVariable Long advisorId,
            @PathVariable String date,
            @RequestParam Boolean fnAttendance,
            @RequestParam Boolean anAttendance) {

        LocalDate attendanceDate = LocalDate.parse(date);
        List<Attendance> updatedAttendances = attendanceService.updateAttendanceByAdvisor(advisorId, attendanceDate, fnAttendance, anAttendance);

        return ResponseEntity.ok(updatedAttendances);
    }

    // Endpoint for Mentor to update attendance for all students in their group
    @PutMapping("/mentor/{mentorId}/{date}")
    public ResponseEntity<List<Attendance>> updateAttendanceByMentor(
            @PathVariable Long mentorId,
            @PathVariable String date,
            @RequestParam Boolean fnAttendance,
            @RequestParam Boolean anAttendance) {

        LocalDate attendanceDate = LocalDate.parse(date);
        List<Attendance> updatedAttendances = attendanceService.updateAttendanceByMentor(mentorId, attendanceDate, fnAttendance, anAttendance);

        return ResponseEntity.ok(updatedAttendances);
    }
}
