package com.estudandoweb.course.resources;

import com.estudandoweb.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users") //RESPONDE NO CAMINHO USERS
public class UserResource {
    //Camada de recursos são os controladores rest

    //método que responde a requisição do tipo GET HTTP
    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User(1L, "Vi", "vi@", "11999999", "12324");
        return ResponseEntity.ok().body(u);

    }
}
