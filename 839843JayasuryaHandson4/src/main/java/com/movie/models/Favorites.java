package com.movie.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "favourites")
public class Favorites {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	

	private long noOfFavorites = 0;

	@ManyToMany
	@JoinTable(name = "favourite_movies", joinColumns = @JoinColumn(name = "favourite_id"), inverseJoinColumns = @JoinColumn(name = "movie_id"))
	private List<Movie> movieList = new ArrayList<Movie>();
	
	
	@OneToOne
	private User user;
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	public List<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}

	public long getNoOfFavorites() {
		return noOfFavorites;
	}

	public void setNoOfFavorites(long noOfFavorites) {
		this.noOfFavorites = noOfFavorites;
	}

	@Override
	public String toString() {
		return "Favorites [movieList=" + movieList + ", noOfFavorites=" + noOfFavorites + "]";
	}

}
