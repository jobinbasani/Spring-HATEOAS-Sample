package com.jobinbasani.hateoas.service.impl;

import com.jobinbasani.hateoas.dto.CreateUpdateTaskDto;
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
    public TaskInfoDto createTask(CreateUpdateTaskDto createTask) {
        Task task = taskRepository.save(new Task(createTask));
        return new TaskInfoDto(task);
    }

    @Override
    public Optional<Task> getTask(Integer id) {
        return taskRepository.findById(id);
    }

    @Override
    public Optional<Task> deleteTask(Integer id) {
        return taskRepository.findById(id)
                .map(task -> {
                    taskRepository.deleteById(task.getId());
                    return task;
                });
    }

    @Override
    public Optional<TaskInfoDto> updateTask(Integer id, CreateUpdateTaskDto updatedTask) {
        return taskRepository.findById(id)
                .map(task -> {
                    task.setDescription(updatedTask.getDescription());
                    task.setName(updatedTask.getName());
                    taskRepository.save(task);
                    return task;
                })
                .map(TaskInfoDto::new);
    }
}
