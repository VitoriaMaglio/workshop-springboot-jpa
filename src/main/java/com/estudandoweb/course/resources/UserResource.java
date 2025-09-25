package com.estudandoweb.course.resources;

import com.estudandoweb.course.entities.User;
import com.estudandoweb.course.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//controlador rest -> controla as requisições do user

@RestController
@RequestMapping(value = "/users") //RESPONDE NO CAMINHO USERS

public class UserResource {
    //Camada de recursos são os controladores rest
 //dependencia para o service
    @Autowired
    private UserServices userService;

    //método que responde a requisição do tipo GET HTTP
    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> list = userService.findAll();

        return ResponseEntity.ok().body(list);
        //retorna sucesso da requisição

    }

    @GetMapping(value = "/{id}")//indica que essa url recebe um id
    public ResponseEntity<User> findById(@PathVariable Long id){
        User obj = userService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
