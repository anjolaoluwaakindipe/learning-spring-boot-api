package com.learningspringboot.learningspringboot.ui;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import com.learningspringboot.learningspringboot.ui.exceptions.UserServiceException;
import com.learningspringboot.learningspringboot.ui.model.request.UpdateUserRequest;
import com.learningspringboot.learningspringboot.ui.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    Map<String, User> users;
    @Autowired
    UserService userService;

    @GetMapping()
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "limit", defaultValue = "50") int limit,
            @RequestParam(value = "sort", required = false) String sort) {
        return "get user was called with page= " + page + " and limit= " + limit + " and sort = " + sort;
    }

    @GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<User> getUser(@PathVariable String userId) {

        // if (true)
        // throw new UserServiceException("A user service Exception is thrown");

        if (users.containsKey(userId)) {
            return new ResponseEntity<User>(users.get(userId), HttpStatus.BAD_REQUEST);

        } else {
            return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
            MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<User> createUser(@Valid @RequestBody User userDetail) {
        User newUser = userService.createUser(userDetail);
        return new ResponseEntity<User>(newUser, HttpStatus.OK);
    }

    @PutMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, consumes = {
            MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, path = "/{userId}")
    public User updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserRequest userUpdateDetails) {
        User storedUserDetails = users.get(userId);

        storedUserDetails.setFirstName(userUpdateDetails.getFirstName());
        storedUserDetails.setLastName(userUpdateDetails.getLastName());

        return storedUserDetails;

    }

    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        if (users.containsKey(userId))
            users.remove(userId);
        return ResponseEntity.noContent().build();
    }
}
