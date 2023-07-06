package com.example.Simple.Project.controller;

import com.example.Simple.Project.model.User;
import com.example.Simple.Project.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserRepo userRepo;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id){
        List<User> users=userRepo.findAll();
        for(User user:users){
            if(user.getUserId()==id)return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> users=userRepo.findAll();
        if(users.isEmpty())return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @PostMapping
    public String addUser(@Validated @RequestBody User user){
        User entry = userRepo.save(user);
        if(entry==null)return "Please add a valid user(*_*)";
        return "User added successfully";
    }

}
