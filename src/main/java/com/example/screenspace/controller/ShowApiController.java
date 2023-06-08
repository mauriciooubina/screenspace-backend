package com.example.screenspace.controller;

import com.example.screenspace.model.Cinema;
import com.example.screenspace.model.Movie;
import com.example.screenspace.model.Show;
import com.example.screenspace.service.CinemaService;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.processing.Generated;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.io.IOException;
import java.util.List;

@Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-05-25T13:49:06.606500-03:00[America/Argentina/Buenos_Aires]")
@RestController
public class ShowApiController implements ShowApi {

    private static final Logger log = LoggerFactory.getLogger(ShowApiController.class);
    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;
    private final ShowService showService;

    @Autowired
    public ShowApiController(ObjectMapper objectMapper, HttpServletRequest request, ShowService showService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.showService = showService;
    }


    public ResponseEntity<List<Show>> cinemaCinemaIdMovieTheaterTheaterIdShowsGet(@Min(1) @Parameter(in = ParameterIn.PATH, description = "The ID of the cinema to return.", required = true, schema = @Schema(allowableValues = {}, minimum = "1"
    )) @PathVariable("cinemaId") Integer cinemaId, @Min(1) @Parameter(in = ParameterIn.PATH, description = "The ID of the movie theater to return.", required = true, schema = @Schema(allowableValues = {}, minimum = "1"
    )) @PathVariable("theaterId") Integer theaterId) {
        try {
            List<Show> shows = showService.getAllShowsByCinemaAndTheaterId(cinemaId, theaterId);
            return new ResponseEntity<List<Show>>(shows, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<Show>>(HttpStatus.NOT_FOUND);
        }
    }


    public ResponseEntity<Show> cinemaCinemaIdMovieTheaterTheaterIdShowsShowIdGet(@Min(1) @Parameter(in = ParameterIn.PATH, description = "The ID of the cinema to return.", required = true, schema = @Schema(allowableValues = {}, minimum = "1"
    )) @PathVariable("cinemaId") Integer cinemaId, @Min(1) @Parameter(in = ParameterIn.PATH, description = "The ID of the movie theater to return.", required = true, schema = @Schema(allowableValues = {}, minimum = "1"
    )) @PathVariable("theaterId") Integer theaterId, @Min(1) @Parameter(in = ParameterIn.PATH, description = "The ID of the show of a movie theater to return.", required = true, schema = @Schema(allowableValues = {}, minimum = "1"
    )) @PathVariable("showId") Integer showId) {
        List<Show> shows = showService.getAllShowsByCinemaAndTheaterId(cinemaId, theaterId);
        for (Show show : shows) {
            if (show.getId().equals(showId)) {
                return new ResponseEntity<>(show, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Show> cinemaCinemaIdMovieTheaterTheaterIdShowsPost(@Min(1) @Parameter(in = ParameterIn.PATH, description = "The ID of the cinema to return.", required = true, schema = @Schema(allowableValues = {}, minimum = "1"
    )) @PathVariable("cinemaId") Integer cinemaId, @Min(1) @Parameter(in = ParameterIn.PATH, description = "The ID of the movie theater to return.", required = true, schema = @Schema(allowableValues = {}, minimum = "1"
    )) @PathVariable("theaterId") Integer theaterId, @Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody Show body) {
        Show show = new Show();
        show.setCinemaID(cinemaId);
        show.setTheaterId(theaterId);
        show.setDate(body.getDate());
        show.setTime(body.getTime());
        show.setMovieId(body.getMovieId());
        show.setSeats(body.getSeats());
        showService.createShow(show);
        return new ResponseEntity<>(show, HttpStatus.CREATED);
    }


    public ResponseEntity<Show> cinemaCinemaIdMovieTheaterTheaterIdShowsShowIdPut(@Min(1) @Parameter(in = ParameterIn.PATH, description = "The ID of the cinema to return.", required = true, schema = @Schema(allowableValues = {}, minimum = "1"))
    @PathVariable("cinemaId") Integer cinemaId, @Min(1) @Parameter(in = ParameterIn.PATH, description = "The ID of the movie theater to return.", required = true, schema = @Schema(allowableValues = {}, minimum = "1"))
    @PathVariable("theaterId") Integer theaterId, @Min(1) @Parameter(in = ParameterIn.PATH, description = "The ID of the show of a movie theater to return.", required = true, schema = @Schema(allowableValues = {}, minimum = "1"))
    @PathVariable("showId") Integer showId, @RequestBody Show body)  {
        Show show = showService.getShowById(showId).get();
        show.setCinemaID(cinemaId);
        show.setTheaterId(theaterId);
        show.setDate(body.getDate());
        show.setTime(body.getTime());
        show.setMovieId(body.getMovieId());
        show.setSeats(body.getSeats());
        showService.updateShow(show.getId(), show);
        return new ResponseEntity<>(show, HttpStatus.OK);
    }

    public ResponseEntity<Show> cinemaCinemaIdMovieTheaterTheaterIdShowsShowIdDelete(@Min(1) @Parameter(in = ParameterIn.PATH, description = "The ID of the cinema to return.", required = true, schema = @Schema(allowableValues = {}, minimum = "1"
    )) @PathVariable("cinemaId") Integer cinemaId, @Min(1) @Parameter(in = ParameterIn.PATH, description = "The ID of the movie theater to return.", required = true, schema = @Schema(allowableValues = {}, minimum = "1"
    )) @PathVariable("theaterId") Integer theaterId, @Min(1) @Parameter(in = ParameterIn.PATH, description = "The ID of the show of a movie theater to return.", required = true, schema = @Schema(allowableValues = {}, minimum = "1"
    )) @PathVariable("showId") Integer showId) {
        try {
            Show show = showService.getShowById(showId).get();
            showService.deleteShow(showId);
            return new ResponseEntity<>(show, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    public ResponseEntity<List<Show>> movieMovieIdCinemasCinemaIdShowsGet(@Min(1) @Parameter(in = ParameterIn.PATH, description = "The ID of the movie to return.", required = true, schema = @Schema(allowableValues = {}, minimum = "1"
    )) @PathVariable("movieId") Integer movieId, @Min(1) @Parameter(in = ParameterIn.PATH, description = "The ID of the cinema to return.", required = true, schema = @Schema(allowableValues = {}, minimum = "1"
    )) @PathVariable("cinemaId") Integer cinemaId) {
        try {
            List<Show> shows = showService.getAllShowsByMovieAndCinemaId(movieId, cinemaId);
            return new ResponseEntity<List<Show>>(shows, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<Show>>(HttpStatus.NOT_FOUND);
        }
    }


}
