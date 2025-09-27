package com.estudandoweb.course.services;

import com.estudandoweb.course.entities.User;
import com.estudandoweb.course.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//essa camada repassa as ações para camada repositories
@Service
@Transactional
public class UserServices  {
    @Autowired //indica que tem uma dependência à camada repositories de acesso ao banco
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }
    public User findById(Long id){
        Optional<User> obj = userRepository.findById(id);
        return obj.get();
    }

    public User insert(User obj) {
        return userRepository.save(obj);//inserindo no banco de dados um novo objeto usuário
    }


}
