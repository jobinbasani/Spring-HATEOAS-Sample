package com.jobinbasani.hateoas.entity;

import com.jobinbasani.hateoas.dto.CreateUpdateTaskDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.AUTO;

@Data
@Entity
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Integer id;
    private String name;
    private String description;

    public Task(CreateUpdateTaskDto createTask){
        this.name = createTask.getName();
        this.description = createTask.getDescription();
    }
}
