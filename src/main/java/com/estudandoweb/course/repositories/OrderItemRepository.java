package com.estudandoweb.course.repositories;

import com.estudandoweb.course.entities.OrderItem;
import com.estudandoweb.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    //ela já herda do JpaRepos. então não precisa ser declarada novamente como um componente ou repository
    // repositórios são a última camada do projeto e são interfaces
    // faz ações na banco de dados, tem acesso aos dados do banco
}
