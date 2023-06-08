package com.example.screenspace.controller;

import com.example.screenspace.model.Movie;
import com.example.screenspace.model.Review;
import com.example.screenspace.service.MovieService;
import com.example.screenspace.service.ReviewService;
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
import java.util.List;

@Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-05-25T13:49:06.606500-03:00[America/Argentina/Buenos_Aires]")
@RestController
public class ReviewApiController implements ReviewApi {

    private static final Logger log = LoggerFactory.getLogger(ReviewApiController.class);
    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;
    private final ReviewService reviewService;
    private final MovieService movieService;

    @Autowired
    public ReviewApiController(ObjectMapper objectMapper, HttpServletRequest request, ReviewService reviewService, MovieService movieService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.reviewService = reviewService;
        this.movieService = movieService;
    }

    public ResponseEntity<List<Review>> moviesMovieIdReviewsGet(@Min(1)@Parameter(in = ParameterIn.PATH, description = "The ID of the movie to return.", required=true, schema=@Schema(allowableValues={  }, minimum="1"
)) @PathVariable("movieId") Integer movieId) {
        Movie movie = movieService.getMovieById(movieId).get();
        List<Review> reviews = reviewService.getReviewsFromMovieId(movieId);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    public ResponseEntity<Void> moviesMovieIdReviewsPost(@Min(1)@Parameter(in = ParameterIn.PATH, description = "The ID of the movie to return.", required=true, schema=@Schema(allowableValues={  }, minimum="1"
)) @PathVariable("movieId") Integer movieId,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Review body) {
        Review review = new Review();
        review.setMovieId(movieId);
        review.setOpinion(body.getOpinion());
        review.setRating(body.getRating());
        review.setUserId(body.getUserId());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
