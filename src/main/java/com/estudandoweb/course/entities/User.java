package com.estudandoweb.course.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Entity
@Table(name = "tb_user")//renomeand pq User é um nome específico q pd dar conflitos
//indica que essa classa vais er uma tabela no banco de dados
public class User implements Serializable {

    private static final long serialVersionUID=1L;

    @Id //indicando q é a pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String fone;
    private String password;
    private List<Order> orders = new ArrayList<>();//coleção


    //para representar o lado 1-N colocar essa anotação passando o nome da dependencia da outra classe
    @JsonIgnore //esse comando impede que vire uma associação de mão dupla e cai em um loop
    @OneToMany(mappedBy = "client")
    public List<Order> getOrders() {
        return orders;
    }
    //Usando framework é obrigatório declarar construtor vazio

    public User() {
    }

    public User(Long id, String name, String email, String fone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.fone = fone;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
