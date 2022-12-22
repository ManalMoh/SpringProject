package com.example.demo.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Stores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;
    @NotEmpty(message = "Location must be filled!")
    @Column(columnDefinition = "varchar(100) not null unique ")
    @Size(min = 3,max = 20,message = "Location must be more than 2 letters")
    private String location;
    @NotNull(message = "Supplier ID must be filled!")
    @Column(columnDefinition = "int")
    private Integer SId;


}
