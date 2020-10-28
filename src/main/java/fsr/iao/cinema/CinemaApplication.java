package fsr.iao.cinema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;
import fsr.iao.cinema.entities.Categorie;
import fsr.iao.cinema.entities.Cinema;
import fsr.iao.cinema.entities.Film;
import fsr.iao.cinema.entities.Salle;
import fsr.iao.cinema.entities.Ville;
import fsr.iao.cinema.service.ICinemaInitService;


@SpringBootApplication (exclude = SecurityAutoConfiguration.class)
     

public class CinemaApplication implements CommandLineRunner {
	@Autowired
    private ICinemaInitService cinemaInitService;
	@Autowired
	private RepositoryRestConfiguration  restConfiguration;
	public static void main(String[] args) {
		SpringApplication.run(CinemaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		restConfiguration.exposeIdsFor(Ville.class,Cinema.class,Salle.class,Film.class,Categorie.class);
	

		cinemaInitService.initVilles();
		cinemaInitService.initCinemas();
		cinemaInitService.initSalles();
		cinemaInitService.initPlaces();
		cinemaInitService.initSeances();
		cinemaInitService.initCategories();
		cinemaInitService.initFilms();
		cinemaInitService.initProjections();
		cinemaInitService.initTickets();
		
	}
	

}
