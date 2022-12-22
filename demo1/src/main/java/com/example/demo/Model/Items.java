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
public class Items {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer code;
     @NotNull(message = "SupplierID must be filled!")
     private Integer SId;
     @NotEmpty(message = "Item Name must be filled!")
     @Column(columnDefinition = "varchar(100) not null")
     @Size(min = 3,max = 20,message = "Name must be more than 2 letters")
     private String name;
     @NotNull(message = "Quantity must be filled!")
     @Column(columnDefinition ="int")
     private Integer quantity;
     @NotNull(message = "Price must be filled!")
     @Column(columnDefinition ="int")
     private Integer price;

}
