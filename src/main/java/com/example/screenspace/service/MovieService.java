package com.example.screenspace.service;

import com.example.screenspace.model.Movie;
import com.example.screenspace.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(Integer movieId) {
        return movieRepository.findById(movieId);
    }

    public Movie createMovie(Movie Movie) {
        return movieRepository.save(Movie);
    }

    public Movie updateMovie(Integer movieId, Movie updatedMovie) {
        Optional<Movie> existingMovie = movieRepository.findById(movieId);
        if (existingMovie.isPresent()) {
            updatedMovie.setId(movieId);
            return movieRepository.save(updatedMovie);
        }
        return null;
    }

    public boolean deleteMovie(Integer movieId) {
        Optional<Movie> existingMovie = movieRepository.findById(movieId);
        if (existingMovie.isPresent()) {
            movieRepository.delete(existingMovie.get());
            return true;
        }
        return false;
    }
}
