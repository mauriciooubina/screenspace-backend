package com.example.screenspace.controller;

import com.example.screenspace.model.Review;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-05-25T13:49:06.606500-03:00[America/Argentina/Buenos_Aires]")
@RestController
public class MoviesApiController implements MoviesApi {

    private static final Logger log = LoggerFactory.getLogger(MoviesApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public MoviesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<Review>> moviesMovieIdReviewsGet(@Min(1)@Parameter(in = ParameterIn.PATH, description = "The ID of the movie to return.", required=true, schema=@Schema(allowableValues={  }, minimum="1"
)) @PathVariable("movieId") Integer movieId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Review>>(objectMapper.readValue("[ {\n  \"rating\" : 7,\n  \"movieID\" : 3,\n  \"id\" : 11,\n  \"userId\" : 1,\n  \"opinion\" : \"Muy buena la pelicula pero larga\"\n}, {\n  \"rating\" : 7,\n  \"movieID\" : 3,\n  \"id\" : 11,\n  \"userId\" : 1,\n  \"opinion\" : \"Muy buena la pelicula pero larga\"\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Review>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Review>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> moviesMovieIdReviewsPost(@Min(1)@Parameter(in = ParameterIn.PATH, description = "The ID of the movie to return.", required=true, schema=@Schema(allowableValues={  }, minimum="1"
)) @PathVariable("movieId") Integer movieId,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Review body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
