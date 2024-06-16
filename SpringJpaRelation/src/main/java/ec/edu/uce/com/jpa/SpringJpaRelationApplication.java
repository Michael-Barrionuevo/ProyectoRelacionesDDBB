package ec.edu.uce.com.jpa;

import ec.edu.uce.com.jpa.controller.ControllerFootballTeams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJpaRelationApplication implements CommandLineRunner {

	@Autowired
	private ControllerFootballTeams controllerFootballTeams;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaRelationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		controllerFootballTeams.insertTestData();
	}
}
