package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.repository.MissionRepository;
@Service
public class MissionServiceImpl implements IMissionService {
	private static final Logger l = LogManager.getLogger(UserServiceImpl.class);
    @Autowired
    MissionRepository mis_repo;
	@Override
	public List<Mission> retrieveAllMissions() {
		
		List<Mission> missions = null;
		try {

			l.info("enter  retrieveAllMission  () : ");
			missions = (List<Mission>) mis_repo.findAll();  
			for (Mission et : missions) {
				l.debug("user +++ : " + et);
			} 
			l.info("fonction retrieveAllmission ended () : ");
		}catch (Exception e) {
			l.error("Error  in  retrieveAllmission () : " + e);
		}

		return missions;
		
	}

	@Override
	public Mission addMission(Mission mis) {
		try{
			l.info(" adding mission :");
			return mis_repo.save(mis);
		}catch (Exception e) {

			l.error("Error in adding mission ");

			return null;
		}
	}

	@Override
	public void deleteMission(int id) {
		try{
			
			mis_repo.deleteById(id);
			l.info("Mission deleted ");
		}catch (Exception e) {

			l.error("The mission with the id = %d does not Exist",id);
		}
		
	}

	@Override
	public Mission updateMission(Mission mis) {
		return mis_repo.save(mis);
	}

	@Override
	public Mission retrieveMission(int id) {
		l.info("in  retrieveMission id = " + id);
		//orElse(null);
		 
		Mission E=  mis_repo.findById(id).orElse(null);
		l.info("Mission back : " + E);
		return E;
	}

}
