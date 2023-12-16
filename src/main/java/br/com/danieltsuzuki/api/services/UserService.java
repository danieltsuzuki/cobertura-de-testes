package br.com.danieltsuzuki.api.services;

import br.com.danieltsuzuki.api.domain.User;

public interface UserService {

    User findById(Long id);

}
