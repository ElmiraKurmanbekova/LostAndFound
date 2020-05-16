package com.example.ProjectWEB.repository;

import com.example.ProjectWEB.entity.Objects;
import com.example.ProjectWEB.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ObjectRepository extends JpaRepository<Objects,Long> {

    Objects findById(long id);

    List<Objects> findByStatus(Status status);
}
