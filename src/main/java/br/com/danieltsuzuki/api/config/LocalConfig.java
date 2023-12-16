package br.com.danieltsuzuki.api.config;

import br.com.danieltsuzuki.api.domain.User;
import br.com.danieltsuzuki.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UserRepository repository;
    @Bean
    public String startDB(){
        User u1 = new User(null, "Daniel", "daniel@mail.com", "123");
        User u2 = new User(null, "Adrielly", "adrielly@mail.com", "123");

        repository.saveAll(List.of(u1, u2));
        return null;
    }

}
