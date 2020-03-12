package com.jobinbasani.hateoas.web.assembler;

import com.jobinbasani.hateoas.entity.ToDo;
import com.jobinbasani.hateoas.web.rest.ToDoController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ToDoAssembler implements SimpleRepresentationModelAssembler<ToDo> {
    @Override
    public void addLinks(EntityModel<ToDo> resource) {

    }

    @Override
    public void addLinks(CollectionModel<EntityModel<ToDo>> resources) {
        resources.add(linkTo(methodOn(ToDoController.class)
                .getAllToDoItems())
                .withSelfRel());
        resources.add(linkTo(methodOn(ToDoController.class).root()).withRel("root"));
    }
}
