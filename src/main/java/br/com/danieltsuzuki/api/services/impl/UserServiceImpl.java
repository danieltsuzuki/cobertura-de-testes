package br.com.danieltsuzuki.api.services.impl;

import br.com.danieltsuzuki.api.domain.User;
import br.com.danieltsuzuki.api.domain.dto.UserDto;
import br.com.danieltsuzuki.api.repositories.UserRepository;
import br.com.danieltsuzuki.api.services.UserService;
import br.com.danieltsuzuki.api.services.exceptions.DataIntegratyViolationException;
import br.com.danieltsuzuki.api.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado"));
    }

    @Override
    public List<User> findAll(){
        return repository.findAll();
    }

    @Override
    public User create(UserDto dto) {
        findByEmail(dto);
        return repository.save(mapper.map(dto, User.class));
    }

    @Override
    public User update(UserDto dto) {
        findByEmail(dto);
        return repository.save(mapper.map(dto, User.class));
    }

    @Override
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    private void findByEmail(UserDto dto){
        Optional<User> user = repository.findByEmail(dto.getEmail());
        if(user.isPresent() && user.get().getId().equals(dto.getId())){
            throw new DataIntegratyViolationException("Email ja cadastrado no sistema");
        }
    }

}
