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

    public ResponseEntity<List<MovieTheater>> cinemaCinemaIdMovieTheaterGet(@Min(1)@Parameter(in = ParameterIn.PATH, description = "The ID of the cinema to return.", required=true, schema=@Schema(allowableValues={  }, minimum="1"
    )) @PathVariable("cinemaId") Integer cinemaId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<MovieTheater>>(objectMapper.readValue("[ {\n  \"temporalyClosed\" : false,\n  \"cinemaID\" : 1,\n  \"columns\" : 8,\n  \"price\" : 500,\n  \"name\" : \"Sala 01 Multiplex Belgrano\",\n  \"id\" : 11,\n  \"rows\" : 8\n}, {\n  \"temporalyClosed\" : false,\n  \"cinemaID\" : 1,\n  \"columns\" : 8,\n  \"price\" : 500,\n  \"name\" : \"Sala 01 Multiplex Belgrano\",\n  \"id\" : 11,\n  \"rows\" : 8\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<MovieTheater>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<MovieTheater>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<MovieTheater> cinemaCinemaIdMovieTheaterTheaterIdGet(@Min(1)@Parameter(in = ParameterIn.PATH, description = "The ID of the movie theater to return.", required=true, schema=@Schema(allowableValues={  }, minimum="1"
    )) @PathVariable("theaterId") Integer theaterId,@Min(1)@Parameter(in = ParameterIn.PATH, description = "The ID of the cinema to return.", required=true, schema=@Schema(allowableValues={  }, minimum="1"
    )) @PathVariable("cinemaId") Integer cinemaId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<MovieTheater>(objectMapper.readValue("{\n  \"temporalyClosed\" : false,\n  \"cinemaID\" : 1,\n  \"columns\" : 8,\n  \"price\" : 500,\n  \"name\" : \"Sala 01 Multiplex Belgrano\",\n  \"id\" : 11,\n  \"rows\" : 8\n}", MovieTheater.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<MovieTheater>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<MovieTheater>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<MovieTheater> cinemaCinemaIdMovieTheaterPost(@Min(1)@Parameter(in = ParameterIn.PATH, description = "The ID of the cinema to return.", required=true, schema=@Schema(allowableValues={  }, minimum="1"
    )) @PathVariable("cinemaId") Integer cinemaId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<MovieTheater>(objectMapper.readValue("{\n  \"temporalyClosed\" : false,\n  \"cinemaID\" : 1,\n  \"columns\" : 8,\n  \"price\" : 500,\n  \"name\" : \"Sala 01 Multiplex Belgrano\",\n  \"id\" : 11,\n  \"rows\" : 8\n}", MovieTheater.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<MovieTheater>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<MovieTheater>(HttpStatus.NOT_IMPLEMENTED);
    }



    public ResponseEntity<MovieTheater> cinemaCinemaIdMovieTheaterTheaterIdPut(@Min(1)@Parameter(in = ParameterIn.PATH, description = "The ID of the movie theater to return.", required=true, schema=@Schema(allowableValues={  }, minimum="1"
    )) @PathVariable("theaterId") Integer theaterId,@Min(1)@Parameter(in = ParameterIn.PATH, description = "The ID of the cinema to return.", required=true, schema=@Schema(allowableValues={  }, minimum="1"
    )) @PathVariable("cinemaId") Integer cinemaId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<MovieTheater>(objectMapper.readValue("{\n  \"temporalyClosed\" : false,\n  \"cinemaID\" : 1,\n  \"columns\" : 8,\n  \"price\" : 500,\n  \"name\" : \"Sala 01 Multiplex Belgrano\",\n  \"id\" : 11,\n  \"rows\" : 8\n}", MovieTheater.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<MovieTheater>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<MovieTheater>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<MovieTheater> cinemaCinemaIdMovieTheaterTheaterIdDelete(@Min(1)@Parameter(in = ParameterIn.PATH, description = "The ID of the movie theater to return.", required=true, schema=@Schema(allowableValues={  }, minimum="1"
    )) @PathVariable("theaterId") Integer theaterId,@Min(1)@Parameter(in = ParameterIn.PATH, description = "The ID of the cinema to return.", required=true, schema=@Schema(allowableValues={  }, minimum="1"
    )) @PathVariable("cinemaId") Integer cinemaId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<MovieTheater>(objectMapper.readValue("{\n  \"temporalyClosed\" : false,\n  \"cinemaID\" : 1,\n  \"columns\" : 8,\n  \"price\" : 500,\n  \"name\" : \"Sala 01 Multiplex Belgrano\",\n  \"id\" : 11,\n  \"rows\" : 8\n}", MovieTheater.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<MovieTheater>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<MovieTheater>(HttpStatus.NOT_IMPLEMENTED);
    }


}
