package com.estudandoweb.course.services;

import com.estudandoweb.course.entities.Product;
import com.estudandoweb.course.entities.User;
import com.estudandoweb.course.repositories.ProductRepository;
import com.estudandoweb.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//essa camada repassa as ações para camada repositories
@Service
public class ProductServices {
    @Autowired //indica que tem uma dependência à camada repositories de acesso ao banco
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }
    public Product findById(Long id){
        Optional<Product> obj = productRepository.findById(id);
        return obj.get();
    }


}
