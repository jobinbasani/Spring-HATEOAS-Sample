package com.jobinbasani.hateoas.service;

import com.jobinbasani.hateoas.entity.ToDo;

import java.util.List;
import java.util.Optional;

public interface ToDoService {
    List<ToDo> getAllToDoItems();
    ToDo addToDo(ToDo toDo);
    Optional<ToDo> getToDo(Integer id);
    void deleteToDo(ToDo toDo);
}
