package com.jobinbasani.hateoas.web.assembler;

import com.jobinbasani.hateoas.entity.Task;
import com.jobinbasani.hateoas.web.rest.TaskController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class TaskAssembler implements SimpleRepresentationModelAssembler<Task> {
    @Override
    public void addLinks(EntityModel<Task> resource) {

    }

    @Override
    public void addLinks(CollectionModel<EntityModel<Task>> resources) {
        resources.add(linkTo(methodOn(TaskController.class)
                .getTasks())
                .withSelfRel()
                .andAffordance(afford(methodOn(TaskController.class).addTask(null))));
        resources.add(linkTo(methodOn(TaskController.class).root()).withRel("root"));
    }
}
