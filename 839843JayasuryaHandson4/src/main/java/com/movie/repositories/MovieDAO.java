package com.movie.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.movie.models.Movie;

public interface MovieDAO extends JpaRepository<Movie, Long> {
	@Query("SELECT m from Movie m WHERE m.active=1 AND m.dateOfLaunch < :today ")
	List<Movie> getMovieListCustomer(@Param("today") Date today);
}
