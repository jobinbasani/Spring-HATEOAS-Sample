package com.jobinbasani.hateoas.service.impl;

import com.jobinbasani.hateoas.entity.Task;
import com.jobinbasani.hateoas.repository.TaskRepository;
import com.jobinbasani.hateoas.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public List<Task> getAllToDoItems() {
        return taskRepository.findAll();
    }

    @Override
    public Task addToDo(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Optional<Task> getToDo(Integer id) {
        return taskRepository.findById(id);
    }

    @Override
    public void deleteToDo(Task task) {
        taskRepository.delete(task);
    }
}
