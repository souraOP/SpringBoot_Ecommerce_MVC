package com.soura.SpringProjectMVCSecondTake.Model.dto;

import java.math.BigDecimal;

public record OrderItemResponse(
    String productName,
    int quantity,
    BigDecimal totalPrice
){}
