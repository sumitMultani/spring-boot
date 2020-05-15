package com.example.demoe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoe.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
