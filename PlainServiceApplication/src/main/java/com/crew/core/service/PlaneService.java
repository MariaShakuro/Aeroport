package com.crew.core.service;

import com.crew.core.entity.PlaneEntity;
import com.crew.core.repository.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaneService {

    @Autowired
    private PlaneRepository planeRepository;

    public void scheduleMaintenance(Long planeId) {
        PlaneEntity plane = planeRepository.findById(planeId).orElseThrow(() -> new RuntimeException("Plane not found"));
        // Логика для планирования технического обслуживания
        plane.setMaintenanceScheduled(true);
        planeRepository.save(plane);
    }
}

