package com.jobinbasani.hateoas.web.rest;

import com.jobinbasani.hateoas.dto.CreateUpdateTaskDto;
import com.jobinbasani.hateoas.dto.TaskInfoDto;
import com.jobinbasani.hateoas.entity.Task;
import com.jobinbasani.hateoas.service.TaskService;
import com.jobinbasani.hateoas.web.assembler.TaskAssembler;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class TaskController {
    private final TaskService taskService;
    private final TaskAssembler taskAssembler;

    @GetMapping("/")
    public RepresentationModel root() {
        RepresentationModel rootModel = new RepresentationModel();
        rootModel.add(linkTo(methodOn(this.getClass()).root()).withSelfRel(),
                linkTo(methodOn(this.getClass()).getTasks()).withRel("task-list").withTitle("List of Tasks"));
        return rootModel;
    }

    @GetMapping("/task-list")
    public ResponseEntity<CollectionModel<EntityModel<Task>>> getTasks() {
        CollectionModel<EntityModel<Task>> entityModels = taskAssembler.toCollectionModel(taskService.getAllTasks());
        return ResponseEntity.ok(entityModels);
    }

    @GetMapping("/task/{id}")
    public ResponseEntity<EntityModel<Task>> getTask(@PathVariable("id") Integer id){
        return taskService.getTask(id)
                .map(taskAssembler::toModel)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/task/{id}")
    public ResponseEntity<Task> deleteTask(@PathVariable("id") Integer id){
        return taskService.deleteTask(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/task/{id}")
    public ResponseEntity<TaskInfoDto> updateTask(@PathVariable("id") Integer id, @RequestBody CreateUpdateTaskDto updatedTask){
        return taskService.updateTask(id,updatedTask)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/task-list")
    public TaskInfoDto addTask(@RequestBody CreateUpdateTaskDto task) {
        return taskService.createTask(task);
    }

}
