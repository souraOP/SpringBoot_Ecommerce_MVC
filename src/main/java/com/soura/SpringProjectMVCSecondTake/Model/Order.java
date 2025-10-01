package com.soura.SpringProjectMVCSecondTake.Model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity(name="order")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {
    @Id
    private long id;
    @Column(unique = true)
    private String orderId;
    private String customerName;
    private String email;
    private String status;
    private LocalDate orderDate;
    @OneToMany(mappedBy="order", cascade=CascadeType.ALL)
    private List<OrderItem> orderItems;
}
