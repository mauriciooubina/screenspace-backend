package com.example.screenspace.service;

import com.example.screenspace.model.MovieTheater;
import com.example.screenspace.repository.MovieTheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MovieTheaterService {
    private final MovieTheaterRepository MovieTheaterRepository;

    @Autowired
    public MovieTheaterService(MovieTheaterRepository MovieTheaterRepository) {
        this.MovieTheaterRepository = MovieTheaterRepository;
    }

    public List<MovieTheater> getAllMovieTheaters() {
        return MovieTheaterRepository.findAll();
    }

    public Optional<MovieTheater> getMovieTheaterById(Integer movieTheaterId) {
        return MovieTheaterRepository.findById(movieTheaterId);
    }

    public MovieTheater createMovieTheater(MovieTheater MovieTheater) {
        return MovieTheaterRepository.save(MovieTheater);
    }

    public MovieTheater updateMovieTheater(Integer movieTheaterId, MovieTheater updatedMovieTheater) {
        Optional<MovieTheater> existingMovieTheater = MovieTheaterRepository.findById(movieTheaterId);
        if (existingMovieTheater.isPresent()) {
            updatedMovieTheater.setId(movieTheaterId);
            return MovieTheaterRepository.save(updatedMovieTheater);
        }
        return null;
    }

    public boolean deleteMovieTheater(Integer movieTheaterId) {
        Optional<MovieTheater> existingMovieTheater = MovieTheaterRepository.findById(movieTheaterId);
        if (existingMovieTheater.isPresent()) {
            MovieTheaterRepository.delete(existingMovieTheater.get());
            return true;
        }
        return false;
    }
}
