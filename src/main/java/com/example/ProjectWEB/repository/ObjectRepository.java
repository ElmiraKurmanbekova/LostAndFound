package com.example.ProjectWEB.repository;

import com.example.ProjectWEB.entity.Objects;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ObjectRepository extends JpaRepository<Objects,Long> {
    public Objects findByid(long id);

    List<Objects> findByStatus(String status);
}
