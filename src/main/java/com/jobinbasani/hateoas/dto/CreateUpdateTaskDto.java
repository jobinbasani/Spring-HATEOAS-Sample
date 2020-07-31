package com.jobinbasani.hateoas.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CreateUpdateTaskDto {
    @NotNull
    private String name;
    @NotNull
    private String description;
}
