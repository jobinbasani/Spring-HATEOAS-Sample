package com.jobinbasani.hateoas.service;

import com.jobinbasani.hateoas.entity.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<Task> getAllToDoItems();
    Task addToDo(Task task);
    Optional<Task> getToDo(Integer id);
    void deleteToDo(Task task);
}
