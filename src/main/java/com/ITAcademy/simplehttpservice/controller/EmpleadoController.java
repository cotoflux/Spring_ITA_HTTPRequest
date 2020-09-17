package com.ITAcademy.simplehttpservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ITAcademy.simplehttpservice.dto.UserResponseDto;
import com.ITAcademy.simplehttpservice.model.UserDetailsRequestModel;
import com.ITAcademy.simplehttpservice.service.IUserService;

@RestController
@RequestMapping("/api")
public class EmpleadoController {
	
    private final IUserService userService;

    @Autowired
    public EmpleadoController(IUserService userService){
        this.userService = userService;
    }

    @GetMapping("/test")
    public String helloGradle() {
        return "Hello Gradle!";
    }
    @GetMapping("/user/{uuid}")		
    public ResponseEntity<UserResponseDto> updatePrescription(
            @PathVariable(name="uuid") String user) throws Exception {


        UserResponseDto userResponseDto = userService.getUser("pp");

        System.out.println(userResponseDto.getName());
        System.out.println(userResponseDto.getSurname());
        System.out.println(userResponseDto.getGender());

        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);

    }
    
    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserDetailsRequestModel userDetails) {
		
    	UserResponseDto returnValue = new UserResponseDto();
    	returnValue.setName(userDetails.getName());
    	returnValue.setSurname(userDetails.getSurname());
    	returnValue.setDateOfBirth(userDetails.getDateOfBirth());
    	returnValue.setGender(userDetails.getGender());
    	return new ResponseEntity<UserResponseDto>(returnValue, HttpStatus.OK);   	
    }
    
    @PutMapping
    public String updateUser() {
    	return "update user was called";
    }
    
    @DeleteMapping
    public String deleteUser() {
    	return "delete user was called";
    }
}


