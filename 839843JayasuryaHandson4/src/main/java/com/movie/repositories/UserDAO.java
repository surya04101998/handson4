package com.movie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.models.User;

public interface UserDAO extends JpaRepository<User, Long> {

}
