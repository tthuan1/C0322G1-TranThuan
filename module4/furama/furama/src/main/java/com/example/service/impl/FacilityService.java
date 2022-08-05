package com.example.service.impl;

import com.example.model.Facility;
import com.example.repository.IFacilityRepository;
import com.example.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository facilityRepository;


    @Override
    public Page<Facility> findAll(Pageable pageable) {
        return facilityRepository.findAll(pageable);
    }

    @Override
    public void save(Facility facility) {
        int i=facility.getFacilityType().getId();
        System.err.println(i);
        if (i==2){
            facility.setPoolArea(null);
        }
        if (i==3){
            facility.setPoolArea(null);
            facility.setNumberOfFloors(null);
        }
        facilityRepository.save(facility);
    }

    @Override
    public void remove(int id) {
        facilityRepository.remove(id);
    }

    @Override
    public Facility findById(int id) {
        return facilityRepository.findById(id).get();
    }

    @Override
    public List<Facility> findAll() {
        return facilityRepository.findAll();
    }
}
