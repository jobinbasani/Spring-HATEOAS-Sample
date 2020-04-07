package com.jobinbasani.hateoas.web.rest;

import com.jobinbasani.hateoas.entity.Task;
import com.jobinbasani.hateoas.service.TaskService;
import com.jobinbasani.hateoas.web.assembler.TaskAssembler;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.mediatype.Affordances;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.MediaTypes.HAL_FORMS_JSON_VALUE;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class TaskController {
    private final TaskService taskService;
    private final TaskAssembler taskAssembler;

    @GetMapping("/")
    public RepresentationModel root() {
        RepresentationModel rootModel = new RepresentationModel();
        var selfLink = Affordances.of(linkTo(methodOn(this.getClass()).root()).withSelfRel())
                .afford(HttpMethod.POST)
                .withInputAndOutput(Task.class)
                .withName("create-task")
                .toLink();
        rootModel.add(selfLink,
                linkTo(methodOn(this.getClass()).getAllToDoItems()).withRel("task-list").withTitle("List of Tasks"));
        return rootModel;
    }

    @GetMapping("/task-list")
    public ResponseEntity<CollectionModel<EntityModel<Task>>> getAllToDoItems() {
        return ResponseEntity.ok(taskAssembler.toCollectionModel(taskService.getAllToDoItems()));
    }

    @PostMapping("/task-list")
    public Task addTask(@RequestBody Task task) {
        return taskService.addToDo(task);
    }

}
