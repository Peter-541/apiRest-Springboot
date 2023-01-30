package com.example.exampleapirest.services;

import com.example.exampleapirest.models.UserModel;
import com.example.exampleapirest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public ArrayList<UserModel> getALlUsers(){
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public UserModel saveUser(UserModel users){
        return userRepository.save(users);
    }

    public Optional<UserModel> searchByID(Long id){
        return userRepository.findById(id);
    }

    public ArrayList<UserModel> findByName(String name){
        return userRepository.findByName(name);
    }

    public boolean deleteUser(Long id){
        try{
            userRepository.deleteById(id);
            return true;
        }catch(Exception error){
            return false;
        }
    }

    public UserModel updateUser(UserModel users){
        return userRepository.save(users);
    }
}
