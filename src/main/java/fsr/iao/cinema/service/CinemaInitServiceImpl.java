package fsr.iao.cinema.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;


















import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.springframework.stereotype.Service;
















import fsr.iao.cinema.DAO.CategoryRepository;
import fsr.iao.cinema.DAO.CinemaRepository;
import fsr.iao.cinema.DAO.FilmRepository;
import fsr.iao.cinema.DAO.PlaceRepository;
import fsr.iao.cinema.DAO.ProjectionRepository;
import fsr.iao.cinema.DAO.SalleRepository;
import fsr.iao.cinema.DAO.SeanceRepository;
import fsr.iao.cinema.DAO.TicketRepository;
import fsr.iao.cinema.DAO.VilleRepository;
import fsr.iao.cinema.entities.Categorie;
import fsr.iao.cinema.entities.Cinema;
import fsr.iao.cinema.entities.Film;
import fsr.iao.cinema.entities.Place;
import fsr.iao.cinema.entities.Projection;
import fsr.iao.cinema.entities.Salle;
import fsr.iao.cinema.entities.Seance;
import fsr.iao.cinema.entities.Ticket;
import fsr.iao.cinema.entities.Ville;

@Service
@Transactional
public class CinemaInitServiceImpl  implements ICinemaInitService{
@Autowired	
private VilleRepository villeRepository;
	@Override
	public void initVilles() {
		// TODO Auto-generated method stub
		Stream.of("Rabat","Casablanca","Merrakech","Tanger").forEach(nameVille->{
			Ville ville =new Ville();
			ville.setName(nameVille);
			villeRepository.save(ville);
		});;
		
		
	}
@Autowired	
private CinemaRepository cinemaRepository;
	@Override
	public void initCinemas() {
		villeRepository.findAll().stream().forEach(ville->{
			Stream.of("Megarama "+ville.getName(),"Daoulize "+ville.getName(),"Renaissance "+ville.getName()).forEach(
				nameCinema->{
					Cinema cinema=new Cinema();
					cinema.setName(nameCinema);
					cinema.setNombreSalles(3+(int)(Math.random()*7));
					cinema.setVille(ville);	
					cinemaRepository.save(cinema);
				});
		});		
	}
@Autowired	
private SalleRepository salleRepository;
	@Override
	public void initSalles() {
		cinemaRepository.findAll().stream().forEach(cinema->{
			IntStream.range(0,cinema.getNombreSalles()).forEach(i->{
				Salle salle = new Salle();
				salle.setName(" salle "+i+1);
				salle.setCinema(cinema);
				salle.setNombrePlace(15+(int)(Math.random()*20));
				salleRepository.save(salle);
					}
					);
		});	
		
	}
@Autowired	
private PlaceRepository placeRepository;
	@Override
	public void initPlaces() {
		salleRepository.findAll().stream().forEach(salle->{
			IntStream.range(0,salle.getNombrePlace()).forEach(i->{
				Place place = new Place();
				place.setNumero(i+1);
				place.setSalle(salle);				
				placeRepository.save(place);
					}
					);
		});
	}
@Autowired	
private SeanceRepository seanceRepository;
	@Override
	public void initSeances() {
		// TODO Auto-generated method stub
		DateFormat dateFormat=new SimpleDateFormat("HH:mm");

		Stream.of("12:00","15:00","17:00","19:00","21:00").forEach(s->{
			Seance seance=new Seance();
			try {
				seance.setHeureDebut(dateFormat.parse(s));
				seanceRepository.save(seance);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
	}
@Autowired	
private CategoryRepository categoryRepository;
	@Override
	public void initCategories() {
		// TODO Auto-generated method stub
		Stream.of("Action","Drama","Fiction","Histoire").forEach(cat->{
			Categorie  categorie=new Categorie();
			categorie.setName(cat);
			categoryRepository.save(categorie);
		});
	}
@Autowired	
private FilmRepository filmRepository;
	@Override
	public void initFilms() {
		// TODO Auto-generated method stub
		double[] duree=new double[]{1,1.5,2,2.5,3};
		List<Categorie> categories=categoryRepository.findAll();
		Stream.of("Game Of Thrones","Spider Man","Batman","Titanic","Cat Women","Super Man").forEach(nameFilm->{
			Film  film =new Film();
			film.setTitre(nameFilm);
			film.setDuree(duree[(int)Math.random()*duree.length]);
			film.setPhoto(nameFilm.replaceAll(" ", "")+".jpg");
			film.setCategorie(categories.get(new Random().nextInt(categories.size())));
			filmRepository.save(film);
		});
		
	}
@Autowired	
private ProjectionRepository projectionRepository;
	@Override
	public void initProjections() {
		// TODO Auto-generated method stub
		double[] prices=new double[]{50,60,70,80};
		List<Film> films=filmRepository.findAll();
		
		villeRepository.findAll().forEach(ville->{
			ville.getCinemas().forEach(cinema->{
				cinema.getSalles().forEach(salle->{
					//filmRepository.findAll().forEach(film->{
						int index=new Random().nextInt(films.size());
						Film film=films.get(index);
						seanceRepository.findAll().forEach(seance->{
							Projection projection=new Projection();
							projection.setDateProjection(new Date());
							projection.setFilm(film);
							projection.setPrix(prices[new Random().nextInt(prices.length)]);
							projection.setSalle(salle);
							projection.setSeance(seance);
							projectionRepository.save(projection);
						});
					//});
				});
			});
		});
		
	}
@Autowired	
private TicketRepository ticketRepository;
	@Override
	public void initTickets() {
		// TODO Auto-generated method stub
		projectionRepository.findAll().forEach(projection->{
			projection.getSalle().getPlaces().forEach(place->{
				Ticket ticket=new Ticket();
				ticket.setPlace(place);
				ticket.setProjection(projection);
				ticket.setPrix(projection.getPrix());
				ticket.setReserve(false);
				ticketRepository.save(ticket);
				
			});
		});
		
	}

}
