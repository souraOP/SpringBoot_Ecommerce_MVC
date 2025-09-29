package com.soura.SpringProjectMVCSecondTake.Model;


import jakarta.persistence.Entity;
import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String productName;
    private String productDescription;
    private String brand;
    private BigDecimal price;
    private String category;
    private Date releaseDate;
    private boolean productAvailable;
    private int stockQuantity;
}
