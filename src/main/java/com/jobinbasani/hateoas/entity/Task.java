package com.jobinbasani.hateoas.entity;

import com.jobinbasani.hateoas.dto.CreateTaskDto;
import com.jobinbasani.hateoas.enums.TaskStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;

    public Task(CreateTaskDto createTask){
        this.name = createTask.getName();
        this.description = createTask.getDescription();
        taskStatus = TaskStatus.OPEN;
    }
}
