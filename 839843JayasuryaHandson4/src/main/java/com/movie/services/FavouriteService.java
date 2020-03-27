package com.movie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.models.Favorites;
import com.movie.models.Movie;
import com.movie.models.User;
import com.movie.repositories.FavouriteDAO;
import com.movie.repositories.MovieDAO;
import com.movie.repositories.UserDAO;

@Service
public class FavouriteService {
	@Autowired
	UserDAO userRepository;

	@Autowired
	MovieDAO movieRepository;

	@Autowired
	FavouriteDAO favRepository;

	public void addFavoritesMovie(long userId, long movieId) {
		
		User user = userRepository.findById(userId).get();
		Movie movie = movieRepository.findById(movieId).get();
		Favorites favourites = user.getFavourites();
		favourites.getMovieList().add(movie);
		favourites.setNoOfFavorites(favourites.getNoOfFavorites() + 1);
		favRepository.save(favourites);
		
	}

	
	
	public List<Movie> getAllFavoritesMovies(long userId) {
		
		
		User user = userRepository.findById(userId).get();
		Favorites favorites = user.getFavourites();
		return favorites.getMovieList();
	
	}

	
	
	
	public void removeFavoritesMovie(long userId, long movieId) {
		
		
		
		User user = userRepository.findById(userId).get();
		Movie movie = movieRepository.findById(movieId).get();
		Favorites favourites = user.getFavourites();
		favourites.getMovieList().remove(movie);
		favourites.setNoOfFavorites(favourites.getNoOfFavorites()-1);
		favRepository.save(favourites);
	}

}
