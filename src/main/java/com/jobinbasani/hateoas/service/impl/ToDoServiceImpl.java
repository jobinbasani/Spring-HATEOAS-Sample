package com.jobinbasani.hateoas.service.impl;

import com.jobinbasani.hateoas.entity.ToDo;
import com.jobinbasani.hateoas.repository.ToDoRepository;
import com.jobinbasani.hateoas.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ToDoServiceImpl implements ToDoService {

    private final ToDoRepository toDoRepository;

    @Override
    public List<ToDo> getAllToDoItems() {
        return toDoRepository.findAll();
    }

    @Override
    public ToDo addToDo(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    @Override
    public Optional<ToDo> getToDo(Integer id) {
        return toDoRepository.findById(id);
    }

    @Override
    public void deleteToDo(ToDo toDo) {
        toDoRepository.delete(toDo);
    }
}
