package br.com.danieltsuzuki.api.repositories;

import br.com.danieltsuzuki.api.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
