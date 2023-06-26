package com.example.screenspace.repository;

import com.example.screenspace.model.Shows;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowsRepository extends JpaRepository<Shows, Integer> {

    List<Shows> findAllByCinemaIdAndTheaterId(Integer cinemaId, Integer theaterId);

    List<Shows> findAllByMovieIdAndCinemaId(Integer movieId, Integer cinemaID);
}
