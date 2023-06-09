/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.44).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.example.screenspace.controller;

import com.example.screenspace.model.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.processing.Generated;
import javax.validation.Valid;

@Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-05-25T13:49:06.606500-03:00[America/Argentina/Buenos_Aires]")
@Validated
public interface AuthApi {

    @Operation(summary = "Login with a google account", description = "", tags={ "Login" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "User login succesful"),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))) })
    @RequestMapping(value = "/login/google",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Void> loginGooglePost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody User body);


    @Operation(summary = "Login with a created user", description = "", tags={ "Login" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "User login succesful"),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))) })
    @RequestMapping(value = "/login",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<User> loginPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody User body);


    @Operation(summary = "Reset password", description = "", tags={ "Password Reset" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User created") })
    @RequestMapping(value = "/password/reset/new",
            consumes = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<Void> passwordResetNewPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody User body);


    @Operation(summary = "Request of email to change password", description = "", tags={ "Password Reset" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User created") })
    @RequestMapping(value = "/password/reset",
            consumes = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<Void> passwordResetPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=false, hidden = true, schema=@Schema()) @Valid @RequestBody(required = false) User body);


}

