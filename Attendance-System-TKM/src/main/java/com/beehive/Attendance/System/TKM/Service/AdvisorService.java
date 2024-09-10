package com.beehive.Attendance.System.TKM.Service;

import com.beehive.Attendance.System.TKM.entity.Advisor;
import com.beehive.Attendance.System.TKM.entity.Student;
import com.beehive.Attendance.System.TKM.repository.AdvisorRepository;
import com.beehive.Attendance.System.TKM.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class AdvisorService {
    @Autowired
    private AdvisorRepository advisorRepository;

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudentByAdvisor(String department){
        return studentRepository.findAllByDepartment(department);
    }

    public Advisor save(Advisor advisor){
        return advisorRepository.save(advisor);
    }

    public Optional<Advisor> findById(Long id){
        return advisorRepository.findById(id);
    }

    public List<Advisor> findAll(){
        return advisorRepository.findAll();
    }
}
