package com.jpabuddy.spring.demo.jpademo.repositories;

import com.jpabuddy.spring.demo.jpademo.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    @Query("select a from AppUser a where a.name = :name")
    List<AppUser> findByName(String name);
}
