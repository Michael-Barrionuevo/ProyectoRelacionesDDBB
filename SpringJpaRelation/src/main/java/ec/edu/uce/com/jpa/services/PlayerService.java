package ec.edu.uce.com.jpa.services;

import ec.edu.uce.com.jpa.models.Player;
import ec.edu.uce.com.jpa.repositories.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayerById(Long id) {
        return playerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Player not found with id: " + id));
    }

    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

    public Player updatePlayer(Long id, Player updatedPlayer) {
        Optional<Player> optionalPlayer = playerRepository.findById(id);
        if (optionalPlayer.isPresent()) {
            Player player = optionalPlayer.get();
            player.setName(updatedPlayer.getName());
            player.setLastName(updatedPlayer.getLastName());
            player.setNationality(updatedPlayer.getNationality());
            player.setAge(updatedPlayer.getAge());
            return playerRepository.save(player);
        } else {
            throw new RuntimeException("Coach not found with id: " + id);
        }
    }

    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }
}

