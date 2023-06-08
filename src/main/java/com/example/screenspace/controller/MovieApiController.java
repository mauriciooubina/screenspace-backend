package com.example.screenspace.controller;

import com.example.screenspace.model.Book;
import com.example.screenspace.model.Cinema;
import com.example.screenspace.model.Movie;
import com.example.screenspace.model.Show;
import com.example.screenspace.service.MovieService;
import com.example.screenspace.service.ShowService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.processing.Generated;
import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-05-25T13:49:06.606500-03:00[America/Argentina/Buenos_Aires]")
@RestController
public class MovieApiController implements MovieApi {

    private static final Logger log = LoggerFactory.getLogger(MovieApiController.class);
    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;
    private final MovieService movieService;
    private final ShowService showService;

    @Autowired
    public MovieApiController(ObjectMapper objectMapper, HttpServletRequest request, MovieService movieService, ShowService showService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.movieService = movieService;
        this.showService = showService;
    }


    public ResponseEntity<List<Movie>> movieGet() {
        try {
            List<Movie> movies = movieService.getAllMovies();
            return new ResponseEntity<>(movies, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    public ResponseEntity<Movie> movieMovieIdGet(@Min(1) @Parameter(in = ParameterIn.PATH, description = "The ID of the movie to return.", required = true, schema = @Schema(allowableValues = {}, minimum = "1"
    )) @PathVariable("movieId") Integer movieId) {
        try {
            Optional<Movie> movie = movieService.getMovieById(movieId);
            return new ResponseEntity<Movie>(movie.get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<Movie>> cinemaCinemaIdMovieTheaterTheaterIdShowsShowIdMoviesGet(@Min(1) @Parameter(in = ParameterIn.PATH, description = "The ID of the cinema to return.", required = true, schema = @Schema(allowableValues = {}, minimum = "1"
    )) @PathVariable("cinemaId") Integer cinemaId, @Min(1) @Parameter(in = ParameterIn.PATH, description = "The ID of the movie theater to return.", required = true, schema = @Schema(allowableValues = {}, minimum = "1"
    )) @PathVariable("theaterId") Integer theaterId, @Min(1) @Parameter(in = ParameterIn.PATH, description = "The ID of the movie theater to return.", required = true, schema = @Schema(allowableValues = {}, minimum = "1"
    )) @PathVariable("showId") Integer showId) {
        try {
            List<Integer> moviesId = new ArrayList<>();
            List<Show> shows = showService.getAllShowsByCinemaAndTheaterId(cinemaId, theaterId);
            for (Show show : shows) {
                if (show.getId().equals(showId)) {
                    moviesId.add(show.getMovieId());
                }
            }
            List<Movie> movies = new ArrayList<>();
            for (Integer mov : moviesId) {
                movies.add(movieService.getMovieById(mov).get());
            }
            return new ResponseEntity<>(movies, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Movie> cinemaCinemaIdMovieTheaterTheaterIdShowsShowIdMoviesMovieIdGet(@Min(1) @Parameter(in = ParameterIn.PATH, description = "The ID of the cinema to return.", required = true, schema = @Schema(allowableValues = {}, minimum = "1"
    )) @PathVariable("cinemaId") Integer cinemaId, @Min(1) @Parameter(in = ParameterIn.PATH, description = "The ID of the movie to return.", required = true, schema = @Schema(allowableValues = {}, minimum = "1"
    )) @PathVariable("movieId") Integer movieId, @Min(1) @Parameter(in = ParameterIn.PATH, description = "The ID of the movie theater to return.", required = true, schema = @Schema(allowableValues = {}, minimum = "1"
    )) @PathVariable("theaterId") Integer theaterId, @Min(1) @Parameter(in = ParameterIn.PATH, description = "The ID of the movie theater shows to return.", required = true, schema = @Schema(allowableValues = {}, minimum = "1"
    )) @PathVariable("showId") Integer showId) {
        List<Integer> moviesId = new ArrayList<>();
        List<Show> shows = showService.getAllShowsByCinemaAndTheaterId(cinemaId, theaterId);
        for (Show show : shows) {
            if (show.getId().equals(showId)) {
                moviesId.add(show.getMovieId());
            }
        }
        for (Integer mov : moviesId) {
            if (mov.equals(movieId)) {
                Movie movie = movieService.getMovieById(mov).get();
                return new ResponseEntity<>(movie, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
