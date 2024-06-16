package ec.edu.uce.com.jpa.repositories;

import ec.edu.uce.com.jpa.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {

}
