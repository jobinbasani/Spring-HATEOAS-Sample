package com.jobinbasani.hateoas.dto;

import com.jobinbasani.hateoas.entity.Task;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class TaskInfoDto extends CreateTaskDto {
    private Integer id;
    private String status;

    public TaskInfoDto(Task task) {
        this.id = task.getId();
        this.status = task.getTaskStatus().toString();
        setName(task.getName());
        setDescription(task.getDescription());
    }
}
