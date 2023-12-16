package br.com.danieltsuzuki.api.services.impl;

import br.com.danieltsuzuki.api.domain.User;
import br.com.danieltsuzuki.api.repositories.UserRepository;
import br.com.danieltsuzuki.api.services.UserService;
import br.com.danieltsuzuki.api.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado"));
    }
}
