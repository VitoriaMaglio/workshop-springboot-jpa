package com.estudandoweb.course.resources;

import com.estudandoweb.course.entities.User;
import com.estudandoweb.course.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping

    public ResponseEntity<User> insert(@RequestBody User obj) {
        obj = userService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
    //quando vc vai inserir um obj tem que ser com requisição http POST

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
    //erro quando tenta apagar user com associações

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj) {
        obj = userService.update(id, obj);
        return ResponseEntity.ok().body(obj);//atualizar recurso com requisição PUT
    }
}
