package com.jobinbasani.hateoas.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Integer id;
    private String name;
    private String details;
    private LocalDate dueDate;
    private boolean isComplete;
}
