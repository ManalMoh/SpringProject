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
@Entity //make the values as a table
@NoArgsConstructor //for the database
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "Supplier ID must be filled!")
    private Integer ID;
    @NotEmpty(message = "Name must be filled!")
    @Column(columnDefinition = "varchar(100) not null")
    @Size(min = 3,max = 20,message = "Name must be more than 2 letters")
    private String  name;
    @NotEmpty(message = "Name must be filled!")
    @Column(columnDefinition = "varchar(100) not null unique ")
    @Size(min = 3,max = 20,message = "Region must be more than 2 letters")
    private String region;
    @NotNull(message = "Item code must be filled!")
    @Column(columnDefinition = "int")
    private Integer itemCode;

}
