package com.jpabuddy.spring.demo.jpademo.repositories;

import com.jpabuddy.spring.demo.jpademo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u where u.name = :name")
    List<User> findByName(String name);
}
