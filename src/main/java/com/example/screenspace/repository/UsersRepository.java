package com.example.screenspace.repository;

import com.example.screenspace.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {

    User findByEmailAndPassword(String email, String password);
    User findByEmail(String email);
}
