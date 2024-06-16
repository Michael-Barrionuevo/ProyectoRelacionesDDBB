package ec.edu.uce.com.jpa.services;

import ec.edu.uce.com.jpa.models.FootballCompetition;
import ec.edu.uce.com.jpa.repositories.FootballCompetitionRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FootballCompetitionService {

    @Autowired
    private FootballCompetitionRepository competitionRepository;

    public List<FootballCompetition> getAllCompetitions() {
        return competitionRepository.findAll();
    }

    public FootballCompetition getCompetitionById(Long id) {
        return competitionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Football Competition not found with id: " + id));
    }

    public FootballCompetition saveCompetition(FootballCompetition competition) {
        return competitionRepository.save(competition);
    }

    public FootballCompetition updateCompetition(Long id, FootballCompetition updatedCompetition) {
        FootballCompetition existingCompetition = getCompetitionById(id);
        existingCompetition.setName(updatedCompetition.getName());
        // Actualizar otros campos según sea necesario
        return competitionRepository.save(existingCompetition);
    }

    public void deleteCompetition(Long id) {
        competitionRepository.deleteById(id);
    }
}

