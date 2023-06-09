package com.example.screenspace.controller;

import com.example.screenspace.model.*;
import com.example.screenspace.service.CinemaService;
import com.example.screenspace.service.MovieService;
import com.example.screenspace.service.ShowsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.processing.Generated;
import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-05-25T13:49:06.606500-03:00[America/Argentina/Buenos_Aires]")
@RestController
public class CinemaApiController implements CinemaApi {

    private static final Logger log = LoggerFactory.getLogger(CinemaApiController.class);
    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;
    private final CinemaService cinemaService;
    private final MovieService movieService;
    private final ShowsService showsService;

    @Autowired
    public CinemaApiController(ObjectMapper objectMapper, HttpServletRequest request, CinemaService cinemaService, MovieService movieService, ShowsService showsService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.cinemaService = cinemaService;
        this.movieService = movieService;
        this.showsService = showsService;
    }

    public ResponseEntity<List<Cinema>> cinemaGet(@RequestParam(required = false) Integer userId) {
        try {
            List<Cinema> cinemas = cinemaService.getAllCinemas();
            if(userId != null){
                List<Cinema> userCinemas = cinemas.stream().filter(cinema -> cinema.getUserId().equals(userId))
                        .collect(Collectors.toList());
                return new ResponseEntity<>(userCinemas, HttpStatus.OK);
            }
            return new ResponseEntity<>(cinemas, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Cinema> cinemaCinemaIdGet(@Min(1) @Parameter(in = ParameterIn.PATH, description = "The ID of the cinema to return.", required = true, schema = @Schema(allowableValues = {}, minimum = "1"
    )) @PathVariable("cinemaId") Integer cinemaId) {
        try {
            Optional<Cinema> cinema = cinemaService.getCinemaById(cinemaId);
            return new ResponseEntity<Cinema>(cinema.get(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    public ResponseEntity<Cinema> cinemaPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody Cinema body) {
        Cinema cinema = new Cinema();
        cinema.setName(body.getName());
        cinema.setAdress(body.getAdress());
        cinema.setAdressNumber(body.getAdressNumber());
        cinema.setNeighborhood(body.getNeighborhood());
        cinema.setLocation(body.getLocation());
        cinema.setCity(body.getCity());
        cinema.setCountry(body.getCountry());
        cinema.setLatitude(body.getLatitude());
        cinema.setLongitude(body.getLongitude());
        cinema.setCompany(body.getCompany());
        cinema.setUserId(body.getUserId());
        cinemaService.createCinema(cinema);
        return new ResponseEntity<>(cinema, HttpStatus.CREATED);
    }

    public ResponseEntity<Cinema> cinemaCinemaIdPut(@Min(1) @Parameter(in = ParameterIn.PATH, description = "The ID of the cinema to return.", required = true, schema = @Schema(allowableValues = {}, minimum = "1")) @PathVariable("cinemaId") Integer cinemaId,
    @Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody Cinema body) {
        Cinema cinema = cinemaService.getCinemaById(cinemaId).get();
        if(cinema == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        cinema.setName(body.getName());
        cinema.setAdress(body.getAdress());
        cinema.setAdressNumber(body.getAdressNumber());
        cinema.setNeighborhood(body.getNeighborhood());
        cinema.setLocation(body.getLocation());
        cinema.setCity(body.getCity());
        cinema.setCountry(body.getCountry());
        cinema.setLatitude(body.getLatitude());
        cinema.setLongitude(body.getLongitude());
        cinema.setCompany(body.getCompany());
        cinema.setUserId(body.getUserId());
        cinemaService.updateCinema(cinemaId, cinema);
        return new ResponseEntity<>(cinema, HttpStatus.OK);
    }


    public ResponseEntity<Cinema> cinemaCinemaIdDelete(@Min(1) @Parameter(in = ParameterIn.PATH, description = "The ID of the cinema to return.", required = true, schema = @Schema(allowableValues = {}, minimum = "1"
    )) @PathVariable("cinemaId") Integer cinemaId) {
        Optional<Cinema> user = cinemaService.getCinemaById(cinemaId);
        if (user != null) {
            cinemaService.deleteCinema(cinemaId);
            return new ResponseEntity<Cinema>(user.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<List<Cinema>> movieMovieIdCinemasGet(@Min(1) @Parameter(in = ParameterIn.PATH, description = "The ID of the movie to return.", required = true, schema = @Schema(allowableValues = {}, minimum = "1"
    )) @PathVariable("movieId") Integer movieId) {
        List<Integer> cinemasId = new ArrayList<>();
        List<Cinema> cinemas = new ArrayList<>();
        List<Shows> shows = showsService.getAllShows();
        for(Shows show : shows){
            if(show.getMovieId().equals(movieId)){
                cinemasId.add(show.getCinemaId());
            }
        }
        for(Integer id : cinemasId){
            Cinema cinema = cinemaService.getCinemaById(id).get();
            cinemas.add(cinema);
        }
        return new ResponseEntity<>(cinemas, HttpStatus.OK);
    }

}
