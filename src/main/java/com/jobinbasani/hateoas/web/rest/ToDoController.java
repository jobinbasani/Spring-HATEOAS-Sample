package com.jobinbasani.hateoas.web.rest;

import com.jobinbasani.hateoas.entity.ToDo;
import com.jobinbasani.hateoas.service.ToDoService;
import com.jobinbasani.hateoas.web.assembler.ToDoAssembler;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequiredArgsConstructor
public class ToDoController {
    private final ToDoService toDoService;
    private final ToDoAssembler toDoAssembler;

    @GetMapping("/")
    public RepresentationModel root() {
        RepresentationModel rootModel = new RepresentationModel();
        rootModel.add(linkTo(methodOn(this.getClass()).root()).withSelfRel(),
                linkTo(methodOn(this.getClass()).getAllToDoItems()).withRel("todo-list").withTitle("List of To Do items"));
        return rootModel;
    }

    @GetMapping("/todo-list")
    public ResponseEntity<CollectionModel<EntityModel<ToDo>>> getAllToDoItems() {
        return ResponseEntity.ok(toDoAssembler.toCollectionModel(toDoService.getAllToDoItems()));
    }

    @PostMapping("/todo-list")
    public ToDo addToDo(@RequestBody ToDo toDo) {
        return toDoService.addToDo(toDo);
    }

}
