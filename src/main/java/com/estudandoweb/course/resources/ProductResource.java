package com.estudandoweb.course.resources;

import com.estudandoweb.course.entities.Product;
import com.estudandoweb.course.entities.User;
import com.estudandoweb.course.services.ProductServices;
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
@RequestMapping(value = "/products") //RESPONDE NO CAMINHO USERS

public class ProductResource {
    //Camada de recursos são os controladores rest
 //dependencia para o service
    @Autowired
    private ProductServices productServices;

    //método que responde a requisição do tipo GET HTTP
    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> list = productServices.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Product obj = productServices.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
