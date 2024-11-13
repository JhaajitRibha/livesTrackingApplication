package com.samar.technology.LivesTracker.service;

import com.samar.technology.LivesTracker.model.Family;
import com.samar.technology.LivesTracker.repository.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamilyService {

    @Autowired
    FamilyRepository familyRepository;
    public List<Family> getAllFamily(){
        List<Family>  res = familyRepository.findAll();
        return res;
    }

    public Family addFamily(Family family){
        return familyRepository.save(family);
    }
}
