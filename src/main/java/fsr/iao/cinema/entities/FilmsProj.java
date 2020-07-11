package fsr.iao.cinema.entities;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="fl",types={fsr.iao.cinema.entities.Film.class})

public interface FilmsProj {
public Long getId();
public String getTitre();
public double getDuree();
public  String getRealisateur();
public String getDescription();
public String getPhoto();
public Date getDateSortie();
public Categorie getCategorie();
public String getVideoUrl();
}
