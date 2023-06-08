package com.example.screenspace.controller;

import com.example.screenspace.model.Book;
import com.example.screenspace.model.Movie;
import com.example.screenspace.model.User;
import com.example.screenspace.repository.BookRepository;
import com.example.screenspace.service.BookService;
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
public class BookApiController implements BookApi {

    private static final Logger log = LoggerFactory.getLogger(BookApiController.class);
    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;
    private final BookService bookService;

    @Autowired
    public BookApiController(ObjectMapper objectMapper, HttpServletRequest request, BookService bookService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.bookService = bookService;
    }


    public ResponseEntity<String> movieMovieIdCinemasCinemaIdShowsShowIdBookPost(@Min(1)@Parameter(in = ParameterIn.PATH, description = "The ID of the movie to return.", required=true, schema=@Schema(allowableValues={  }, minimum="1"
    )) @PathVariable("movieId") Integer movieId,@Min(1)@Parameter(in = ParameterIn.PATH, description = "The ID of the cinema to return.", required=true, schema=@Schema(allowableValues={  }, minimum="1"
    )) @PathVariable("cinemaId") Integer cinemaId,@Min(1)@Parameter(in = ParameterIn.PATH, description = "The ID of the show to return.", required=true, schema=@Schema(allowableValues={  }, minimum="1"
    )) @PathVariable("showId") Integer showId,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Book body) {
        try {
            Book book = new Book();
            book.setMovieId(movieId);
            book.setCinemaId(cinemaId);
            book.setShowId(showId);
            book.setUserId(body.getUserId());
            book.setDate(body.getDate());
            book.setTime(body.getTime());
            book.setTickets(body.getTickets());
            book.setSeats(body.getSeats());
            bookService.createBook(book);
            return new ResponseEntity<>("{\n" +
                    "  \"message\": \"Booking ticket successful\"\n" +
                    "}", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
