package br.com.danieltsuzuki.api.services;

import br.com.danieltsuzuki.api.domain.User;
import br.com.danieltsuzuki.api.domain.dto.UserDto;

import java.util.List;

public interface UserService {

    User findById(Long id);

    List<User> findAll();

    User create(UserDto dto);

    User update(UserDto dto);

}
