package com.example.service.facilityService;

import com.example.model.facility.Facility;
import com.example.repository.facility.IFacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FacilityService implements IFacilityService{
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
}
