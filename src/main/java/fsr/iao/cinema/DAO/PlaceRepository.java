package fsr.iao.cinema.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import fsr.iao.cinema.entities.Cinema;
import fsr.iao.cinema.entities.Place;
@RepositoryRestResource
@CrossOrigin(origins = "*", allowedHeaders = "*")

public interface PlaceRepository  extends JpaRepository<Place,Long> {

}
