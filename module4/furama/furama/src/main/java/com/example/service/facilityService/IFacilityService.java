package com.example.service.facilityService;

import com.example.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityService {
    Page<Facility> findAll(Pageable pageable);

    void save(Facility facility);

    void remove(int id);

    Facility findById(int id);

    List<Facility> findAll();
}
