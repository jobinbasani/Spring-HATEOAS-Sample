package com.jobinbasani.hateoas.service;

import com.jobinbasani.hateoas.dto.CreateTaskDto;
import com.jobinbasani.hateoas.dto.TaskInfoDto;
import com.jobinbasani.hateoas.entity.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<Task> getAllTasks();
    TaskInfoDto createTask(CreateTaskDto task);
    Optional<Task> getTask(Integer id);
    Optional<Task> deleteTask(Integer id);
}
