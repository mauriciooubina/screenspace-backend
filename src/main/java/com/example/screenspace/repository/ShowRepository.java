package com.example.screenspace.repository;

import com.example.screenspace.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowRepository extends JpaRepository<Show, Integer> {

    List<Show> findAllByCinemaIdAndTheaterId(Integer cinemaID, Integer theaterId);

    List<Show> findAllByMovieIdAndCinemaId(Integer movieId, Integer cinemaID);
}
