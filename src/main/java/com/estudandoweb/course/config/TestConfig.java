package com.estudandoweb.course.config;

import com.estudandoweb.course.entities.Category;
import com.estudandoweb.course.entities.Order;
import com.estudandoweb.course.entities.User;
import com.estudandoweb.course.entities.enums.OrderStatus;
import com.estudandoweb.course.repositories.CategoryRepository;
import com.estudandoweb.course.repositories.OrderRepository;
import com.estudandoweb.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

//classe específica de configuração de teste
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
//popular banco de dados, para isso depende da camada repositry, ent tem uma dependencia fraca
    //Spring tem uma regra para dependencia
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired//injeção de dependência
    private CategoryRepository categoryRepository;


    @Override
    public void run(String... args) throws Exception {
        //category é uma classe independente de order e user
        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3)); //intnciando no banco

        //tudo dentro desse método vai sser executado quando a aplicçã rodar
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
        //salvar esses dois objetos no banco
        userRepository.saveAll(Arrays.asList(u1,u2));
        //.saveAll espera uma lista para salvar no banco
        //executa sozinho insert nas tabelas

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.DELIVERED, u1);


        orderRepository.saveAll(Arrays.asList(o1,o2,o3));





    }
}
