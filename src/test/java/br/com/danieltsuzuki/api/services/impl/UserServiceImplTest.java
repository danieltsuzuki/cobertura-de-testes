package br.com.danieltsuzuki.api.services.impl;

import br.com.danieltsuzuki.api.domain.User;
import br.com.danieltsuzuki.api.domain.dto.UserDto;
import br.com.danieltsuzuki.api.repositories.UserRepository;
import br.com.danieltsuzuki.api.services.exceptions.DataIntegratyViolationException;
import br.com.danieltsuzuki.api.services.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

class UserServiceImplTest {
    public static final long ID = 1l;
    public static final String NAME = "teste";
    public static final String MAIL = "teste@mail.com";
    public static final String PASSWORD = "123";

    @InjectMocks
    private UserServiceImpl service; //Cria instancia real
    @Mock
    private UserRepository repository; //Cria instancia falsa
    @Mock
    private ModelMapper mapper;
    private User user;
    private UserDto dto;
    private Optional<User> optionalUser;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void whenFindByIdThenReturnAnUserInstance() {
        when(repository.findById(anyLong())).thenReturn(optionalUser);

        User response = service.findById(ID);

        assertNotNull(response);
        assertEquals(User.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(NAME, response.getName());
        assertEquals(MAIL, response.getEmail());
        assertEquals(PASSWORD, response.getPassword());
    }

    @Test
    void whenFindByIdThenReturnAnObjectNotFoundException() {
        when(repository.findById(anyLong())).thenThrow(new ObjectNotFoundException("Objeto nao encontrado"));

        try{
            service.findById(ID);
        } catch (Exception ex){
            assertEquals(ObjectNotFoundException.class, ex.getClass());
            assertEquals("Objeto nao encontrado", ex.getMessage());
        }

    }

    @Test
    void whenFindAllThenReturnAnListUsers() {
        when(repository.findAll()).thenReturn(Arrays.asList(user));

        List<User> response = service.findAll();

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(User.class, response.get(0).getClass());
        assertEquals(ID, response.get(0).getId());
        assertEquals(NAME, response.get(0).getName());
        assertEquals(MAIL, response.get(0).getEmail());
        assertEquals(PASSWORD, response.get(0).getPassword());
    }

    @Test
    void whenCreateThenReturnSuccess() {
        when(repository.save(any())).thenReturn(user);

        User response = service.create(dto);

        assertNotNull(response);
        assertEquals(User.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(NAME, response.getName());
        assertEquals(MAIL, response.getEmail());
        assertEquals(PASSWORD, response.getPassword());
    }

    @Test
    void whenCreateThenReturnAnDataIntegrityViolationException() {
        when(repository.findByEmail(anyString())).thenReturn(optionalUser);

        try{
            optionalUser.get().setEmail(MAIL);
            User response = service.create(dto);
        } catch (Exception ex){
            assertEquals(DataIntegratyViolationException.class, ex.getClass());
            assertEquals("Email ja cadastrado no sistema", ex.getMessage());
        }

    }

    @Test
    void whenUpdateThenReturnSuccess() {
        when(repository.save(any())).thenReturn(user);

        User response = service.update(dto);

        assertNotNull(response);
        assertEquals(User.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(NAME, response.getName());
        assertEquals(MAIL, response.getEmail());
        assertEquals(PASSWORD, response.getPassword());
    }

    @Test
    void whenUpdateThenReturnAnDataIntegrityViolationException() {
        when(repository.findByEmail(anyString())).thenReturn(optionalUser);

        try{
            optionalUser.get().setEmail(MAIL);
            User response = service.create(dto);
        } catch (Exception ex){
            assertEquals(DataIntegratyViolationException.class, ex.getClass());
            assertEquals("Email ja cadastrado no sistema", ex.getMessage());
        }

    }

    @Test
    void delete() {
    }

    private void startUser(){
        user = new User(ID, NAME, MAIL, PASSWORD);
        dto = new UserDto(ID, NAME, MAIL, PASSWORD);
        optionalUser = Optional.of(new User(ID, NAME, MAIL, PASSWORD));
    }

}