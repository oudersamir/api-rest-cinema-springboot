package fsr.iao.cinema.entities;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.rest.core.config.Projection;




import fsr.iao.cinema.entities.Film;
import fsr.iao.cinema.entities.Salle;
import fsr.iao.cinema.entities.Seance;
import fsr.iao.cinema.entities.Ticket;

@Projection(name="p1",types={fsr.iao.cinema.entities.Projection.class})
public interface ProjectionProj {
public Long getId();
public double getPrix();
public Date getDateProjection();
public Salle getSalle();
public Film getFilm();
public Seance getSeance();
public Collection<Ticket> getTickets();

}
