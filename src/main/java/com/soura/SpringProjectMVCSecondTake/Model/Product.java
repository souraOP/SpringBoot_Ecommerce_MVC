package com.soura.SpringProjectMVCSecondTake.Model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.GenerationType;
// Large Binary object
import jakarta.persistence.Lob;
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
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date releaseDate;
    private boolean productAvailable;
    private int stockQuantity;
    private String imageName;
    private String imageType;
    @Lob
    private byte[] imageData;

    public Product(int id){
        this.id = id;
    }
}
