package br.com.danieltsuzuki.api.resources;

import br.com.danieltsuzuki.api.domain.User;
import br.com.danieltsuzuki.api.domain.dto.UserDto;
import br.com.danieltsuzuki.api.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/user")
public class UserResource {

    public static final String ID = "/{id}";

    @Autowired
    private UserService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping(value = ID)
    public ResponseEntity<UserDto> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(mapper.map(service.findById(id), UserDto.class));
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll(){
        List<UserDto> listDTO = service.findAll().stream().map(x -> mapper.map(x, UserDto.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody UserDto dto){
        User newUser = service.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path(ID).buildAndExpand(newUser.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = ID)
    public ResponseEntity<UserDto> update(@PathVariable Long id, @RequestBody UserDto dto){
        dto.setId(id);
        User newUser = service.update(dto);
        return ResponseEntity.ok().body(mapper.map(newUser, UserDto.class));
    }

    @DeleteMapping(value = ID)
    public ResponseEntity<UserDto> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
