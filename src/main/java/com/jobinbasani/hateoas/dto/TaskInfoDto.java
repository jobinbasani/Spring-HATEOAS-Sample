package com.jobinbasani.hateoas.dto;

import com.jobinbasani.hateoas.entity.Task;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class TaskInfoDto extends CreateUpdateTaskDto {
    private Integer id;

    public TaskInfoDto(Task task) {
        this.id = task.getId();
        setName(task.getName());
        setDescription(task.getDescription());
    }
}
