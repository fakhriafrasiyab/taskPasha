package com.example.demo.model;

import lombok.*;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerDto {
    private int id;

    @NotNull(message = "Please provide a name")
    @Size(min = 2, max = 12, message = "Name should have at least 2 characters")
    private String name;

}

