package com.movie.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.models.Movie;
import com.movie.repositories.MovieDAO;

@Service
public class MovieService {

	@Autowired
	private MovieDAO movieRepository;

	public List<Movie> getMovieListAdmin() {
		return movieRepository.findAll();
	}

	public List<Movie> getMovieListCustomer() {
		Date date = new Date();
		return movieRepository.getMovieListCustomer(date);
	}

	public void modifyMovie(Movie movie) {
		movieRepository.save(movie);
	}

	public Movie getMovie(long movieId) {
		return movieRepository.findById(movieId).get();
	}
	
}
