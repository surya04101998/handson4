package com.movie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.models.Favorites;

public interface FavouriteDAO extends JpaRepository<Favorites, Long> {

}
