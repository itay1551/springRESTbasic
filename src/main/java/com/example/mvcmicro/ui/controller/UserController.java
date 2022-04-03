package com.example.mvcmicro.ui.controller;

import com.example.mvcmicro.ui.model.response.UserRest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users") //http://localhost:8080/users
public class UserController {
    
    @GetMapping
    public String getUser(@RequestParam(value="page" , defaultValue= "1") int page , @RequestParam(value="limit" , defaultValue="50") int limit,
    @RequestParam(value="sort" , defaultValue="desc") String sort){
        return "get user was called page: " + page + " limit: " + limit;
    }

    //@RequestMapping(method=RequestMethod.GET)
    @GetMapping(path = "/{userId}" ,
                produces = {
                    MediaType.APPLICATION_XML_VALUE, 
                    MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> getUser(@PathVariable String userId){
        UserRest myUser = new UserRest("itay", "katav", "itay@gmail.com", userId);
        return new ResponseEntity<>(myUser , HttpStatus.OK );
    }

    @PostMapping
    public String createUser(){
        return "create user called";
    }

    @PutMapping
    public String updateUser(){
        return "update user called";
    }

    @DeleteMapping
    public String deleteUser(){
        return "delate user called";
    }

}
