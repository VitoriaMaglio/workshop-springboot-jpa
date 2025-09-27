package com.estudandoweb.course.resources;

import com.estudandoweb.course.entities.Category;
import com.estudandoweb.course.entities.Order;
import com.estudandoweb.course.services.CategoryService;
import com.estudandoweb.course.services.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//controlador rest -> controla as requisições do user

@RestController
@RequestMapping(value = "/categories") //RESPONDE NO CAMINHO plural

public class CategoryResource {
    //Camada de recursos são os controladores rest
 //dependencia para o service
    @Autowired
    private CategoryService service;

    //método que responde a requisição do tipo GET HTTP
    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> list = service.findAll();
        return ResponseEntity.ok().body(list);
        //retorna sucesso da requisição

    }
    @GetMapping(value = "/{id}")//indica que essa url recebe um id
    public ResponseEntity<Category> findById(@PathVariable Long id){
        Category obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
