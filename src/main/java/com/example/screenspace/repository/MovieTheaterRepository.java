package com.example.screenspace.repository;

import com.example.screenspace.model.MovieTheater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieTheaterRepository extends JpaRepository<MovieTheater, Integer> {

    List<MovieTheater> findAllByCinemaId(Integer cinemaId);
}
