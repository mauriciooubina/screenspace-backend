package com.example.screenspace.controller;

import com.example.screenspace.model.Cinema;
import com.example.screenspace.model.Movie;
import com.example.screenspace.model.MovieTheater;
import com.example.screenspace.model.Show;
import com.example.screenspace.service.CinemaService;
import com.example.screenspace.service.MovieTheaterService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.processing.Generated;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-05-25T13:49:06.606500-03:00[America/Argentina/Buenos_Aires]")
@RestController
public class MovieTheaterApiController implements MovieTheaterApi {

    private static final Logger log = LoggerFactory.getLogger(MovieTheaterApiController.class);
    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;
    private final MovieTheaterService movieTheaterService;

    @Autowired
    public MovieTheaterApiController(ObjectMapper objectMapper, HttpServletRequest request, MovieTheaterService movieTheaterService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.movieTheaterService = movieTheaterService;
    }

    public ResponseEntity<List<MovieTheater>> cinemaCinemaIdMovieTheaterGet(@Min(1) @Parameter(in = ParameterIn.PATH, description = "The ID of the cinema to return.", required = true, schema = @Schema(allowableValues = {}, minimum = "1"
    )) @PathVariable("cinemaId") Integer cinemaId) {
        try {
            List<MovieTheater> movieTheaters = movieTheaterService.getAllMovieTheatersFromCinemaId(cinemaId);
            return new ResponseEntity<>(movieTheaters, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<MovieTheater> cinemaCinemaIdMovieTheaterTheaterIdGet(@Min(1) @Parameter(in = ParameterIn.PATH, description = "The ID of the movie theater to return.", required = true, schema = @Schema(allowableValues = {}, minimum = "1"
    )) @PathVariable("theaterId") Integer theaterId, @Min(1) @Parameter(in = ParameterIn.PATH, description = "The ID of the cinema to return.", required = true, schema = @Schema(allowableValues = {}, minimum = "1"
    )) @PathVariable("cinemaId") Integer cinemaId) {
        List<MovieTheater> movieTheaters = movieTheaterService.getAllMovieTheatersFromCinemaId(cinemaId);
        for (MovieTheater movieTheater : movieTheaters) {
            if (movieTheater.getId().equals(theaterId)) {
                return new ResponseEntity<>(movieTheater, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<MovieTheater> cinemaCinemaIdMovieTheaterPost(@Min(1) @Parameter(in = ParameterIn.PATH, description = "The ID of the cinema to return.", required = true, schema = @Schema(allowableValues = {}, minimum = "1"))
                                                                       @PathVariable("cinemaId") Integer cinemaId, @Valid @RequestBody MovieTheater body) {
        try {
            MovieTheater movieTheater = new MovieTheater();
            movieTheater.setCinemaID(cinemaId);
            movieTheater.setName(body.getName());
            movieTheater.setRows(body.getRows());
            movieTheater.setColumns(body.getColumns());
            movieTheater.setPrice(body.getPrice());
            movieTheater.setTemporalyClosed(body.isTemporalyClosed());
            movieTheaterService.createMovieTheater(movieTheater);
            return new ResponseEntity<>(movieTheater, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    public ResponseEntity<MovieTheater> cinemaCinemaIdMovieTheaterTheaterIdPut(@Min(1) @Parameter(in = ParameterIn.PATH, description = "The ID of the movie theater to return.", required = true, schema = @Schema(allowableValues = {}, minimum = "1"))
    @PathVariable("theaterId") Integer theaterId, @Min(1) @Parameter(in = ParameterIn.PATH, description = "The ID of the cinema to return.", required = true, schema = @Schema(allowableValues = {}, minimum = "1"))
    @PathVariable("cinemaId") Integer cinemaId,@RequestBody MovieTheater body) {
        try {
            MovieTheater movieTheater = movieTheaterService.getMovieTheaterById(theaterId).get();
            movieTheater.setCinemaID(cinemaId);
            movieTheater.setName(body.getName());
            movieTheater.setRows(body.getRows());
            movieTheater.setColumns(body.getColumns());
            movieTheater.setPrice(body.getPrice());
            movieTheater.setTemporalyClosed(body.isTemporalyClosed());
            movieTheaterService.updateMovieTheater(theaterId, movieTheater);
            return new ResponseEntity<>(movieTheater, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<MovieTheater> cinemaCinemaIdMovieTheaterTheaterIdDelete(@Min(1) @Parameter(in = ParameterIn.PATH, description = "The ID of the movie theater to return.", required = true, schema = @Schema(allowableValues = {}, minimum = "1"
    )) @PathVariable("theaterId") Integer theaterId, @Min(1) @Parameter(in = ParameterIn.PATH, description = "The ID of the cinema to return.", required = true, schema = @Schema(allowableValues = {}, minimum = "1"
    )) @PathVariable("cinemaId") Integer cinemaId) {
        List<MovieTheater> movieTheaters = movieTheaterService.getAllMovieTheatersFromCinemaId(cinemaId);
        for (MovieTheater movieTheater : movieTheaters) {
            if (movieTheater.getId().equals(theaterId)) {
                MovieTheater movieTheater1 = movieTheater;
                movieTheaterService.deleteMovieTheater(movieTheater.getId());
                return new ResponseEntity<>(movieTheater1, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
