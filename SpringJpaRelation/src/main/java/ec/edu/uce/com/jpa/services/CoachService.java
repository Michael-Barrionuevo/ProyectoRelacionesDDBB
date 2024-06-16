package ec.edu.uce.com.jpa.services;

import ec.edu.uce.com.jpa.models.Coach;
import ec.edu.uce.com.jpa.repositories.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoachService {

    @Autowired
    private CoachRepository coachRepository;

    public List<Coach> getAllCoaches() {
        return coachRepository.findAll();
    }

    public Optional<Coach> getCoachById(Long id) {
        return coachRepository.findById(id);
    }

    public Coach saveCoach(Coach coach) {
        return coachRepository.save(coach);
    }

    public void deleteCoach(Long id) {
        coachRepository.deleteById(id);
    }

    public Coach updateCoach(Long id, Coach updatedCoach) {
        Optional<Coach> optionalCoach = coachRepository.findById(id);
        if (optionalCoach.isPresent()) {
            Coach coach = optionalCoach.get();
            coach.setName(updatedCoach.getName());
            coach.setLastName(updatedCoach.getLastName());
            coach.setNationality(updatedCoach.getNationality());
            coach.setAge(updatedCoach.getAge());
            return coachRepository.save(coach);
        } else {
            throw new RuntimeException("Coach not found with id: " + id);
        }
    }
}

