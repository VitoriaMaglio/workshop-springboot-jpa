package com.estudandoweb.course.services;

import com.estudandoweb.course.entities.Order;
import com.estudandoweb.course.entities.User;
import com.estudandoweb.course.repositories.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//essa camada repassa as ações para camada repositories
@Service
public class OrderServices {
    @Autowired //indica que tem uma dependência à camada repositories de acesso ao banco
    private OrderRepository orderRepository;

    public List<Order> findAll(){
        return orderRepository.findAll();
    }
    public Order findById(Long id){
        Optional<Order> obj = orderRepository.findById(id);
        return obj.get();
    }


}
