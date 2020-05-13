package com.example.ProjectWEB.repository;

import com.example.ProjectWEB.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    public User findById(long id);
    public User findByEmail(String email);

}
