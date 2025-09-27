package com.estudandoweb.course.entities;

import com.estudandoweb.course.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
@Entity
@Table(name = "tb_order")
public class Order implements Serializable{

    private static final long serialVersionUID=1L;
    @Id //indicando q é a pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //formatar data
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;
    private Integer orderStatus; //aqui vc troca o nome da enum por um num inteiro para mostrar q no banco vc está gravando um num int

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;
    //isso é um relacionamento entre User e Order pq um cliente pode ter vários pedidos
    //logo no banco de dados iso é uma fk que entra na classe Order N-1

    public Order() {
    }

    public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
        this.id = id;
        this.moment = moment;
        setOrderStatus(orderStatus);
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);//converter o num inteiro para tipo enum OrderStatus -> valueOf
    }

    public void setOrderStatus(OrderStatus orderStatus) {//aqui vc recebe um vlor tipo enum e tem que guardar um num int
        if (orderStatus != null){
        this.orderStatus = orderStatus.getCode();}
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
