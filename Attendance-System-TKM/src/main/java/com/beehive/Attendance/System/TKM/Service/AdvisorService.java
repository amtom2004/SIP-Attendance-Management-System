package com.beehive.Attendance.System.TKM.Service;

import com.beehive.Attendance.System.TKM.entity.Advisor;
import com.beehive.Attendance.System.TKM.repository.AdvisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class AdvisorService {
    @Autowired
    private AdvisorRepository advisorRepository;

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
