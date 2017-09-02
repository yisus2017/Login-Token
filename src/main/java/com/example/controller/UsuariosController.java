package com.example.controller;


import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuariosController {

    @GetMapping(path = "/users")
    public List<Usuario> getUsers(){
        return Arrays.asList(new Usuario(1,"Paco"), new Usuario(2,"Pedro"), new Usuario(3, "Juan"));
    }
}