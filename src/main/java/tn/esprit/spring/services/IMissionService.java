package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Mission;

public interface IMissionService {
	List<Mission> retrieveAllMissions(); 
	Mission addMission(Mission mis);
	void deleteMission(int id);
	Mission updateMission(Mission mis);
	Mission retrieveMission(int id);
}


