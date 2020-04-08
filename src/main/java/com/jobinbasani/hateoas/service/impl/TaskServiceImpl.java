package com.jobinbasani.hateoas.service.impl;

import com.jobinbasani.hateoas.dto.CreateTaskDto;
import com.jobinbasani.hateoas.dto.TaskInfoDto;
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
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public TaskInfoDto createTask(CreateTaskDto createTask) {
        Task task = taskRepository.save(new Task(createTask));
        return new TaskInfoDto(task);
    }

    @Override
    public Optional<Task> getTask(Integer id) {
        return taskRepository.findById(id);
    }

    @Override
    public void deleteTask(Task task) {
        taskRepository.delete(task);
    }
}
