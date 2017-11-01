package entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class Route {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@JsonBackReference(value="routeToVenue")
	@ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.REMOVE})
	@JoinTable(name="route_venue",
	joinColumns = @JoinColumn(name="actor_id"),
	inverseJoinColumns = @JoinColumn(name="film_id"))
	private List<Venue> venues;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Venue> getVenues() {
		return venues;
	}

	public void setVenues(List<Venue> venues) {
		this.venues = venues;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Route [name=" + name + "]";
	}
	
	
}
