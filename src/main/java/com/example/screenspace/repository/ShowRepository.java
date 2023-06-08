package com.example.screenspace.repository;

import com.example.screenspace.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowRepository extends JpaRepository<Show, Integer> {

    List<Show> findAllByCinemaAndTheaterId(Integer cinemaId, Integer theaterId);

    List<Show> findAllByMovieAndCinemaId(Integer movieId, Integer cinemaId);
}
