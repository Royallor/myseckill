package com.adder.myseckill.controller;

import com.adder.myseckill.entity.Users;
import com.adder.myseckill.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersHandler {

    @Autowired
    private UsersRepository usersRepository;
    @GetMapping("/findAll")
    public List<Users> findAll(){
        return usersRepository.findAll();
    }

}
