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
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.processing.Generated;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;

@Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-05-25T13:49:06.606500-03:00[America/Argentina/Buenos_Aires]")
@RestController
public class AuthApiController implements AuthApi {

    private static final Logger log = LoggerFactory.getLogger(AuthApiController.class);
    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;
    private final UsersService usersService;

    @Autowired
    public AuthApiController(ObjectMapper objectMapper, HttpServletRequest request, UsersService usersService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.usersService = usersService;
    }

    public ResponseEntity<Void> loginGooglePost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody User body) {
        String email = body.getEmail();
        String pass = body.getPassword();
        User user = usersService.getUserByEmailAndPass(email, pass);
        if(user != null){
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }
        return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
    }

    public ResponseEntity<Void> loginPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody User body) {
        String email = body.getEmail();
        String pass = body.getPassword();
        User user = usersService.getUserByEmailAndPass(email, pass);
        if(user != null){
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }
        return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
    }

    public ResponseEntity<Void> passwordResetNewPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody User body) {
        String email = body.getEmail();
        String pass = body.getPassword();
        User user = usersService.getUserByEmail(email);
        if(user == null){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        user.setPassword(pass);
        usersService.updateUser(user.getId(), user);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> passwordResetPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=false, hidden = true, schema=@Schema()) @Valid @RequestBody(required = false) User body) {
        String email = body.getEmail();
        User user = usersService.getUserByEmail(email);
        if(user != null){
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

}
