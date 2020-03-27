package com.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.movie.models.Movie;
import com.movie.services.FavouriteService;

@Controller
public class MovieController {
	
	@Autowired
	FavouriteService fav;
	
	@GetMapping("/")
	public void getFavById(long userId) {
		userId=1;
		List<Movie> favourites=fav.getAllFavoritesMovies(userId);
		System.out.println(favourites);
	}
}