package fsr.iao.cinema.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import fsr.iao.cinema.entities.Cinema;
import fsr.iao.cinema.entities.Film;
@RepositoryRestResource
@CrossOrigin(origins = "*", allowedHeaders = "*")

public interface FilmRepository  extends JpaRepository<Film,Long> {
}
