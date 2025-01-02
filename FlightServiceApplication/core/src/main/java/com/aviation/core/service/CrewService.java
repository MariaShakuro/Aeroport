package com.aviation.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrewService {

    @Autowired
    private CrewRepository crewRepository;

    public void assignCrewToFlight(Long flightId, List<Long> crewIds) {
        List<CrewEntity> crew = crewRepository.findAllById(crewIds);
        for (CrewEntity member : crew) {
            member.setFlightId(flightId);
        }
        crewRepository.saveAll(crew);
    }

    public List<CrewEntity> getCrewForFlight(Long flightId) {
        return crewRepository.findByFlightId(flightId);
    }

    public CrewEntity addCrewMember(CrewEntity crewMember) {
        return crewRepository.save(crewMember);
    }

    public void removeCrewMember(Long crewId) {
        crewRepository.deleteById(crewId);
    }

    public List<CrewEntity> getAllCrewMembers() {
        return crewRepository.findAll();
    }
}
