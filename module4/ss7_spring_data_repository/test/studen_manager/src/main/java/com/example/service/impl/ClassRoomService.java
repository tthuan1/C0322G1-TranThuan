package com.example.service.impl;

import com.example.model.ClassRoom;
import com.example.repository.IClassRoomRepository;
import com.example.service.IClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassRoomService implements IClassRoomService {
    @Autowired
    IClassRoomRepository classRoomRepository;

    @Override
    public List<ClassRoom> findAllClassRoom() {
        return classRoomRepository.findAllClassRoom();
    }
}
