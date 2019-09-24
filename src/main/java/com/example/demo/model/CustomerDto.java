package com.example.demo.model;

import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.hateoas.config.EnableEntityLinks;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    @Id
    private int id;
    @NotNull(message = "Please provide a name")
    @Size(min=2, max = 12,message="Name should have at least 2 characters")
    private String name;
}

