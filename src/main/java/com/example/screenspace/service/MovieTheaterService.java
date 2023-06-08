package com.example.screenspace.service;

import com.example.screenspace.model.MovieTheater;
import com.example.screenspace.repository.MovieTheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MovieTheaterService {
    private final MovieTheaterRepository movieTheaterRepository;

    @Autowired
    public MovieTheaterService(MovieTheaterRepository MovieTheaterRepository) {
        this.movieTheaterRepository = MovieTheaterRepository;
    }

    public List<MovieTheater> getAllMovieTheaters() {
        return movieTheaterRepository.findAll();
    }

    public Optional<MovieTheater> getMovieTheaterById(Integer movieTheaterId) {
        return movieTheaterRepository.findById(movieTheaterId);
    }

    public MovieTheater createMovieTheater(MovieTheater MovieTheater) {
        return movieTheaterRepository.save(MovieTheater);
    }

    public MovieTheater updateMovieTheater(Integer movieTheaterId, MovieTheater updatedMovieTheater) {
        Optional<MovieTheater> existingMovieTheater = movieTheaterRepository.findById(movieTheaterId);
        if (existingMovieTheater.isPresent()) {
            updatedMovieTheater.setId(movieTheaterId);
            return movieTheaterRepository.save(updatedMovieTheater);
        }
        return null;
    }

    public boolean deleteMovieTheater(Integer movieTheaterId) {
        Optional<MovieTheater> existingMovieTheater = movieTheaterRepository.findById(movieTheaterId);
        if (existingMovieTheater.isPresent()) {
            movieTheaterRepository.delete(existingMovieTheater.get());
            return true;
        }
        return false;
    }

    public List<MovieTheater> getAllMovieTheatersFromCinemaId(Integer cinemaId) {
        return movieTheaterRepository.findAllByCinemaId(cinemaId);
    }
}
