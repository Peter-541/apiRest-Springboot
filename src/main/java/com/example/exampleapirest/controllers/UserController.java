package com.example.exampleapirest.controllers;

import com.example.exampleapirest.models.UserModel;
import com.example.exampleapirest.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping()
    public ArrayList<UserModel> getAllUsers(){
        return userService.getALlUsers();
    }

    @PostMapping()
    public UserModel saveUser(@RequestBody UserModel users){
        return  this.userService.saveUser(users);
    }

    @GetMapping(path = "/{id}")
    public Optional<UserModel> searchByID(@PathVariable("id") Long id){
        return this.userService.searchByID(id);
    }

    @GetMapping(path = "/query")
    public ArrayList<UserModel> findByName(@RequestParam("name") String name){
        return this.userService.findByName(name);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteUserByID(@PathVariable("id")Long id){
        boolean ok = this.userService.deleteUser(id);

        if(ok){
            return("The user with the ID:"+id+" was DELETED");
        } else{
            return("The user with the ID:"+id+" was NOT DELETED");
        }
    }

    @PutMapping()
    public UserModel updateUser(@RequestBody UserModel users){
        return  this.userService.saveUser(users);
    }
}
