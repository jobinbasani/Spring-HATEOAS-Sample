package com.jobinbasani.hateoas.repository;

import com.jobinbasani.hateoas.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@Repository
@RestResource(exported = false)
public interface TaskRepository extends JpaRepository<Task, Integer> {
}
