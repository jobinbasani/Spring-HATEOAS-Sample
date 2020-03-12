package com.jobinbasani.hateoas.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.time.LocalDate;

import static javax.persistence.GenerationType.*;

@Entity
@Data
@NoArgsConstructor
public class ToDo {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Integer id;
    private String name;
    private String details;
    private LocalDate dueDate;
    private boolean isComplete;
}
