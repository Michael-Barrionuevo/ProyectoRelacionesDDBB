package ec.edu.uce.com.jpa.controller;

import ec.edu.uce.com.jpa.models.*;
import ec.edu.uce.com.jpa.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class ControllerFootballTeams {

    @Autowired
    private ClubRepository clubRepository;

    @Autowired
    private CoachRepository coachRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private FootballAssociationRepository footballAssociationRepository;

    @Autowired
    private FootballCompetitionRepository footballCompetitionRepository;

    @Transactional
    public void insertTestData() {
        // Crear y guardar un entrenador
        Coach coach = new Coach(1, "Gato", "Tupin", "Argentino", 35);
        coach = coachRepository.save(coach);

        // Crear y guardar una asociación de fútbol
        FootballAssociation footballAssociation = new FootballAssociation(1, "FEF", "Ecuador", "Veyker Barrionuevo");
        footballAssociation = footballAssociationRepository.save(footballAssociation);

        // Crear y guardar una competición de fútbol
        LocalDate startDate = LocalDate.of(2024, 6, 15);
        LocalDate endDate = LocalDate.of(2024, 8, 22);
        FootballCompetition footballCompetition = new FootballCompetition(1, "Copa Sudamericana", 3000, startDate, endDate);
        footballCompetition = footballCompetitionRepository.save(footballCompetition);

        // Crear y guardar un jugador
        Player player = new Player(1, "Kitu", "Diaz", "Argentino", 31, "Delantero");
        player = playerRepository.save(player);

        // Crear un club y asignarle el entrenador y la asociación de fútbol
        Club club1 = new Club(1, "Barcelona");
        club1.setCoach(coach);
        coach.setId(club1.getId());
        club1.setPlayers(List.of(player));
        club1.setFootballCompetitions(List.of(footballCompetition));
        clubRepository.save(club1);

        // Obtener todos los clubs
        List<Club> clubs = clubRepository.findAll();
        System.out.println("Clubs encontrados: " + clubs);

        // Actualizar un club
        Club clubToUpdate = clubs.get(0);
        clubToUpdate.setName("Club Actualizado");
        clubRepository.save(clubToUpdate);

        // Obtener un club por ID
        Long clubId = clubs.get(0).getId();
        Club foundClub = clubRepository.findById(clubId).orElse(null);
        System.out.println("Club encontrado por ID: " + foundClub);

        // Eliminar un club por ID
        clubRepository.deleteById(clubId);
        System.out.println("Club eliminado exitosamente.");

        // Verificar que la base de datos esté vacía
        List<Club> remainingClubs = clubRepository.findAll();
        System.out.println("Clubs restantes: " + remainingClubs);

        // Obtener todos los entrenadores
        List<Coach> coaches = coachRepository.findAll();
        System.out.println("Entrenadores encontrados: " + coaches);

     // Actualizar un entrenador
        Coach coachToUpdate = coaches.get(0);
        coachToUpdate.setName("Entrenador Actualizado");
        coachRepository.save(coachToUpdate);

     // Obtener un entrenador por ID
        Long coachId = coaches.get(0).getId();
        Coach foundCoach = coachRepository.findById(coachId).orElse(null);
        System.out.println("Entrenador encontrado por ID: " + foundCoach);

     // Eliminar un entrenador por ID
        coachRepository.deleteById(coachId);
        System.out.println("Entrenador eliminado exitosamente.");

     // Verificar que la base de datos esté vacía
        List<Coach> remainingCoaches = coachRepository.findAll();
        System.out.println("Entrenadores restantes: " + remainingCoaches);

        // Obtener todos los jugadores
        List<Player> players = playerRepository.findAll();
        System.out.println("Jugadores encontrados: " + players);

     // Actualizar un jugador
        Player playerToUpdate = players.get(0);
        playerToUpdate.setName("Jugador Actualizado");
        playerRepository.save(playerToUpdate);

        // Obtener un jugador por ID
        Long playerId = players.get(0).getId();
        Player foundPlayer = playerRepository.findById(playerId).orElse(null);
        System.out.println("Jugador encontrado por ID: " + foundPlayer);

     // Eliminar un jugador por ID
        playerRepository.deleteById(playerId);
        System.out.println("Jugador eliminado exitosamente.");

    // Verificar que la base de datos esté vacía
        List<Player> remainingPlayers = playerRepository.findAll();
        System.out.println("Jugadores restantes: " + remainingPlayers);

        // Obtener todas las asociaciones de fútbol
        List<FootballAssociation> associations = footballAssociationRepository.findAll();
        System.out.println("Asociaciones encontradas: " + associations);

    // Actualizar una asociación de fútbol
        FootballAssociation associationToUpdate = associations.get(0);
        associationToUpdate.setName("Asociación Actualizada");
        footballAssociationRepository.save(associationToUpdate);

    // Obtener una asociación por ID
        Long associationId = associations.get(0).getId();
        FootballAssociation foundAssociation = footballAssociationRepository.findById(associationId).orElse(null);
        System.out.println("Asociación encontrada por ID: " + foundAssociation);

    // Eliminar una asociación por ID
        footballAssociationRepository.deleteById(associationId);
        System.out.println("Asociación eliminada exitosamente.");

    // Verificar que la base de datos esté vacía
        List<FootballAssociation> remainingAssociations = footballAssociationRepository.findAll();
        System.out.println("Asociaciones restantes: " + remainingAssociations);
    // Obtener todas las competiciones de fútbol
        List<FootballCompetition> competitions = footballCompetitionRepository.findAll();
        System.out.println("Competiciones encontradas: " + competitions);

    // Actualizar una competición de fútbol
        FootballCompetition competitionToUpdate = competitions.get(0);
        competitionToUpdate.setName("Competición Actualizada");
        footballCompetitionRepository.save(competitionToUpdate);

    // Obtener una competición por ID
        Long competitionId = competitions.get(0).getId();
        FootballCompetition foundCompetition = footballCompetitionRepository.findById(competitionId).orElse(null);
        System.out.println("Competición encontrada por ID: " + foundCompetition);

    // Eliminar una competición por ID
        footballCompetitionRepository.deleteById(competitionId);
        System.out.println("Competición eliminada exitosamente.");

    // Verificar que la base de datos esté vacía
        List<FootballCompetition> remainingCompetitions = footballCompetitionRepository.findAll();
        System.out.println("Competiciones restantes: " + remainingCompetitions);

    }
}
