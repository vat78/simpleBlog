package ru.vat78.simpleBlog.services;


import org.springframework.data.repository.CrudRepository;
import ru.vat78.simpleBlog.model.User;

public interface UsersRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);
}
