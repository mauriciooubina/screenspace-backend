package com.example.screenspace.controller;

import com.example.screenspace.model.User;
import com.example.screenspace.service.UsersService;
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
import java.util.Optional;

@Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-05-25T13:49:06.606500-03:00[America/Argentina/Buenos_Aires]")
@RestController
public class UsersApiController implements UsersApi {

    private static final Logger log = LoggerFactory.getLogger(UsersApiController.class);
    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;
    private final UsersService usersService;

    @Autowired
    public UsersApiController(ObjectMapper objectMapper, HttpServletRequest request, UsersService usersService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.usersService = usersService;
    }

    public ResponseEntity<List<User>> usersGet() {
        try {
            List<User> users = usersService.getAllUsers();
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<User> usersUserIdGet(@Min(1) @Parameter(in = ParameterIn.PATH, description = "The ID of the user to return.", required = true, schema = @Schema(allowableValues = {}, minimum = "1"
    )) @PathVariable("userId") Integer userId) {
        try {
            Optional<User> user = usersService.getUserById(userId);
            return new ResponseEntity<User>(user.get(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Void> usersPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody User body) {
        try {
            String email = body.getEmail();
            if (usersService.getUserByEmail(email) != null) {
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
            User newUser = new User();
            newUser.setEmail(email);
            newUser.setPassword(body.getPassword());
            usersService.createUser(newUser);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    public ResponseEntity<User> usersUserIdPut(@Min(1) @Parameter(in = ParameterIn.PATH, description = "The ID of the user to return.", required = true, schema = @Schema(allowableValues = {}, minimum = "1")) @PathVariable("userId") Integer userId,
        @Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody User body) {
        Optional<User> optionalUser = usersService.getUserById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setEmail(body.getEmail());
            user.setPassword(body.getPassword());
            usersService.updateUser(user.getId(), user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<User> usersUserIdDelete(@Min(1) @Parameter(in = ParameterIn.PATH, description = "The ID of the user to return.", required = true, schema = @Schema(allowableValues = {}, minimum = "1"
    )) @PathVariable("userId") Integer userId) {
        Optional<User> user = usersService.getUserById(userId);
        if (user != null) {
            usersService.deleteUser(userId);
            return new ResponseEntity<User>(user.get(), HttpStatus.OK);
        }
        return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
