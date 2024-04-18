package org.blitmatthew.ecom.controller;

import org.blitmatthew.ecom.dto.PostNewUser;
import org.blitmatthew.ecom.dto.UserInfo;
import org.blitmatthew.ecom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = {"", "/"})
    public ResponseEntity<UserInfo> createUser(@RequestBody PostNewUser postNewUser) {
        return new ResponseEntity<>(userService.addUser(postNewUser), HttpStatus.CREATED);
    }

    @GetMapping(value = {"", "/"})
    public ResponseEntity<List<UserInfo>> getUsers() {
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }
}
