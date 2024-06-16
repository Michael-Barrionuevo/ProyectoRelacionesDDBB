package ec.edu.uce.com.jpa.services;

import ec.edu.uce.com.jpa.models.FootballAssociation;
import ec.edu.uce.com.jpa.repositories.FootballAssociationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FootballAssociationService {

    @Autowired
    private FootballAssociationRepository footballAssociationRepository;

    public List<FootballAssociation> getAllAssociations() {
        return footballAssociationRepository.findAll();
    }

    public FootballAssociation getAssociationById(Long id) {
        return footballAssociationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Football Association not found with id: " + id));
    }

    public FootballAssociation saveAssociation(FootballAssociation association) {
        return footballAssociationRepository.save(association);
    }

    public FootballAssociation updateAssociation(Long id, FootballAssociation updatedAssociation) {
        FootballAssociation existingAssociation = getAssociationById(id);
        existingAssociation.setName(updatedAssociation.getName());
        // Actualizar otros campos según sea necesario
        return footballAssociationRepository.save(existingAssociation);
    }

    public void deleteAssociation(Long id) {
        footballAssociationRepository.deleteById(id);
    }
}

