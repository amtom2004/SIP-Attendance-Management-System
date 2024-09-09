package com.beehive.Attendance.System.TKM.Service;

import com.beehive.Attendance.System.TKM.entity.Mentor;
import com.beehive.Attendance.System.TKM.repository.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class MentorService {
    @Autowired
    private MentorRepository mentorRepository;

    public Mentor save(Mentor mentor){
        return mentorRepository.save(mentor);
    }

    public Optional<Mentor> findById(Long id){
        return mentorRepository.findById(id);
    }

    public List<Mentor> findAll(){
        return mentorRepository.findAll();
    }
}
