package com.example.screenspace.controller;

import com.example.screenspace.model.Shows;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.processing.Generated;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;

@Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-05-25T13:49:06.606500-03:00[America/Argentina/Buenos_Aires]")
@RestController
public class ShowsApiController implements ShowsApi {

    private static final Logger log = LoggerFactory.getLogger(ShowsApiController.class);
    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;
    private final ShowsService showsService;

    @Autowired
    public ShowsApiController(ObjectMapper objectMapper, HttpServletRequest request, ShowsService showsService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.showsService = showsService;
    }


    public ResponseEntity<List<Shows>> cinemaCinemaIdMovieTheaterTheaterIdShowsGet(@Min(1) @Parameter(in = ParameterIn.PATH, description = "The ID of the cinema to return.", required = true, schema = @Schema(allowableValues = {}, minimum = "1"
    )) @PathVariable("cinemaId") Integer cinemaId, @Min(1) @Parameter(in = ParameterIn.PATH, description = "The ID of the movie theater to return.", required = true, schema = @Schema(allowableValues = {}, minimum = "1"
    )) @PathVariable("theaterId") Integer theaterId) {
        try {
            List<Shows> showsList = showsService.getAllShows();
            List<Shows> shows = showsList.stream().filter(s -> s.getCinemaId().equals(cinemaId) && s.getTheaterId().equals(theaterId))
                    .collect(Collectors.toList());
            return new ResponseEntity<List<Shows>>(shows, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<Shows>>(HttpStatus.NOT_FOUND);
        }
    }


    public ResponseEntity<Shows> cinemaCinemaIdMovieTheaterTheaterIdShowsShowIdGet(@Min(1) @Parameter(in = ParameterIn.PATH, description = "The ID of the cinema to return.", required = true, schema = @Schema(allowableValues = {}, minimum = "1"
    )) @PathVariable("cinemaId") Integer cinemaId, @Min(1) @Parameter(in = ParameterIn.PATH, description = "The ID of the movie theater to return.", required = true, schema = @Schema(allowableValues = {}, minimum = "1"
    )) @PathVariable("theaterId") Integer theaterId, @Min(1) @Parameter(in = ParameterIn.PATH, description = "The ID of the show of a movie theater to return.", required = true, schema = @Schema(allowableValues = {}, minimum = "1"
    )) @PathVariable("showId") Integer showId) {
        List<Shows> shows = showsService.getAllShowsByCinemaAndTheaterId(cinemaId, theaterId);
        for (Shows show : shows) {
            if (show.getId().equals(showId)) {
                return new ResponseEntity<>(show, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Shows> cinemaCinemaIdMovieTheaterTheaterIdShowsPost(@Min(1) @Parameter(in = ParameterIn.PATH, description = "The ID of the cinema to return.", required = true, schema = @Schema(allowableValues = {}, minimum = "1"
    )) @PathVariable("cinemaId") Integer cinemaId, @Min(1) @Parameter(in = ParameterIn.PATH, description = "The ID of the movie theater to return.", required = true, schema = @Schema(allowableValues = {}, minimum = "1"
    )) @PathVariable("theaterId") Integer theaterId, @Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody Shows body) {
        Shows shows = new Shows();
        shows.setCinemaId(cinemaId);
        shows.setTheaterId(theaterId);
        shows.setDate(body.getDate());
        shows.setTime(body.getTime());
        shows.setMovieId(body.getMovieId());
        shows.setSeats(body.getSeats());
        showsService.createShow(shows);
        return new ResponseEntity<>(shows, HttpStatus.CREATED);
    }


    public ResponseEntity<Shows> cinemaCinemaIdMovieTheaterTheaterIdShowsShowIdPut(@Min(1) @Parameter(in = ParameterIn.PATH, description = "The ID of the cinema to return.", required = true, schema = @Schema(allowableValues = {}, minimum = "1"))
    @PathVariable("cinemaId") Integer cinemaId, @Min(1) @Parameter(in = ParameterIn.PATH, description = "The ID of the movie theater to return.", required = true, schema = @Schema(allowableValues = {}, minimum = "1"))
    @PathVariable("theaterId") Integer theaterId, @Min(1) @Parameter(in = ParameterIn.PATH, description = "The ID of the show of a movie theater to return.", required = true, schema = @Schema(allowableValues = {}, minimum = "1"))
    @PathVariable("showId") Integer showId, @RequestBody Shows body)  {
        Shows shows = showsService.getShowById(showId).get();
        shows.setCinemaId(cinemaId);
        shows.setTheaterId(theaterId);
        shows.setDate(body.getDate());
        shows.setTime(body.getTime());
        shows.setMovieId(body.getMovieId());
        shows.setSeats(body.getSeats());
        showsService.updateShow(shows.getId(), shows);
        return new ResponseEntity<>(shows, HttpStatus.OK);
    }

    public ResponseEntity<Shows> cinemaCinemaIdMovieTheaterTheaterIdShowsShowIdDelete(@Min(1) @Parameter(in = ParameterIn.PATH, description = "The ID of the cinema to return.", required = true, schema = @Schema(allowableValues = {}, minimum = "1"
    )) @PathVariable("cinemaId") Integer cinemaId, @Min(1) @Parameter(in = ParameterIn.PATH, description = "The ID of the movie theater to return.", required = true, schema = @Schema(allowableValues = {}, minimum = "1"
    )) @PathVariable("theaterId") Integer theaterId, @Min(1) @Parameter(in = ParameterIn.PATH, description = "The ID of the show of a movie theater to return.", required = true, schema = @Schema(allowableValues = {}, minimum = "1"
    )) @PathVariable("showId") Integer showId) {
        try {
            Shows shows = showsService.getShowById(showId).get();
            showsService.deleteShow(showId);
            return new ResponseEntity<>(shows, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    public ResponseEntity<List<Shows>> movieMovieIdCinemasCinemaIdShowsGet(@Min(1) @Parameter(in = ParameterIn.PATH, description = "The ID of the movie to return.", required = true, schema = @Schema(allowableValues = {}, minimum = "1"
    )) @PathVariable("movieId") Integer movieId, @Min(1) @Parameter(in = ParameterIn.PATH, description = "The ID of the cinema to return.", required = true, schema = @Schema(allowableValues = {}, minimum = "1"
    )) @PathVariable("cinemaId") Integer cinemaId) {
        try {
            List<Shows> shows = showsService.getAllShowsByMovieAndCinemaId(movieId, cinemaId);
            return new ResponseEntity<List<Shows>>(shows, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<Shows>>(HttpStatus.NOT_FOUND);
        }
    }


}
